atsApp.controller('adminHomeController', [
		"$scope",
		function($scope) {

			$scope.showStaffList = true;
			$scope.staffs = "";
			$scope.selectedStaff = null;

			$scope.showCourseList = true;
			$scope.courses = "";
			$scope.selectedCourse = null;

			$scope.showAssignmentList = true;
			$scope.assignments = "";
			$scope.selectedAssignment = null;

			$scope.doSearchUser = function(username, email) {
				if (!$scope.users) {
					return true;
				} else if (username.includes($scope.users)
						|| email.includes($scope.users)) {
					return true;
				} else {
					return false;
				}
			}

			$scope.updateStaff = function(event) {
				$scope.staffs = event.target.value;
			}

			$scope.doSearchStaff = function(staff) {
				if (!$scope.staffs) {
					return true;
				} else if (staff.toLowerCase().includes(
						$scope.staffs.toLowerCase())) {
					return true;
				} else {
					return false;
				}
			}

			$scope.doSelectStaff = function(id) {
				if ($scope.selectedStaff == id) {
					$scope.selectedStaff = null;
				} else {
					$scope.selectedStaff = id;
				}
			}

			$scope.updateCourse = function(event) {
				$scope.courses = event.target.value;
			}

			$scope.doSearchCourse = function(course) {
				if (!$scope.courses) {
					return true;
				} else if (course.toLowerCase().includes(
						$scope.courses.toLowerCase())) {
					return true;
				} else {
					return false;
				}
			}

			$scope.updateAssignment = function(event) {
				$scope.assignments = event.target.value;
			}

			$scope.doSearchAssignment = function(assignment) {
				if (!$scope.assignments) {
					return true;
				} else if (assignment.toLowerCase().includes(
						$scope.assignments.toLowerCase())) {
					return true;
				} else {
					return false;
				}
			}

		} ]);

atsApp.controller('userHomeController', [
		"$scope",
		function($scope) {
			$scope.showAssignmentList = false;
			$scope.showAcademy = false;

			$scope.selectPicture = function() {
				var pictureSelector = angular.element(document
						.querySelector("input[name=profile]"))[0];
				if (pictureSelector) {
					pictureSelector.click();
				}
			}
		} ]);
;