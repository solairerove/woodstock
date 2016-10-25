'use strict';

woodstock.factory('CategoryService', ['$resource', function ($resource) {
    return $resource('/api/categories/:id');
}]);
