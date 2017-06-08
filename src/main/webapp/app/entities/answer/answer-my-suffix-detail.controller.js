(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('AnswerMySuffixDetailController', AnswerMySuffixDetailController);

    AnswerMySuffixDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Answer', 'Question'];

    function AnswerMySuffixDetailController($scope, $rootScope, $stateParams, previousState, entity, Answer, Question) {
        var vm = this;

        vm.answer = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('woodstock24App:answerUpdate', function(event, result) {
            vm.answer = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
