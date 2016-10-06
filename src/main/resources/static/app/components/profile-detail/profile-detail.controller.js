'use strict';

woodstock.controller('ProfileDetailController', ['$scope', '$location', '$routeParams', 'ProfileService',
    function ($scope, $location, $routeParams, ProfileService) {
        ProfileService.get({id: $routeParams.id}, function (data) {
            $scope.profile = data;
        })
    }
]);
