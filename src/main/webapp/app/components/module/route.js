'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/:unitId/modules/new', {
            templateUrl: '/app/components/module/module-add.html',
            controller: 'ModuleCreateController'
        })
        .when('/units/:unitId/modules/:moduleId/view', {
            templateUrl: '/app/components/module/module-view.html',
            controller: 'ModuleViewController'
        })
        .when('/units/:unitId/modules/', {
            templateUrl: '/app/components/module/module-list.html',
            controller: 'ModuleListController'
        })
        .when('/units/:unitId/modules/:moduleId/edit', {
            templateUrl: '/app/components/module/module-edit.html',
            controller: 'ModuleEditController'
        })
}]);
