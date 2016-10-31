'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units', {
            templateUrl: 'app/components/unit-list/unit-list.html',
            controller: 'UnitListController'
        })
}]);
