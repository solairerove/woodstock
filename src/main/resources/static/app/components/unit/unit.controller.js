'use strict';

woodstock.controller('UnitListController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        UnitService.query(function (data) {
            $scope.units = data;
        });
    }
]).controller('UnitViewController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        UnitService.get({unitId: $routeParams.unitId}, function (data) {
            $scope.unit = data;
        })
    }
]);
