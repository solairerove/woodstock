(function() {
    'use strict';
    angular
        .module('woodstock24App')
        .factory('Unit', Unit);

    Unit.$inject = ['$resource'];

    function Unit ($resource) {
        var resourceUrl =  'api/units/:id';

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
