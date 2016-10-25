'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/categories/:categoryId', {
            templateUrl: '/app/components/category-detail/category-detail.html',
            controller: 'CategoryDetailController'
        })
        .when('/categories/:categoryId/tasks', {
            templateUrl: '/app/components/task-list/task-list.html',
            controller: 'TaskListController'
        })
}]);
