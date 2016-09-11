/**
 * Created by Paul on 11/09/2016.
 */

$("#schoolEventValidate").validate({
    rules: {
        title: {
            required: true,
            minlength: 3,
            maxlength: 30
        },
        location: {
            required: true,
            minlength: 3,
            maxlength: 30
        },
        link: {
            required: true,
            url: true
        },

        text: {
            required: true,
            minlength: 100,
            maxlength: 1000
        },
        publishedDate: {
            required: true,
            //date: true
        }
    }
});