'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/tasks/:taskId/tickets', {
            templateUrl: 'app/components/ticket/ticket-list.html',
            controller: 'TicketListController'
        })
        .when('/tasks/:taskId/tickets/:ticketId/view', {
            templateUrl: 'app/components/ticket/ticket-view.html',
            controller: 'TicketViewController'
        })
}]);
