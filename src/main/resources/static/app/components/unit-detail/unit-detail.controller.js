'use strict';

woodstock.controller('UnitDetailController', ['$scope', '$location', '$routeParams', 'UnitService',
    function ($scope, $location, $routeParams, UnitService) {
        UnitService.get({unitId: $routeParams.unitId}, function (data) {
            $scope.unit = data;
        })
    }
]);
