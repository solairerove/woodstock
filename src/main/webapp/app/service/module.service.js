'use strict';

woodstock.factory('ModuleService', ['$resource', function ($resource) {
    return $resource('/api/units/:unitId/modules/:moduleId', {}, {
        create: {
            method: 'POST'
        },
        update: {
            method: 'PUT'
        }
    });
}]);
