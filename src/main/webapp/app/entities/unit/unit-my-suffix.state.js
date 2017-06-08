(function () {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('unit-my-suffix', {
                parent: 'entity',
                url: '/unit-my-suffix?page&sort&search',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'woodstock24App.unit.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/unit/unitsmySuffix.html',
                        controller: 'UnitMySuffixController',
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
                        $translatePartialLoader.addPart('unit');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('unit-my-suffix-detail', {
                parent: 'unit-my-suffix',
                url: '/unit-my-suffix/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'woodstock24App.unit.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/unit/unit-my-suffix-detail.html',
                        controller: 'UnitMySuffixDetailController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('unit');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Unit', function ($stateParams, Unit) {
                        return Unit.get({id: $stateParams.id}).$promise;
                    }],
                    previousState: ["$state", function ($state) {
                        var currentStateData = {
                            name: $state.current.name || 'unit-my-suffix',
                            params: $state.params,
                            url: $state.href($state.current.name, $state.params)
                        };
                        return currentStateData;
                    }]
                }
            })
            .state('unit-my-suffix-detail.edit', {
                parent: 'unit-my-suffix-detail',
                url: '/detail/edit',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/unit/unit-my-suffix-dialog.html',
                        controller: 'UnitMySuffixDialogController',
                        controllerAs: 'vm',
                        backdrop: 'static',
                        size: 'lg',
                        resolve: {
                            entity: ['Unit', function (Unit) {
                                return Unit.get({id: $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function () {
                        $state.go('^', {}, {reload: false});
                    }, function () {
                        $state.go('^');
                    });
                }]
            })
            .state('unit-my-suffix.new', {
                parent: 'unit-my-suffix',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/unit/unit-my-suffix-dialog.html',
                        controller: 'UnitMySuffixDialogController',
                        controllerAs: 'vm',
                        backdrop: 'static',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    label: null,
                                    description: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function () {
                        $state.go('unit-my-suffix', null, {reload: 'unit-my-suffix'});
                    }, function () {
                        $state.go('unit-my-suffix');
                    });
                }]
            })
            .state('unit-my-suffix.edit', {
                parent: 'unit-my-suffix',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/unit/unit-my-suffix-dialog.html',
                        controller: 'UnitMySuffixDialogController',
                        controllerAs: 'vm',
                        backdrop: 'static',
                        size: 'lg',
                        resolve: {
                            entity: ['Unit', function (Unit) {
                                return Unit.get({id: $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function () {
                        $state.go('unit-my-suffix', null, {reload: 'unit-my-suffix'});
                    }, function () {
                        $state.go('^');
                    });
                }]
            })
            .state('unit-my-suffix.delete', {
                parent: 'unit-my-suffix',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/unit/unit-my-suffix-delete-dialog.html',
                        controller: 'UnitMySuffixDeleteController',
                        controllerAs: 'vm',
                        size: 'md',
                        resolve: {
                            entity: ['Unit', function (Unit) {
                                return Unit.get({id: $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function () {
                        $state.go('unit-my-suffix', null, {reload: 'unit-my-suffix'});
                    }, function () {
                        $state.go('^');
                    });
                }]
            });
    }

})();
