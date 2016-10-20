'use strict';

woodstock.controller('TaskDetailController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.get({id: $routeParams.taskId}, function (data) {
            $scope.task = data;
        })
    }
]);
