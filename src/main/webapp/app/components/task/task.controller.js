'use strict';

woodstock.controller('TaskCreateController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        $scope.task = new TaskService();

        $scope.addTask = function () {
            $scope.task.$create({moduleId: $routeParams.moduleId}, function () {
                $location.path('/modules/' + $routeParams.moduleId + '/tasks');
            });
        }
    }
]).controller('TaskListController', ['$scope', '$location', '$routeParams', 'TaskService',
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
]).controller('TaskEditController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        $scope.task = new TaskService();

        $scope.updateTask = function () {
            $scope.task.$update({moduleId: $routeParams.moduleId, taskId: $routeParams.taskId}, function () {
                $location.path('/modules/' + $routeParams.moduleId + '/tasks');
            });
        }
    }
]);
