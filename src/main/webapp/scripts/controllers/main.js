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
                .post("/status/world", $scope.world)
                .success(function (data) {
                    $scope.world = data;
                    $log.info(data);
                });
        };

        $scope.toggleCell = function (row, column) {
            $log.info($scope.world);
            $scope.world[column][row] = !$scope.world[column][row];
        };

        $scope.dimensionChanged = function (dimension) {
            //$scope.world = new Array(dimension).fill(new Array(dimension).fill(false));
            $scope.world = [];
            for (var i = 0; i < dimension; i++) {
                $scope.world[i] = [];
                for (var j = 0; j < dimension; j++) {
                    $scope.world[i][j] = false;
                }
            }
        };

        $scope.world = $scope.dimensionChanged(10);

    });
