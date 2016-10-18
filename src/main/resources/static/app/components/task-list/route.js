'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/tasks', {
            templateUrl: 'app/components/task-list/task-list.html',
            controller: 'TaskListController'
        })
}]);
