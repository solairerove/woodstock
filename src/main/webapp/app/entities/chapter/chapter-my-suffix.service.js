(function() {
    'use strict';
    angular
        .module('woodstock24App')
        .factory('Chapter', Chapter);

    Chapter.$inject = ['$resource'];

    function Chapter ($resource) {
        var resourceUrl =  'api/chapters/:id';

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
