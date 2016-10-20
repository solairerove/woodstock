'use strict';

woodstock.controller('TicketDetailController', ['$scope', '$location', '$routeParams', 'TicketService',
    function ($scope, $location, $routeParams, TicketService) {
        TicketService.get({taskId: $routeParams.taskId, ticketId: $routeParams.ticketId}, function (data) {
            $scope.ticket = data;
            $scope.taskId = $routeParams.taskId;
        })
    }
]);
