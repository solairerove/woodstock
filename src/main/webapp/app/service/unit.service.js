'use strict';

woodstock.factory('UnitService', ['$resource', function ($resource) {
    return $resource('/api/units/:unitId', {}, {
        create: {
            method: 'POST'
        },
        update: {
            method: 'PUT'
        }
    });
}]);
