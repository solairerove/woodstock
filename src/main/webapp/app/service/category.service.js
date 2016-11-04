'use strict';

woodstock.factory('CategoryService', ['$resource', function ($resource) {
    return $resource('/api/units/:unitId/categories/:categoryId');
}]);
