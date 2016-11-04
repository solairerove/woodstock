'use strict';

woodstock.controller('ProfileListController', ['$scope', '$location', '$routeParams', 'ProfileService',
    function ($scope, $location, $routeParams, ProfileService) {
        ProfileService.get(function (data) {
            $scope.profiles = data._embedded.profileList;
        })
    }
]);
