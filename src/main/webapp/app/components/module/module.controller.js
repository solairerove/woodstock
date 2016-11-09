'use strict';

woodstock.controller('ModuleListController', ['$scope', '$location', '$routeParams', 'ModuleService',
    function ($scope, $location, $routeParams, ModuleService) {
        ModuleService.query({unitId: $routeParams.unitId}, function (data) {
            $scope.modules = data;
            $scope.unitId = $routeParams.unitId;
        })
    }
]).controller('ModuleViewController', ['$scope', '$location', '$routeParams', 'ModuleService',
    function ($scope, $location, $routeParams, ModuleService) {
        ModuleService.get({unitId: $routeParams.unitId, moduleId: $routeParams.moduleId}, function (data) {
            $scope.module = data;
            $scope.unitId = $routeParams.unitId;
        })
    }
]);
