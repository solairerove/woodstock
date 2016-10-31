'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/:unitId', {
            templateUrl: '/app/components/unit-detail/unit-detail.html',
            controller: 'UnitDetailController'
        })
}]);
