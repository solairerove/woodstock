'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/units/:unitId/categories/:categoryId', {
            templateUrl: '/app/components/category-detail/category-detail.html',
            controller: 'CategoryDetailController'
        })
}]);
