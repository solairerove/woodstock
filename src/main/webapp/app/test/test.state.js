(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('test', {
            parent: 'app',
            url: '/test',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/test/test.html',
                    // controller: 'TestController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: [
                    '$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('test');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
