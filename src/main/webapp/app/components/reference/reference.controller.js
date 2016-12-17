'use strict';

woodstock.controller('ReferenceCreateController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        $scope.ref = new ReferenceService();

        $scope.addReference = function () {
            $scope.ref.$create({moduleId: $routeParams.moduleId}, function () {
                $location.path('/modules/' + $routeParams.moduleId + '/references')
            })
        }
    }
]).controller('ReferenceViewController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        ReferenceService.get({moduleId: $routeParams.moduleId, refId: $routeParams.refId}, function (data) {
            $scope.ref = data;
            $scope.moduleId = $routeParams.moduleId;
        })
    }
]).controller('ReferenceListController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        ReferenceService.query({moduleId: $routeParams.moduleId}, function (data) {
            $scope.refs = data;
            $scope.moduleId = $routeParams.moduleId;
        })
    }
]).controller('ReferenceEditController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        $scope.ref = new ReferenceService();

        $scope.updateReference = function () {
            $scope.ref.$update({moduleId: $routeParams.moduleId, refId: $routeParams.refId}, function () {
                $location.path('/modules/' + $routeParams.moduleId + '/references')
            })
        }
    }
]).controller('ReferenceDeleteController', ['$scope', '$location', '$routeParams', 'ReferenceService',
    function ($scope, $location, $routeParams, ReferenceService) {
        $scope.ref = new ReferenceService();

        $scope.deleteReference = function () {
            $scope.ref.$delete({moduleId: $routeParams.moduleId, refId: $routeParams.refId}, function () {
                $location.path('/modules/' + $routeParams.moduleId + '/references')
            })
        }
    }
]);
