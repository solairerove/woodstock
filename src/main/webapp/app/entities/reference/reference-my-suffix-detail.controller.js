(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ReferenceMySuffixDetailController', ReferenceMySuffixDetailController);

    ReferenceMySuffixDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Reference', 'Chapter', 'Module'];

    function ReferenceMySuffixDetailController($scope, $rootScope, $stateParams, previousState, entity, Reference, Chapter, Module) {
        var vm = this;

        vm.reference = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('woodstock24App:referenceUpdate', function(event, result) {
            vm.reference = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
