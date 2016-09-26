'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/persons', {
            templateUrl: 'app/components/person-list/person-list.html',
            controller: 'PersonListController'
    })
}]);
