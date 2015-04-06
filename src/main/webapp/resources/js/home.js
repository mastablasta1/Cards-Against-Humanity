$("#reg-form").submit(function (e) {
    $.ajax({
        type: 'POST',
        url: ctx + '/register',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: (function () {
            var data = {};
            $('#reg-form').serializeArray().map(function (x) {
                data[x.name] = x.value;
            });
            return JSON.stringify(data);
        })(),
        success: registerReaction
    });
    e.preventDefault();
});


var registerReaction = function (resp) {
    if (resp['status'] == 'ok') {
        $('#reg-form').hide();
        $('#reg-msg').html('<p>Dear, ...! You registered successfully! To activate your account enter a link provided in the email sent on ....</p>').removeClass('hidden');
    }
};