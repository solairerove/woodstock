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
        $scope.ticket = new TicketService();

        $scope.addTicket = function () {
            $scope.ticket.$create({taskId: $routeParams.taskId}, function () {
                $location.path('/tasks/' + $routeParams.taskId + '/tickets');
            });
        }
    }
]).controller('TicketEditController', ['$scope', '$location', '$routeParams', 'TicketService',
    function ($scope, $location, $routeParams, TicketService) {
        $scope.ticket = new TicketService();

        $scope.updateTicket = function () {
            $scope.ticket.$update({taskId: $routeParams.taskId, ticketId: $routeParams.ticketId}, function () {
                $location.path('/tasks/' + $routeParams.taskId + '/tickets');
            });
        }
    }
]);
