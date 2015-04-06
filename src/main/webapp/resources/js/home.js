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
        success: processRegister
    });
    e.preventDefault();
});

var processRegister = function (resp) {
    if(resp['status']=='ok')
        return true;
};