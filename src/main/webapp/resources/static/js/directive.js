/**
 * Created by Paul on 26/08/2016.
 */

var flembyDirectives = angular.module('flembyDirectives', []);

flembyDirectives.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

flembyDirectives.directive('imageonload', function() {
    return {
        restrict: 'A',

        link: function(scope, element) {
            element.on('load', function() {
                // Set visibility: true + remove spinner overlay
                element.removeClass('spinner-hide');
                element.addClass('spinner-show');
                element.parent().find('span').remove();
            });
            scope.$watch('ngSrc', function() {
                // Set visibility: false + inject temporary spinner overlay
                element.addClass('spinner-hide');
                // element.parent().append('<span class="spinner"></span>');
            });
        }
    };
});

flembyDirectives.directive('dateFix', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attr, ngModel) {
            element.on('change', function() {
                scope.$apply(function () {
                    ngModel.$setViewValue(element.val());
                });
            });
        }
    };
});