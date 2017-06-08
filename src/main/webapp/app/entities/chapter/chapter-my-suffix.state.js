(function() {
    'use strict';

    angular
        .module('woodstock24App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('chapter-my-suffix', {
            parent: 'entity',
            url: '/chapter-my-suffix?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.chapter.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/chapter/chaptersmySuffix.html',
                    controller: 'ChapterMySuffixController',
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
                    $translatePartialLoader.addPart('chapter');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('chapter-my-suffix-detail', {
            parent: 'chapter-my-suffix',
            url: '/chapter-my-suffix/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'woodstock24App.chapter.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/chapter/chapter-my-suffix-detail.html',
                    controller: 'ChapterMySuffixDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('chapter');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Chapter', function($stateParams, Chapter) {
                    return Chapter.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'chapter-my-suffix',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('chapter-my-suffix-detail.edit', {
            parent: 'chapter-my-suffix-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/chapter/chapter-my-suffix-dialog.html',
                    controller: 'ChapterMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Chapter', function(Chapter) {
                            return Chapter.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('chapter-my-suffix.new', {
            parent: 'chapter-my-suffix',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/chapter/chapter-my-suffix-dialog.html',
                    controller: 'ChapterMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                title: null,
                                content: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('chapter-my-suffix', null, { reload: 'chapter-my-suffix' });
                }, function() {
                    $state.go('chapter-my-suffix');
                });
            }]
        })
        .state('chapter-my-suffix.edit', {
            parent: 'chapter-my-suffix',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/chapter/chapter-my-suffix-dialog.html',
                    controller: 'ChapterMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Chapter', function(Chapter) {
                            return Chapter.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('chapter-my-suffix', null, { reload: 'chapter-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('chapter-my-suffix.delete', {
            parent: 'chapter-my-suffix',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/chapter/chapter-my-suffix-delete-dialog.html',
                    controller: 'ChapterMySuffixDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Chapter', function(Chapter) {
                            return Chapter.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('chapter-my-suffix', null, { reload: 'chapter-my-suffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
