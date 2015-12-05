'use strict';

/**
 * @ngdoc overview
 * @name heatApp
 * @description
 * # heatApp
 *
 * Main module of the application.
 */
angular
    .module('gameoflifeApp', [
        'ngRoute',
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
