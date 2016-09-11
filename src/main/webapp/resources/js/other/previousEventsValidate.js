/**
 * Created by Paul on 11/09/2016.
 */

$("#formValidate").validate({
    rules: {
        text: {
            required: true,
            minlength: 100,
            maxlength: 1000
        },
        story: {
            required: true,
            minlength: 100,
            maxlength: 1000
        },
        itemFile1: {
            required: true,
            extension: "jpg|png|jpe?g|gif"
        },

        itemFile2: {
            required: true,
            extension: "jpg|png|jpe?g|gif"
        },
        itemFile3: {
            required: true,
            extension: "jpg|png|jpe?g|gif"
        }
    }
});