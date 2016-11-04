'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/categories/:categoryId/tasks', {
            templateUrl: '/app/components/task/task-list.html',
            controller: 'TaskListController'
        })
        .when('/categories/:categoryId/tasks/:taskId/view', {
            templateUrl: '/app/components/task/task-view.html',
            controller: 'TaskDetailController'
        })
}]);
