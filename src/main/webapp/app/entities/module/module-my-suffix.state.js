(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('module-my-suffix', {
            parent: 'entity',
            url: '/module-my-suffix?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.module.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/module/modulesmySuffix.html',
                    controller: 'ModuleMySuffixController',
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
                    $translatePartialLoader.addPart('module');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('module-my-suffix-detail', {
            parent: 'module-my-suffix',
            url: '/module-my-suffix/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.module.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/module/module-my-suffix-detail.html',
                    controller: 'ModuleMySuffixDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('module');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Module', function($stateParams, Module) {
                    return Module.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'module-my-suffix',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('module-my-suffix-detail.edit', {
            parent: 'module-my-suffix-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/module/module-my-suffix-dialog.html',
                    controller: 'ModuleMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Module', function(Module) {
                            return Module.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('module-my-suffix.new', {
            parent: 'module-my-suffix',
            url: '/new',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/module/module-my-suffix-dialog.html',
                    controller: 'ModuleMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                description: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('module-my-suffix', null, { reload: 'module-my-suffix' });
                }, function() {
                    $state.go('module-my-suffix');
                });
            }]
        })
        .state('module-my-suffix.edit', {
            parent: 'module-my-suffix',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/module/module-my-suffix-dialog.html',
                    controller: 'ModuleMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Module', function(Module) {
                            return Module.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('module-my-suffix', null, { reload: 'module-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('module-my-suffix.delete', {
            parent: 'module-my-suffix',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/module/module-my-suffix-delete-dialog.html',
                    controller: 'ModuleMySuffixDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Module', function(Module) {
                            return Module.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('module-my-suffix', null, { reload: 'module-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
