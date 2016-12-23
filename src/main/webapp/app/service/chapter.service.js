'use strict';

woodstock.factory('ChapterService', ['$resource', function ($resource) {
    return $resource('/api/references/:refId/chapters/:chapterId', {}, {
        create: {
            method: 'POST'
        },
        update: {
            method: 'PUT'
        }
    });
}]);