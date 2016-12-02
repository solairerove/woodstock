'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/modules/:moduleId/references', {
            templateUrl: '/app/components/reference/reference-list.html',
            controller: 'ReferenceListController'
        })
        .when('/modules/:moduleId/references/:refId/view', {
            templateUrl: '/app/components/reference/reference-view.html',
            controller: 'ReferenceViewController'
        })
}]);
