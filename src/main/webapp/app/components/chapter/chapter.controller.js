'use strict';

woodstock.controller('ChapterCreateController', ['$scope', '$location', '$routeParams', 'ChapterService',
    function ($scope, $location, $routeParams, ChapterService) {
        $scope.chapter = new ChapterService();

        $scope.addChapter = function () {
            $scope.chapter.$create({refId: $routeParams.refId}, function () {
                $location.path('/references/' + $routeParams.refId + '/chapters');
            })
        }
    }
]).controller('ChapterViewController', ['$scope', '$location', '$routeParams', 'ChapterService',
    function ($scope, $location, $routeParams, ChapterService) {
        ChapterService.get({refId: $routeParams.refId, chapterId: $routeParams.chapterId}, function (data) {
            $scope.chapter = data;
            $scope.refId = $routeParams.refId;
        })
    }
]).controller('ChapterListController', ['$scope', '$location', '$routeParams', 'ChapterService',
    function ($scope, $location, $routeParams, ChapterService) {
        ChapterService.query({refId: $routeParams.refId}, function (data) {
            $scope.chapters = data;
            $scope.refId = $routeParams.refId;
        })
    }
]).controller('ChapterUpdateController', ['$scope', '$location', '$routeParams', 'ChapterService',
    function ($scope, $location, $routeParams, ChapterService) {
        $scope.chapter = new ChapterService();

        $scope.updateChapter = function () {
            $scope.chapter.$update({refId: $routeParams.refId, chapterId: $routeParams.chapterId}, function () {
                $location.path('/references/' + $routeParams.refId + '/chapters');
            })
        }
    }
]);
