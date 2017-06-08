(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ReferenceMySuffixDeleteController',ReferenceMySuffixDeleteController);

    ReferenceMySuffixDeleteController.$inject = ['$uibModalInstance', 'entity', 'Reference'];

    function ReferenceMySuffixDeleteController($uibModalInstance, entity, Reference) {
        var vm = this;

        vm.reference = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Reference.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
