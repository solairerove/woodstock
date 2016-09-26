'use strict';

woodstock.factory('PersonService', ['$resource', function ($resource) {
    return $resource('/api/persons/:personId');
}]);
