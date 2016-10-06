'use strict';

woodstock.controller('ProfileListController', ['$scope', '$route', 'ProfileService',
    function ($scope, $route, ProfileService) {
        ProfileService.get(function (data) {
            $scope.profiles = data._embedded.profileList;
        })
    }
]);
