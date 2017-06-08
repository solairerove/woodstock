(function() {
    'use strict';
    angular
        .module('woodstock24App')
        .factory('Module', Module);

    Module.$inject = ['$resource'];

    function Module ($resource) {
        var resourceUrl =  'api/modules/:id';

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
