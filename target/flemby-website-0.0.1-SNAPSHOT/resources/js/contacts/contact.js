/**
 * Created by Paul on 10/07/2016.
 */


$("#registerationForm").validate({
    rules: {
        firstName: {
            number: false,
            required: true,
            minlength: 2,
            maxlength: 25
        },
        surname: {
            number: false,
            required: true,
            minlength: 2,
            maxlength: 25
        },
        number: {
            number: true,
            required: true,
        },
        email: {
            email: true,
            required: true,
            minlength: 5
        },
        classType: {
            required: true
        }
    }
});





