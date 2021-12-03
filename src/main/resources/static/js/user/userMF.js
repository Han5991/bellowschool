$.fncreguser = function () {
    if (confirm("정말 등록하시겠습니까?") && $('#username').val() !== "" && $('#password').val() !== "") {
        $.ajax({
            url: '/reguser',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                username: $('#username').val(),
                password: $('#password').val(),
                usertype: $('#usertype').val(),
                userclass: $('#userclass').val()
            }),
            success: function onData(data) {
                if (data >= 1) {
                    alert('사용자가 등록 되었습니다.');
                    location.href = "/userListWin";
                } else if (data === 0) {
                    alert('사용자 등록에 실패하였습니다.');
                }
            }
        });
    }
}