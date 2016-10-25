'use strict';

woodstock.factory('TaskService', ['$resource', function ($resource) {
    return $resource('/api/categories/:categoryId/tasks/:taskId');
}]);
