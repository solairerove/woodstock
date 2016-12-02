'use strict';

woodstock.controller('ChapterListController', ['$scope', '$location', '$routeParams', 'ChapterService',
    function ($scope, $location, $routeParams, ChapterService) {
        ChapterService.query({refId: $routeParams.refId}, function (data) {
            $scope.chapters = data;
            $scope.refId = $routeParams.refId;
        })
    }
]).controller('ChapterViewController', ['$scope', '$location', '$routeParams', 'ChapterService',
    function ($scope, $location, $routeParams, ChapterService) {
        ChapterService.get({refId: $routeParams.refId, chapterId: $routeParams.chapterId}, function (data) {
            $scope.chapter = data;
            $scope.refId = $routeParams.refId;
        })
    }
]);
