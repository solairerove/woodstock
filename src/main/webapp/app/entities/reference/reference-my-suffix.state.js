(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('reference-my-suffix', {
            parent: 'entity',
            url: '/reference-my-suffix?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.reference.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/reference/referencesmySuffix.html',
                    controller: 'ReferenceMySuffixController',
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
                    $translatePartialLoader.addPart('reference');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('reference-my-suffix-detail', {
            parent: 'reference-my-suffix',
            url: '/reference-my-suffix/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.reference.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/reference/reference-my-suffix-detail.html',
                    controller: 'ReferenceMySuffixDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('reference');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Reference', function($stateParams, Reference) {
                    return Reference.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'reference-my-suffix',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('reference-my-suffix-detail.edit', {
            parent: 'reference-my-suffix-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/reference/reference-my-suffix-dialog.html',
                    controller: 'ReferenceMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Reference', function(Reference) {
                            return Reference.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('reference-my-suffix.new', {
            parent: 'reference-my-suffix',
            url: '/new',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/reference/reference-my-suffix-dialog.html',
                    controller: 'ReferenceMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                title: null,
                                version: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('reference-my-suffix', null, { reload: 'reference-my-suffix' });
                }, function() {
                    $state.go('reference-my-suffix');
                });
            }]
        })
        .state('reference-my-suffix.edit', {
            parent: 'reference-my-suffix',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/reference/reference-my-suffix-dialog.html',
                    controller: 'ReferenceMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Reference', function(Reference) {
                            return Reference.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('reference-my-suffix', null, { reload: 'reference-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('reference-my-suffix.delete', {
            parent: 'reference-my-suffix',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/reference/reference-my-suffix-delete-dialog.html',
                    controller: 'ReferenceMySuffixDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Reference', function(Reference) {
                            return Reference.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('reference-my-suffix', null, { reload: 'reference-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
