'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/modules/:moduleId/tasks', {
            templateUrl: '/app/components/task/task-list.html',
            controller: 'TaskListController'
        })
        .when('/modules/:moduleId/tasks/:taskId/view', {
            templateUrl: '/app/components/task/task-view.html',
            controller: 'TaskDetailController'
        })
}]);
