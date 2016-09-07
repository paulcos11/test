/**
 * Created by Paul on 11/07/2016.
 */
function month() {
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
        minDate: 0,
        startDate: today
    });
}

$("#registerationForm").validate({
    rules: {
        eventName: {
            required: true,
            minlength: 4
        },
        eventText: {
            required: true,
            minlength: 5
        },
        eventDate: {
            required: true,
            date: true,
            format: 'dd/MM/yy'
        }
    }
});