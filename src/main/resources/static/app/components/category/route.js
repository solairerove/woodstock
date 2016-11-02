'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/:unitId/categories/', {
            templateUrl: 'app/components/category/category-list.html',
            controller: 'CategoryListController'
        })
        .when('/units/:unitId/categories/:categoryId/view', {
            templateUrl: '/app/components/category/category-view.html',
            controller: 'CategoryViewController'
        })
}]);
