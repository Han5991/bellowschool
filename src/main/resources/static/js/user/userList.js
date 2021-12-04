let sno = 0;
let qrname = '';
let table = $("#dataTable").DataTable({
    dom: 'Bfrtip',
    select: true,
    buttons: [
        {
            text: '등록',
            action: function () {
                location.href = "/user";
            }
        },
        {
            text: '수정',
            action: function () {
                if (sno !== 0) {
                    location.href = "/userUpdateWin?usernum=" + sno;
                    sno = 0;
                } else {
                    alert("수정할 사용자를 선택해주세요.");
                }
            }
        },
        {
            text: '삭제',
            action: function (e, dt) {
                if (sno !== 0) {
                    if (confirm("정말 삭제하시겠습니까?") === true) {
                        $.fncuserDelete(sno, qrname);
                        dt.ajax.reload();
                        sno = 0;
                        qrname = '';
                    }
                } else {
                    alert("삭제할 게시물을 선택해주세요.");
                }
            }
        }
    ],
    ajax: {
        url: '/userList',
        type: 'POST',
        dataSrc: ''
    },
    columns: [
        {data: null},
        {data: 'usernum'},
        {data: 'username'},
        {data: 'usertype'},
        {data: 'userclass'},
        {data: 'userdtime'},
        {data: 'qrname'}
    ],
    language: {
        "emptyTable": "데이터가 없어요.",
        "lengthMenu": "페이지당 _MENU_ 개씩 보기",
        "info": "현재 _START_ - _END_ / _TOTAL_건",
        "infoEmpty": "데이터 없음",
        "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
        "search": "검색 : ",
        "zeroRecords": "일치하는 데이터가 없어요.",
        "loadingRecords": "로딩중...",
        "processing": "잠시만 기다려 주세요...",
        "select": {
            "rows": "%d 건이 선택 되었습니다."
        },
        "paginate": {
            "next": "다음",
            "previous": "이전"
        }
    },
    ordering: false,
    columnDefs: [
        {
            'targets': 0,
            'width': '5%',
            data: null,
            defaultContent: '',
            'searchable': false,
            'orderable': false,
            'className': 'select-checkbox'
        },
        {
            'targets': 1,
            'width': '10%',
            "className": "text-center"
        },
        {
            'targets': 2,
            'width': '10%',
            "className": "text-center",
            'render': function (data, type, full) {
                return '<a href="/userRead?usernum=' + full.usernum + '"><span style="font-weight: bold">' + data + '</span></a>';
            }
        },
        {
            'targets': 3,
            'width': '10%',
            "className": "text-center",
            'render': function (data) {
                switch (data) {
                    case '0':
                        return '관리자'
                    case '1':
                        return '선생님'
                    case '2':
                        return '어머님'
                }
            }
        },
        {
            'targets': 4,
            'width': '10%',
            "className": "text-center",
            'render': function (data) {
                switch (data) {
                    case '0':
                        return '교무실'
                    case '1':
                        return '고급2'
                    case '2':
                        return '고급1'
                    case '3':
                        return '중급'
                }
            }
        },
        {
            'targets': 5,
            'width': '10%',
            "className": "text-center",
            render : (data) => {
                console.log(data);
                return data;
            }
        },
        {
            'targets': 6,
            'width': '10%',
            "className": "p-0 text-center",
            'render': function (data) {
                return '<img style="width: 50%;" src="img\\qrcode\\' + data + '.png" alt="qrCode">';
            }
        }
    ],
    select: {
        style: 'os',
        selector: 'td:first-child'
    }
});

$('#dataTable_filter').prepend('<select id="select"></select>');
$('#dataTable > thead > tr').children().each(function (indexInArray, valueOfElement) {
    if (indexInArray !== 0) {
        $('#select').append('<option>' + valueOfElement.innerHTML + '</option>');
    }
});

$('.dataTables_filter input').unbind().bind('keyup', function () {
    let colIndex = document.querySelector('#select').selectedIndex;
    table.column(colIndex + 1).search(this.value).draw();
});

$.fncuserDelete = function (sno, qrname) {
    $.ajax({
        url: '/deteleuser',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify({
            usernum: sno,
            qrname: qrname
        }),
        success: function onData(data) {
            if (data >= 1) {
                alert('사용자가 삭제 되었습니다.');
            } else if (data === 0) {
                alert('사용자가 삭제 되지 않았습니다.');
            }
        }
    });
}
table.on('select', function (e, dt, type, indexes) {
    let rowData1 = table.rows(indexes).data().toArray();
    sno = rowData1[0].usernum;
    qrname = rowData1[0].qrname;
})