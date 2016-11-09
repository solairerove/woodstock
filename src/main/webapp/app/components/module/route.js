'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/:unitId/modules/', {
            templateUrl: 'app/components/module/module-list.html',
            controller: 'ModuleListController'
        })
        .when('/units/:unitId/modules/:moduleId/view', {
            templateUrl: '/app/components/module/module-view.html',
            controller: 'ModuleViewController'
        })
}]);
