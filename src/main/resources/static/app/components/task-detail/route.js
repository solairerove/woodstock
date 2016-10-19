'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/tasks/:id', {
            templateUrl: '/app/components/task-detail/task-detail.html',
            controller: 'TaskDetailController'
        })
        .when('tasks/:id/tickets', {
            templateUrl: '/app/components/ticket-list/ticket-list.html',
            controller: 'TicketListController'
        })
}]);
