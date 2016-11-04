'use strict';

woodstock.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'app/components/home/home.html'
        })
        .otherwise({
            template: '<h1>Fuck off!!!</h1>'
        });
}]);
