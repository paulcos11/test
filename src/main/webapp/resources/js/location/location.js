/**
 * Created by Paul on 11/07/2016.
 */

function mapOption() {
    var mapOptions = {

        center: new google.maps.LatLng(52.238105, -9.614666),
        zoom: 11,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    return mapOptions;
}

function map() {
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        mapOptions);
    return map;
}


function maker() {
    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(52.238105, -9.614666),
        map: map
    });
    return marker
}


