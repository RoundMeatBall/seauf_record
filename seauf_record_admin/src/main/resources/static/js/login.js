function register() {
    var json = {
        phone : $("#inputPhone").val(),
        password : $("#inputPassword").val()
    };

    $.ajax({
        url:'/samplingDetail/list',
        type:'POST',
        contentType: 'application/json; charset=UTF-8',
        async:true,
        dataType:'json',
        data:JSON.stringify(json),
        success: function (data) {

        }
    })
}



