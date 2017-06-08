(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .controller('ChapterMySuffixDetailController', ChapterMySuffixDetailController);

    ChapterMySuffixDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Chapter', 'Reference'];

    function ChapterMySuffixDetailController($scope, $rootScope, $stateParams, previousState, entity, Chapter, Reference) {
        var vm = this;

        vm.chapter = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('woodstock24App:chapterUpdate', function(event, result) {
            vm.chapter = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
