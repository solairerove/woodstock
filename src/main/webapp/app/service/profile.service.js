'use strict';

woodstock.factory('ProfileService', ['$resource', function ($resource) {
    return $resource('/api/profiles/:id');
}]);
