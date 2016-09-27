'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/profiles/:id', {
            templateUrl: '/app/components/profile-detail/profile-detail.html',
            controller: 'ProfileDetailController'
        })
}]);
