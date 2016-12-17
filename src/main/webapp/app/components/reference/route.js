'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/modules/:moduleId/references/new', {
            templateUrl: '/app/components/reference/reference-add.html',
            controller: 'ReferenceCreateController'
        })
        .when('/modules/:moduleId/references/:refId/view', {
            templateUrl: '/app/components/reference/reference-view.html',
            controller: 'ReferenceViewController'
        })
        .when('/modules/:moduleId/references', {
            templateUrl: '/app/components/reference/reference-list.html',
            controller: 'ReferenceListController'
        })
        .when('/modules/:moduleId/references/:refId/edit', {
            templateUrl: '/app/components/reference/reference-edit.html',
            controller: 'ReferenceEditController'
        })
        .when('/modules/:moduleId/references/:refId/delete', {
            templateUrl: '/app/components/reference/reference-delete.html',
            controller: 'ReferenceDeleteController'
        })
}]);
