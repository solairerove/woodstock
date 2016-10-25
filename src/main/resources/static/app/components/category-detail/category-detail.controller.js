'use strict';

woodstock.controller('CategoryDetailController', ['$scope', '$location', '$routeParams', 'CategoryService',
    function ($scope, $location, $routeParams, CategoryService) {
        CategoryService.get({id: $routeParams.id}, function (data) {
            $scope.category = data;
        })
    }
]);
