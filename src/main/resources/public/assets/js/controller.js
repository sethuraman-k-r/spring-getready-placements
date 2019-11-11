atsApp.controller('adminHomeController', [ "$scope", function($scope) {

	$scope.menuItem = 1;

	$scope.selectMenu = function(itemValue) {
		$scope.menuItem = itemValue;
	}
} ]);