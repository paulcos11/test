'use strict';

/* Directives */

var angularMenuDirective = angular.module('angularMenuDirective', []);
angularMenuDirective.directive('flembyMenu', function () {
    return {
        restrict: 'A',
        templateUrl: 'resources/static/views/menu.html'

    };
});