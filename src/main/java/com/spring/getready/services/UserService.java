package com.spring.getready.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.model.UserDetail;
import com.spring.getready.model.UserGroup;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.repository.UserGroupRepository;
import com.spring.getready.template.model.UserTemplate;

@Service
public class UserService {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private UserGroupRepository userGroupRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private FilePropertyConfig filePropertyConfig;

	public boolean uploadUsers(String path) {
		boolean result = false;
		Timestamp date = new Timestamp(new Date().getTime());
		File file = new File(path);
		if (file.exists()) {
			try {
				String users = new String(Files.readAllBytes(Paths.get(file.toURI())));
				ObjectMapper objectMapper = new ObjectMapper();
				List<UserTemplate> allUsersList = objectMapper.readValue(users,
						new TypeReference<List<UserTemplate>>() {
						});
				List<UserDetail> newUsers = new ArrayList<UserDetail>();
				for (int i = 0; i < allUsersList.size(); i++) {
					UserTemplate user = allUsersList.get(i);
					String password = passwordEncoder.encode(filePropertyConfig.getDefaultPassword()).toString();
					UUID uuid = UUID.nameUUIDFromBytes(user.getEmail().getBytes("utf-8"));
					Optional<UserGroup> userGroup = userGroupRepository.findById(user.getGroup());
					if (userGroup.isPresent()) {
						UserDetail newUser = new UserDetail();
						newUser.setUsername(user.getUsername());
						newUser.setPassword(password);
						newUser.setEmail(user.getEmail());
						newUser.setUserUuid(uuid.toString());
						newUser.setCreatedOn(date);
						newUser.setIsLocked(false);
						newUser.setUserGroup(userGroup.get());
						newUsers.add(newUser);
					}
				}
				if (newUsers.size() > 0) {
					List<UserDetail> savedUsers = userDetailRepository.saveAll(newUsers);
					if (savedUsers.size() > 0) {
						result = true;
					}
				}
			} catch (IOException e) {
				System.out.println("IOException occurs");
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean resetUser(int userId) {
		boolean result = false;
		String password = passwordEncoder.encode(filePropertyConfig.getDefaultPassword()).toString();
		Optional<UserDetail> userDetail = userDetailRepository.findById(userId);
		if (userDetail.isPresent()
				&& !userDetail.get().getUserGroup().getGroupName().toLowerCase().contentEquals("admin")) {
			UserDetail user = userDetail.get();
			user.setPassword(password);
			user.setIsLocked(false);
			userDetailRepository.save(user);
			result = true;
		}
		return result;
	}

}
