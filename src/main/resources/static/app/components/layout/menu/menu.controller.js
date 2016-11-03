'use strict';

woodstock.controller('MenuController', ['$scope', '$mdSidenav',
    function ($scope, $mdSidenav) {
        $scope.openMenu = function () {
            $mdSidenav('left').toggle();
        };
    }
]);
