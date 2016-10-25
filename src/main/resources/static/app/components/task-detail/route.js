'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/tasks/:taskId', {
            templateUrl: '/app/components/task-detail/task-detail.html',
            controller: 'TaskDetailController'
        })
}]);