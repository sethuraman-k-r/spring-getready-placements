package com.spring.getready.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.model.ProfileInfo;
import com.spring.getready.model.UploadFile;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.ProfileInfoRepository;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.template.model.ProfileTemplate;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {

	@Autowired
	private ProfileInfoRepository profileInfoRepository;

	@Autowired
	private UploadFileService uploadFileService;

	@Autowired
	private FilePropertyConfig filePropertyConfig;
	
	@Autowired
	private UserDetailRepository userDetailRepository;

	public boolean updateProfile(ProfileTemplate profileTemplate, UserDetail userDetail) {
		boolean result = false;
		ProfileInfo profileInfo = profileInfoRepository.findByUserDetailEquals(userDetail);
		if (profileInfo != null) {
			profileInfo.setAboutUser(profileTemplate.getAbout());
			profileInfo.setAddressUser(profileTemplate.getAddress());
			profileInfo.setDateOfBirth(profileTemplate.getDob());
			profileInfo.setGender(profileTemplate.getGender().toString());
			profileInfo.setHometown(profileTemplate.getHometown());
			profileInfo.setReligion(profileTemplate.getReligion());
			if (!profileTemplate.getProfile().isEmpty()) {
				String fileName = new Date().getTime() + "_" + profileTemplate.getProfile().getOriginalFilename();
				Path path = Paths.get(new File(filePropertyConfig.getFilePath() + File.separator + fileName).toURI());
				try {
					Path outputPath = Files.write(path, profileTemplate.getProfile().getBytes());
					if (outputPath != null) {
						UploadFile uploadFile = uploadFileService.uploadFile(fileName,
								profileTemplate.getProfile().getOriginalFilename());
						profileInfo.setUploadFile(uploadFile);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			result = profileInfoRepository.save(profileInfo) != null;
		}
		return result;
	}
	
	
	@SuppressWarnings("deprecation")
	public ProfileInfo getProfileDetails(String uuid) {
		ProfileInfo profileInfo = null;
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			profileInfo = profileInfoRepository.findByUserDetailEquals(userDetail);
			if (profileInfo == null) {
				profileInfo = new ProfileInfo();
				profileInfo.setAboutUser("Describe yourself");
				profileInfo.setAddressUser("Address here");
				profileInfo.setDateOfBirth(new Date(1991, 1, 01));
				profileInfo.setGender("M");
				profileInfo.setHometown("Chennai");
				profileInfo.setReligion("Hindu");
				profileInfo.setUploadFile(null);
				profileInfo.setUserDetail(userDetail);
				profileInfoRepository.save(profileInfo);
			}
		}
		return profileInfo;
	}
}
