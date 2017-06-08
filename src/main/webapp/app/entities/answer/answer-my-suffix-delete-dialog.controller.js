(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('AnswerMySuffixDeleteController',AnswerMySuffixDeleteController);

    AnswerMySuffixDeleteController.$inject = ['$uibModalInstance', 'entity', 'Answer'];

    function AnswerMySuffixDeleteController($uibModalInstance, entity, Answer) {
        var vm = this;

        vm.answer = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Answer.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
