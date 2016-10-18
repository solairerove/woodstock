'use strict';

woodstock.controller('TaskListController', ['$scope', '$route', 'TaskService',
    function ($scope, $route, TaskService) {
        TaskService.get(function (data) {
            $scope.tasks = data._embedded.taskList;
        })
    }
]);
