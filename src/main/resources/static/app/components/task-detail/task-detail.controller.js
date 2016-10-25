'use strict';

woodstock.controller('TaskDetailController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.get({categoryId: $routeParams.categoryId, taskId: $routeParams.taskId}, function (data) {
            $scope.task = data;
            $scope.categoryId = $routeParams.categoryId;
        })
    }
]);
