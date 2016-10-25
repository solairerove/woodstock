'use strict';

woodstock.controller('TaskListController', ['$scope', '$route', 'TaskService',
    function ($scope, $route, TaskService) {
        TaskService.get({categoryId: $routeParams.categoryId}, function (data) {
            $scope.tasks = data;
        })
    }
]);
