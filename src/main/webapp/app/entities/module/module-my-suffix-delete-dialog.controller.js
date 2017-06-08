(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ModuleMySuffixDeleteController',ModuleMySuffixDeleteController);

    ModuleMySuffixDeleteController.$inject = ['$uibModalInstance', 'entity', 'Module'];

    function ModuleMySuffixDeleteController($uibModalInstance, entity, Module) {
        var vm = this;

        vm.module = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Module.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
