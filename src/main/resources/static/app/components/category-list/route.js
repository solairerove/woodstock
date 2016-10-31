'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/:unitId/categories/', {
            templateUrl: 'app/components/category-list/category-list.html',
            controller: 'CategoryListController'
        })
}]);
