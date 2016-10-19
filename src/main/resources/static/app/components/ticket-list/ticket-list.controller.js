'use strict';

woodstock.controller('TicketListController', ['$scope', '$route', 'TicketService',
    function ($scope, $route, TicketService) {
        TicketService.get(function (data) {
            $scope.tickets = data;
        })
    }
]);
