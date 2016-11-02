'use strict';

woodstock.controller('TicketListController', ['$scope', '$location', '$routeParams', 'TicketService',
    function ($scope, $location, $routeParams, TicketService) {
        TicketService.query({taskId: $routeParams.taskId}, function (data) {
            $scope.tickets = data;
            $scope.taskId = $routeParams.taskId;
        })
    }
]).controller('TicketViewController', ['$scope', '$location', '$routeParams', 'TicketService',
    function ($scope, $location, $routeParams, TicketService) {
        TicketService.get({taskId: $routeParams.taskId, ticketId: $routeParams.ticketId}, function (data) {
            $scope.ticket = data;
            $scope.taskId = $routeParams.taskId;
        })
    }
]).controller('TicketCreateController', ['$scope', '$location', '$routeParams', 'TicketService',
    function ($scope, $location, $routeParams, TicketService) {
        $scope.addTicket = function () {
            TicketService.save({taskId: $routeParams.taskId}, $scope.ticket);
            $location.path('/tasks/' + $routeParams.taskId + '/tickets');
        }
    }
]);
