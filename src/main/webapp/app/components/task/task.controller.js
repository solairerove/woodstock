'use strict';

woodstock.controller('TaskListController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.query({categoryId: $routeParams.categoryId}, function (data) {
            $scope.tasks = data;
            $scope.categoryId = $routeParams.categoryId;
        })
    }
]).controller('TaskDetailController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.get({categoryId: $routeParams.categoryId, taskId: $routeParams.taskId}, function (data) {
            $scope.task = data;
            $scope.categoryId = $routeParams.categoryId;
        })
    }
]);
