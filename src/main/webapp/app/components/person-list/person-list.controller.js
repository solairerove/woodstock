'use strict';

woodstock.controller('PersonListController', ['$scope', '$route', 'PersonService',
    function ($scope, $route, PersonService) {
        PersonService.get(function (data) {
            $scope.persons = data._embedded.personList;
        })
    }
]);
