'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/categories/:id', {
            templateUrl: '/app/components/category-detail/category-detail.html',
            controller: 'CategoryDetailController'
        })
}]);
