'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/new', {
            templateUrl: '/app/components/unit/unit-add.html',
            controller: 'UnitCreateController'
        })
        .when('/units/:unitId/view', {
            templateUrl: '/app/components/unit/unit-view.html',
            controller: 'UnitViewController'
        })
        .when('/units', {
            templateUrl: 'app/components/unit/unit-list.html',
            controller: 'UnitListController'
        })
        .when('/units/:unitId/edit', {
            templateUrl: '/app/components/unit/unit-edit.html',
            controller: 'UnitUpdateController'
        })
}]);
