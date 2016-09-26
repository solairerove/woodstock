'use strict';

woodstock.controller('PersonListController', ['$route', 'PersonService', function ($route, PersonService) {
    PersonService.query(function (result) {
        this.persons = result;
    })
}]);
