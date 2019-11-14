atsApp.controller('adminHomeController', [
		"$scope",
		function($scope) {

			$scope.showStaffList = true;
			$scope.staffs = "";
			$scope.selectedStaff = null;

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
		} ]);