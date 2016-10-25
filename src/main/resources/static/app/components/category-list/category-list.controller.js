'use strict';

woodstock.controller('CategoryListController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.query(function (data) {
            $scope.categories = data;
        })
    }
]);
