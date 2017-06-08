(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('UnitMySuffixDialogController', UnitMySuffixDialogController);

    UnitMySuffixDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Unit', 'Module'];

    function UnitMySuffixDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Unit, Module) {
        var vm = this;

        vm.unit = entity;
        vm.clear = clear;
        vm.save = save;
        vm.modules = Module.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.unit.id !== null) {
                Unit.update(vm.unit, onSaveSuccess, onSaveError);
            } else {
                Unit.save(vm.unit, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('woodstock24App:unitUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
