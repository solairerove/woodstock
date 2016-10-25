'use strict';

woodstock.controller('CategoryListController', ['$scope', '$route', 'CategoryService',
    function ($scope, $route, CategoryService) {
        CategoryService.query(function (data) {
            $scope.categories = data;
        })
    }
]);
