'use strict';

woodstock.controller('CategoryDetailController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.get({categoryId: $routeParams.categoryId}, function (data) {
            $scope.category = data;
        })
    }
]);
