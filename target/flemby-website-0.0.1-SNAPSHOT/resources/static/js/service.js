'use strict';

/* Services */

var flembyServices = angular.module('flembyServices', ['ngResource']);

flembyServices.factory('NotificationSave', ['$resource',
    function ($resource) {
        return $resource("/notificationSave/", {}, {
            save: {method: 'POST', cache: false, isArray: false},
        });
    }]);

flembyServices.factory('JuniorNotificationSave', ['$resource',
    function ($resource) {
        return $resource("/juniorNotificationSave/", {}, {
            save: {method: 'POST', cache: false, isArray: false},
        });
    }]);

flembyServices.factory('SenorNotificationSave', ['$resource',
    function ($resource) {
        return $resource("/seniorNotificationSave/", {}, {
            save: {method: 'POST', cache: false, isArray: false},
        });
    }]);

flembyServices.factory('Notification', ['$resource',
    function ($resource) {
        return $resource("/notification/:id", {}, {
            get: {method: 'GET', cache: false, isArray: false},
            save: {method: 'POST', cache: false, isArray: false},
            update: {method: 'PUT', cache: false, isArray: false},
            delete: {method: 'DELETE', cache: false, isArray: false}
        });
    }]);

flembyServices.factory('userService', function ($resource) {
    var service = {};

    service.userExists = function (user, success, failure) {
        var User = $resource("/editAppConfig");
        var data = User.get({name: user.name}, function () {

                //var user = data.user;
                if (data) {
                    alert(data.name + ' data passed back');
                    success(data);
                }else{
                    failure();
                }
            },
            failure);
    };

    return service;
})


flembyServices.factory('sessionService', function ($http) {
    var session = {};

    session.login = function (data) {
        //alert("user logged in with " + data.name + " " + data.password);
        return $http.post('/editAppLogin', "username=" + data.name +
        "&password=" + data.password, {
            headers : {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success (function(data, status, headers, config){
            console.log(data);
            if(data.correct === 'correct') {
                alert('Login Successful');
                localStorage.setItem("session", {});
            }else{
                alert('login not correct');
            }
        }, function(data){
            alert('error logging in');
        });
    };

    session.logout = function () {
        localStorage.removeItem("session");
    };

    session.isLoggedIn = function () {
        return localStorage.getItem("session") !== null;
    };

    return session;

})


flembyServices.factory('CalendarMonthService', ['$resource',
    function ($resource) {
        return $resource("/calendarMonth/:id", {}, {
            get: {method: 'GET', cache: false, isArray: false},
        });
    }]);

flembyServices.factory('ItemEventsGallery', ['$resource',
    function ($resource) {
        return $resource("/itemEventsGallery/:id", {}, {
            get: {method: 'GET', cache: false, isArray: true},
        });
    }]);

flembyServices.factory('PreviousEventsGallery', ['$resource',
    function ($resource) {
        return $resource("/previousEventsGallery", {}, {
            get: {method: 'GET', cache: false, isArray: true},
        });
    }]);

flembyServices.factory('UpdateEvent', ['$resource',
    function ($resource) {
        return $resource("/updateEvent/:id", {}, {
            save: {method: 'POST', cache: false, isArray: false}
        });
    }]);

flembyServices.factory('Item', ['$resource',
    function ($resource) {
        return $resource("/item/:id", {}, {
            get: {method: 'GET', cache: false, isArray: true},
            save: {method: 'POST', cache: false, isArray: false},
            update: {method: 'PUT', cache: false, isArray: false},
            delete: {method: 'DELETE', cache: false, isArray: false}
        });
    }]);


flembyServices.factory('Event', ['$resource',
    function ($resource) {
        return $resource("/event/:id", {}, {
            get: {method: 'GET', cache: false, isArray: false},
            save: {method: 'POST', cache: false, isArray: false},
            update: {method: 'PUT', cache: false, isArray: false},
            delete: {method: 'DELETE', cache: false, isArray: false}
        });
    }]);

flembyServices.factory('EventSave', ['$resource',
    function ($resource) {
        return $resource("/schoolEvent/", {}, {
            save: {method: 'POST', cache: false, isArray: false},
        });
    }]);


flembyServices.factory('EventList', ['$resource',
    function ($resource) {
        return $resource("/events/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);

flembyServices.factory('SchoolEventList', ['$resource',
    function ($resource) {
        return $resource("/schoolEvents/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);

flembyServices.factory('SeniorClassEventsList', ['$resource',
    function ($resource) {
        return $resource("/seniorClassEvents/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);

flembyServices.factory('JuniorClassEventsList', ['$resource',
    function ($resource) {
        return $resource("/juniorClassEvents/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);

flembyServices.factory('SchoolNotifyList', ['$resource',
    function ($resource) {
        return $resource("/schoolNotify/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);

flembyServices.factory('JuniorNotifyList', ['$resource',
    function ($resource) {
        return $resource("/juniorNotify/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);

flembyServices.factory('SeniorNotifyList', ['$resource',
    function ($resource) {
        return $resource("/seniorNotify/", {}, {
            get: {method: 'GET', cache: false, isArray: true}
        });
    }]);