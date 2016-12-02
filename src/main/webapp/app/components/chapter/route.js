'use strict';

woodstock.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/references/:refId/chapters', {
            templateUrl: '/app/components/chapter/chapter-list.html',
            controller: 'ChapterListController'
        })
        .when('/references/:refId/chapters/:chapterId/view', {
            templateUrl: '/app/components/chapter/chapter-view.html',
            controller: 'ChapterViewController'
        })
}]);
