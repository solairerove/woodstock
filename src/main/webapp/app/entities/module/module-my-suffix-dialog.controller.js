(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ModuleMySuffixDialogController', ModuleMySuffixDialogController);

    ModuleMySuffixDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Module', 'Unit', 'Reference', 'Question'];

    function ModuleMySuffixDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Module, Unit, Reference, Question) {
        var vm = this;

        vm.module = entity;
        vm.clear = clear;
        vm.save = save;
        vm.units = Unit.query();
        vm.references = Reference.query();
        vm.questions = Question.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.module.id !== null) {
                Module.update(vm.module, onSaveSuccess, onSaveError);
            } else {
                Module.save(vm.module, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('woodstock24App:moduleUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
