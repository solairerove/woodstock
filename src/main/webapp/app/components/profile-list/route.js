'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/profiles', {
            templateUrl: 'app/components/profile-list/profile-list.html',
            controller: 'ProfileListController'
    })
}]);
