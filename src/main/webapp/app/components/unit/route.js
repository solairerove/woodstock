'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units', {
            templateUrl: 'app/components/unit/unit-list.html',
            controller: 'UnitListController'
        })
        .when('/units/:unitId/view', {
            templateUrl: '/app/components/unit/unit-view.html',
            controller: 'UnitViewController'
        })
}]);
