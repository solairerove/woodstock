'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/tasks/:taskId/tickets/:ticketId', {
            templateUrl: 'app/components/ticket-detail/ticket-detail.html',
            controller: 'TicketDetailController'
        })
}]);
