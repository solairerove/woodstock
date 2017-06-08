(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('answer-my-suffix', {
            parent: 'entity',
            url: '/answer-my-suffix?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.answer.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/answer/answersmySuffix.html',
                    controller: 'AnswerMySuffixController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('answer');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('answer-my-suffix-detail', {
            parent: 'answer-my-suffix',
            url: '/answer-my-suffix/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.answer.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/answer/answer-my-suffix-detail.html',
                    controller: 'AnswerMySuffixDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('answer');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Answer', function($stateParams, Answer) {
                    return Answer.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'answer-my-suffix',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('answer-my-suffix-detail.edit', {
            parent: 'answer-my-suffix-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/answer/answer-my-suffix-dialog.html',
                    controller: 'AnswerMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Answer', function(Answer) {
                            return Answer.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('answer-my-suffix.new', {
            parent: 'answer-my-suffix',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/answer/answer-my-suffix-dialog.html',
                    controller: 'AnswerMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                answer: null,
                                correct: null,
                                enable: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('answer-my-suffix', null, { reload: 'answer-my-suffix' });
                }, function() {
                    $state.go('answer-my-suffix');
                });
            }]
        })
        .state('answer-my-suffix.edit', {
            parent: 'answer-my-suffix',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/answer/answer-my-suffix-dialog.html',
                    controller: 'AnswerMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Answer', function(Answer) {
                            return Answer.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('answer-my-suffix', null, { reload: 'answer-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('answer-my-suffix.delete', {
            parent: 'answer-my-suffix',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/answer/answer-my-suffix-delete-dialog.html',
                    controller: 'AnswerMySuffixDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Answer', function(Answer) {
                            return Answer.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('answer-my-suffix', null, { reload: 'answer-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
