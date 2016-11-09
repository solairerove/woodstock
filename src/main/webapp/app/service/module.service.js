'use strict';

woodstock.factory('ModuleService', ['$resource', function ($resource) {
    return $resource('/api/units/:unitId/modules/:moduleId');
}]);
