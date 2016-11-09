'use strict';

woodstock.controller('TaskListController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.query({moduleId: $routeParams.moduleId}, function (data) {
            $scope.tasks = data;
            $scope.moduleId = $routeParams.moduleId;
        })
    }
]).controller('TaskDetailController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.get({moduleId: $routeParams.moduleId, taskId: $routeParams.taskId}, function (data) {
            $scope.task = data;
            $scope.moduleId = $routeParams.moduleId;
        })
    }
]);
