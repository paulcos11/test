/**
 * Created by Paul on 10/07/2016.
 */

$('#registerationForm').validate({
    rules: {
        name: {
            required: true,
            email: true,
            minlength: 2,
            maxlength: 30
        },
        surname: {
            required: true,
            email: true,
            minlength: 2,
            maxlength: 30
        },
        email: {
            required: true,
            email: true,
            minlength: 5,
            maxlength: 30
        },
        phone: {
            required: true,
            number: true,
            minlength: 5,
            maxlength: 30
        },
        message: {
            required: true,
            minlength: 10,
            maxlength: 250
        }
    }
});
