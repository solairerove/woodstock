'use strict';

woodstock.controller('CategoryListController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.query({unitId: $routeParams.unitId}, function (data) {
            $scope.categories = data;
            $scope.unitId = $routeParams.unitId;
        })
    }
]).controller('CategoryViewController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.get({unitId: $routeParams.unitId, categoryId: $routeParams.categoryId}, function (data) {
            $scope.category = data;
            $scope.unitId = $routeParams.unitId;
        })
    }
]);
