'use strict';

angular.module('gameoflifeApp')
    .controller('MainCtrl', function ($scope, $http, $log) {

        $http.get("/status/name").success(function(data){
            $scope.title = data.name;
        });

        $http.get("/status/world").success(function(data){
            $scope.world = data;
            $log.log($scope.world);
        });
    });
