'use strict';

woodstock.factory('TicketService', ['$resource', function ($resource) {
    return $resource('/api/tasks/:taskId/tickets/:ticketId', {}, {
        create: {
            method: 'POST'
        },
        update: {
            method: 'PUT'
        }
    });
}]);
