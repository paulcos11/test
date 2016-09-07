/**
 * Created by Paul on 05/09/2016.
 */

$(document).ready(function () {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd
    }

    if (mm < 10) {
        mm = '0' + mm
    }

    today = dd + '/' + mm + '/' + yyyy;

    $("#datepicker").datepicker({
        minDate: today,
        startDate: today,
        dateFormat: 'dd/mm/yy'
    });

});
