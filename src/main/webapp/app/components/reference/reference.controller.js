'use strict';

woodstock.controller('ReferenceListController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        ReferenceService.query({moduleId: $routeParams.moduleId}, function (data) {
            $scope.refs = data;
            $scope.moduleId = $routeParams.moduleId;
        })
    }
]).controller('ReferenceViewController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        ReferenceService.get({moduleId: $routeParams.moduleId, refId: $routeParams.refId}, function (data) {
            $scope.ref = data;
            $scope.moduleId = $routeParams.moduleId;
        })
    }
]);
