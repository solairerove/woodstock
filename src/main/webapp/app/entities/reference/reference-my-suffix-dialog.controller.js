(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ReferenceMySuffixDialogController', ReferenceMySuffixDialogController);

    ReferenceMySuffixDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Reference', 'Chapter', 'Module'];

    function ReferenceMySuffixDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Reference, Chapter, Module) {
        var vm = this;

        vm.reference = entity;
        vm.clear = clear;
        vm.save = save;
        vm.chapters = Chapter.query();
        vm.modules = Module.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.reference.id !== null) {
                Reference.update(vm.reference, onSaveSuccess, onSaveError);
            } else {
                Reference.save(vm.reference, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('woodstock24App:referenceUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
