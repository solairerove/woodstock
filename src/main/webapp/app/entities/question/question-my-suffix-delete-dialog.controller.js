(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('QuestionMySuffixDeleteController',QuestionMySuffixDeleteController);

    QuestionMySuffixDeleteController.$inject = ['$uibModalInstance', 'entity', 'Question'];

    function QuestionMySuffixDeleteController($uibModalInstance, entity, Question) {
        var vm = this;

        vm.question = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Question.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
