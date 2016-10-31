'use strict';

woodstock.controller('CategoryDetailController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.get({unitId: $routeParams.unitId, categoryId: $routeParams.categoryId}, function (data) {
            $scope.category = data;
            $scope.unitId = $routeParams.unitId;
        })
    }
]);
