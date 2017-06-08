(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('UnitMySuffixDeleteController',UnitMySuffixDeleteController);

    UnitMySuffixDeleteController.$inject = ['$uibModalInstance', 'entity', 'Unit'];

    function UnitMySuffixDeleteController($uibModalInstance, entity, Unit) {
        var vm = this;

        vm.unit = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Unit.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
