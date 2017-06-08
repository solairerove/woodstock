(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ChapterMySuffixDialogController', ChapterMySuffixDialogController);

    ChapterMySuffixDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Chapter', 'Reference'];

    function ChapterMySuffixDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Chapter, Reference) {
        var vm = this;

        vm.chapter = entity;
        vm.clear = clear;
        vm.save = save;
        vm.references = Reference.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.chapter.id !== null) {
                Chapter.update(vm.chapter, onSaveSuccess, onSaveError);
            } else {
                Chapter.save(vm.chapter, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('woodstock24App:chapterUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
