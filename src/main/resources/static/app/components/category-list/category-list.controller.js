'use strict';

woodstock.controller('CategoryListController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.query({unitId: $routeParams.unitId}, function (data) {
            $scope.categories = data;
            $scope.unitId = $routeParams.unitId;
        })
    }
]);
