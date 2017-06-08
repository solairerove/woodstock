(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('QuestionMySuffixDetailController', QuestionMySuffixDetailController);

    QuestionMySuffixDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Question', 'Module', 'Answer'];

    function QuestionMySuffixDetailController($scope, $rootScope, $stateParams, previousState, entity, Question, Module, Answer) {
        var vm = this;

        vm.question = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('woodstock24App:questionUpdate', function(event, result) {
            vm.question = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
