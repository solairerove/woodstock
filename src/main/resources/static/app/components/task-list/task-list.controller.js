'use strict';

woodstock.controller('TaskListController', ['$scope', '$location', '$routeParams', 'TaskService',
    function ($scope, $location, $routeParams, TaskService) {
        TaskService.query({categoryId: $routeParams.categoryId}, function (data) {
            $scope.tasks = data;
        })
    }
]);
