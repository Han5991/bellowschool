$.fncregnoti = function () {
    if (confirm("정말 등록하시겠습니까?") == true) {
        if ($('#regnotititle').val() != "" && $('#regnoticontent').val() != "") {
            $.ajax({
                url: '/createnoti',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    regnotititle: $('#regnotititle').val(),
                    regnoticontent: $('#regnoticontent').val(),
                    regnotiuser: '관리자'
                }),
                success: function onData(data) {
                    if (data >= 1) {
                        alert('공지사항이 등록 되었습니다.');
                        location.href = "/noti";
                    } else if (data == 0) {
                        alert('공지사항이 등록에 실패하였습니다.');
                    }
                }
            });
        }
    }
}