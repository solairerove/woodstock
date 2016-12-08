'use strict';

woodstock.controller('UnitCreateController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        $scope.unit = new UnitService();

        $scope.addUnit = function () {
            $scope.unit.$create(function () {
                $location.path('/units/');
            })
        }
    }
]).controller('UnitViewController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        UnitService.get({unitId: $routeParams.unitId}, function (data) {
            $scope.unit = data;
        })
    }
]).controller('UnitListController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        UnitService.query(function (data) {
            $scope.units = data;
        });
    }
]).controller('UnitUpdateController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        $scope.unit = new UnitService();

        $scope.updateUnit = function () {
            $scope.unit.$update({unitId: $routeParams.unitId}, function () {
                $location.path('/units/');
            })
        }
    }
]);
