'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/categories/:categoryId/tasks', {
            templateUrl: '/app/components/task-list/task-list.html',
            controller: 'TaskListController'
        })
}]);
