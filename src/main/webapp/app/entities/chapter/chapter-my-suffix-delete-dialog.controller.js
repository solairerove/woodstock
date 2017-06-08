(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ChapterMySuffixDeleteController',ChapterMySuffixDeleteController);

    ChapterMySuffixDeleteController.$inject = ['$uibModalInstance', 'entity', 'Chapter'];

    function ChapterMySuffixDeleteController($uibModalInstance, entity, Chapter) {
        var vm = this;

        vm.chapter = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Chapter.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
