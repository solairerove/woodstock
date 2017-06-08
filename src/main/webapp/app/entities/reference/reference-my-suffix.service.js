(function() {
    'use strict';
    angular
        .module('woodstock24App')
        .factory('Reference', Reference);

    Reference.$inject = ['$resource'];

    function Reference ($resource) {
        var resourceUrl =  'api/references/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
