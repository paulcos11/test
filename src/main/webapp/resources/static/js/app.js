//var app = angular.module('app', ['ngRoute']);
//
//

'use strict';

var App = angular.module('myApp', ['ngRoute', 'flembyServices', 'flembyDirectives', 'ngResource']);

App.config(function ($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
        templateUrl: 'resources/static/views/home.html',
        controller: 'homeController',
        controllerAs: 'controller'
    }).when('/login', {
        templateUrl: 'resources/static/views/login.html',
        controller: 'navigation'
    }).when('/contactUs', {
        templateUrl: 'resources/static/views/contactUs.html',
        controller: 'conUs',
        controllerAs: 'controller'
    }).when('/calendar', {
        templateUrl: 'resources/static/views/calendar/calendar.html',
        controller: 'calendarCon',
        controllerAs: 'controller'
    }).when('/schoolCalendarMonths/:id', {
        templateUrl: 'resources/static/views/calendar/schoolCalendarMonths.html',
        controller: 'calendarMonthCon',
        controllerAs: 'controller'
    }).when('/location', {
        templateUrl: 'resources/static/views/location.html',
        controller: 'locationCon',
        controllerAs: 'controller'
    }).when('/allPreviousEvents', {
        templateUrl: 'resources/static/views/event/allPreviousEvents.html',
        controller: 'allPreviousEventsCon',
        controllerAs: 'controller'
    }).when('/previousEventsURL/:id', {
        templateUrl: 'resources/static/views/event/previousEventsURL.html',
        controller: 'previousEventsURLCon',
        controllerAs: 'controller'
    }).when('/schoolEvents', {
        templateUrl: 'resources/static/views/event/schoolEvents.html',
        controller: 'schoolEventCon',
        controllerAs: 'controller'
    }).when('/seniorClassEvents', {
        templateUrl: 'resources/static/views/event/seniorClassEvents.html',
        controller: 'seniorClassEventsCon',
        controllerAs: 'controller'
    }).when('/juniorClassEvents', {
        templateUrl: 'resources/static/views/event/juniorClassEvents.html',
        controller: 'juniorClassEventsCon',
        controllerAs: 'controller'
    }).when('/upcomingEvents', {
        templateUrl: 'resources/static/views/event/upcomingEvents.html'
    }).when('/upcomingEventURL/:id', {
        templateUrl: 'resources/static/views/event/upcomingEventURL.html',
        controller: 'upcomingEventURLCon',
        controllerAs: 'controller'
    }).when('/editApp', {
        templateUrl: 'resources/static/views/editApp.html',
    }).when('/gallery', {
        templateUrl: 'resources/static/views/gallery.html',
        controller: 'GalleryControllerCon',
        controllerAs: 'controller'
    }).when('/notification', {
        templateUrl: 'resources/static/views/notifications/notification.html'
    }).when('/schoolNotification', {
        templateUrl: 'resources/static/views/notifications/schoolNotification.html',
        controller: 'schoolNotifyCon',
        controllerAs: 'controller'
    }).when('/juniorNotification', {
        templateUrl: 'resources/static/views/notifications/juniorNotification.html',
        controller: 'juniorNotifyCon',
        controllerAs: 'controller'
    }).when('/seniorNotification', {
        templateUrl: 'resources/static/views/notifications/seniorNotification.html',
        controller: 'seniorNotifyCon',
        controllerAs: 'controller'
    }).when('/notificationURL/:id', {
        templateUrl: 'resources/static/views/notifications/notificationURL.html',
        controller: 'NotificationURLCon',
        controllerAs: 'controller'
    }).when('/contacts', {
        templateUrl: 'resources/static/views/contacts/contacts.html',
    }).when('/contactsSchool', {
        templateUrl: 'resources/static/views/contacts/contactsSchool.html',
        controller: 'ContactCon',
        controllerAs: 'controller'
    }).otherwise(
        {redirectTo: '/'});

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});



