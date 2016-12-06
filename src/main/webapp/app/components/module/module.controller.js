'use strict';

woodstock.controller('ModuleCreateController', ['$scope', '$location', '$routeParams', 'ModuleService',
    function ($scope, $location, $routeParams, ModuleService) {
        $scope.module = new ModuleService();

        $scope.addModule = function () {
            $scope.module.$create({unitId: $routeParams.unitId}, function () {
                $location.path('/units/' + $routeParams.unitId + '/modules');
            })
        }
    }
]).controller('ModuleListController', ['$scope', '$location', '$routeParams', 'ModuleService',
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
]).controller('ModuleEditController', ['$scope', '$location', '$routeParams', 'ModuleService',
    function ($scope, $location, $routeParams, ModuleService) {
        $scope.module = new ModuleService();

        $scope.updateModule = function () {
            $scope.module.$update({unitId: $routeParams.unitId, moduleId: $routeParams.moduleId}, function () {
                $location.path('/units/' + $routeParams.unitId + '/modules');
            })
        }
    }
]);
