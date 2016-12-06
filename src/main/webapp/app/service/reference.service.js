'use strict';

woodstock.factory('ReferenceService', ['$resource', function ($resource) {
    return $resource('/api/modules/:moduleId/references/:refId', {}, {
        create: {
            method: 'POST'
        },
        update: {
            method: 'PUT'
        }
    });
}]);
