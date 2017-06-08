(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('question-my-suffix', {
            parent: 'entity',
            url: '/question-my-suffix?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.question.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/question/questionsmySuffix.html',
                    controller: 'QuestionMySuffixController',
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
                    $translatePartialLoader.addPart('question');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('question-my-suffix-detail', {
            parent: 'question-my-suffix',
            url: '/question-my-suffix/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.question.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/question/question-my-suffix-detail.html',
                    controller: 'QuestionMySuffixDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('question');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Question', function($stateParams, Question) {
                    return Question.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'question-my-suffix',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('question-my-suffix-detail.edit', {
            parent: 'question-my-suffix-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/question/question-my-suffix-dialog.html',
                    controller: 'QuestionMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Question', function(Question) {
                            return Question.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('question-my-suffix.new', {
            parent: 'question-my-suffix',
            url: '/new',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/question/question-my-suffix-dialog.html',
                    controller: 'QuestionMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                question: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('question-my-suffix', null, { reload: 'question-my-suffix' });
                }, function() {
                    $state.go('question-my-suffix');
                });
            }]
        })
        .state('question-my-suffix.edit', {
            parent: 'question-my-suffix',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/question/question-my-suffix-dialog.html',
                    controller: 'QuestionMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Question', function(Question) {
                            return Question.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('question-my-suffix', null, { reload: 'question-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('question-my-suffix.delete', {
            parent: 'question-my-suffix',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/question/question-my-suffix-delete-dialog.html',
                    controller: 'QuestionMySuffixDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Question', function(Question) {
                            return Question.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('question-my-suffix', null, { reload: 'question-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
