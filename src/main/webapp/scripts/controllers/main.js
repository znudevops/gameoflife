'use strict';

angular.module('gameoflifeApp')
    .controller('MainCtrl', function ($scope, $http, $log, $interval) {

        var poller;

        $scope.world =
            [[true, false, false, true, false],
                [true, false, false, true, false],
                [true, false, false, true, false],
                [true, false, false, true, false],
                [true, false, false, true, false]];

        $http.get("/status/name").success(function (data) {
            $scope.title = data.name;
        });

        $scope.startEvolution = function () {
            poller = $interval($scope.getNextStatusOfWorld, 1000);
        };

        $scope.stopEvolution = function () {
            $interval.cancel(poller);
        };

        $scope.getNextStatusOfWorld = function getNextStatusOfWorld() {
            $http
                .post("/status/world", $scope.world)
                .success(function (data) {
                    $scope.world = data;
                    $log.info(data);
                });
        };

        $scope.clickCell = function (cell) {
            cell = !cell;
        };

    });
