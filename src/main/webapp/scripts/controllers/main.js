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
            $log.info($scope.world);
            $http
                .post("/gameoflife/world", $scope.world)
                .success(function (data) {
                    $scope.world = data;
                    $log.info(data);
                });
        };

        $scope.toggleCell = function (row, column) {
            $log.info($scope.world);
            $scope.world[column][row] = !$scope.world[column][row];
        };

        function emptyWorld(dimension) {
            var arr = [];
            for (var i = 0; i < dimension; i++) {
                arr[i] = [];
                for (var j = 0; j < dimension; j++) {
                    arr[i][j] = false;
                }
            }
            return arr;
        }

        $scope.blinker = function() {
            return [
                [false, false, false],
                [true, true, true],
                [false, false, false]
            ];
        };

        $scope.pulsar = function() {
            var D = false;
            var L = true;

            return [
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
                [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
                [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
                [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
                [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
                [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
                [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
                [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
                [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
                [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
                [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
                [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D]
            ];
        };

        $scope.dimensionChanged = function (dimension) {
            $scope.initializeWorld(emptyWorld(dimension));
        };

        $scope.initializeWorld = function (arr) {
            $scope.world = arr;
            $scope.worldDimension = arr.length;
        };

        $scope.initializeWorld(emptyWorld(10));

    });
