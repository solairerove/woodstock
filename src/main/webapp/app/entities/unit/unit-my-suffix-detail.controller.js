(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('UnitMySuffixDetailController', UnitMySuffixDetailController);

    UnitMySuffixDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Unit', 'Module'];

    function UnitMySuffixDetailController($scope, $rootScope, $stateParams, previousState, entity, Unit, Module) {
        var vm = this;

        vm.unit = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('woodstock24App:unitUpdate', function(event, result) {
            vm.unit = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
