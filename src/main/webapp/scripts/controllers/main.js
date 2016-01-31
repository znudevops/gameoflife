'use strict';

angular.module('gameoflifeApp')
    .controller('MainCtrl', function ($scope, $http, $log, $interval) {

        var poller;


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

        $scope.dimensionChanged = function (dimension) {
            $log.info("Dimension: " + dimension);
            $scope.world = new Array(dimension).fill(new Array(dimension).fill(false));
        };

        $scope.world = $scope.dimensionChanged(10);

    });
