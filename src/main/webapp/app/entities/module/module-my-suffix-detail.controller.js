(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ModuleMySuffixDetailController', ModuleMySuffixDetailController);

    ModuleMySuffixDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Module', 'Unit', 'Reference', 'Question'];

    function ModuleMySuffixDetailController($scope, $rootScope, $stateParams, previousState, entity, Module, Unit, Reference, Question) {
        var vm = this;

        vm.module = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('woodstock24App:moduleUpdate', function(event, result) {
            vm.module = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
