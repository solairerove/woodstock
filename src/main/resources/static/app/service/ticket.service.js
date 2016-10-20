'use strict';

woodstock.factory('TicketService', ['$resource', function ($resource) {
    return $resource('/api/tasks/:taskId/tickets/:ticketId');
}]);
