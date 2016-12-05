'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/modules/:moduleId/tasks/new', {
            templateUrl: '/app/components/task/task-add.html',
            controller: 'TaskCreateController'
        })
        .when('/modules/:moduleId/tasks/:taskId/view', {
            templateUrl: '/app/components/task/task-view.html',
            controller: 'TaskDetailController'
        })
        .when('/modules/:moduleId/tasks', {
            templateUrl: '/app/components/task/task-list.html',
            controller: 'TaskListController'
        })
        .when('/modules/:moduleId/tasks/:taskId/edit', {
            templateUrl: '/app/components/task/task-edit.html',
            controller: 'TaskEditController'
        })
}]);
