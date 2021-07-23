$.fncUpdateNoti = function () {
    if (confirm("정말 수정하시겠습니까?") == true) {
        if ($('#updateNotiTitle').val() != "" && $('#updateNotiContent').val() != "") {
            $.ajax({
                url: '/updateNotiPage',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    updateNotiTitle: $('#updateNotiTitle').val(),
                    updateNotiContent: $('#updateNotiContent').val(),
                    sno: [[${noti.sno}]]
                }),
                success: function onData(data) {
                    if (data >= 1) {
                        alert('공지사항이 수정 되었습니다.');
                        window.location.href = "/noti";
                    } else if (data == 0) {
                        alert('공지사항 수정에 실패하였습니다.');
                    }
                }
            });
        }
    }
}