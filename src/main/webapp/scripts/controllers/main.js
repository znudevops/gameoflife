'use strict';

angular.module('gameoflifeApp')
    .controller('MainCtrl', function ($scope, $http, $log) {

        $scope.world = [[true, false, false, true, false], [true, false, false, true, false], [true, false, false, true, false], [true, false, false, true, false], [true, false, false, true, false]];

        $http.get("/status/name").success(function (data) {
            $scope.title = data.name;
        });

        $http
            .post("/status/world", $scope.world)
            .success(function (data) {
                $scope.world = data;
                $log.info(data);
            });
    });
