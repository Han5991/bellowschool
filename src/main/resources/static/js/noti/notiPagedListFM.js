let sno = 0;
let table = $("#dataTable").DataTable({
    dom: 'Bfrtip',
    select: true,
    buttons: [
        {
            text: '등록',
            action: () => {
                location.href = "/notiRegPageWin";
            }
        },
        {
            text: '수정',
            action: () => {
                this.sno = sno;
                if (sno !== 0) {
                    location.href = "/updatenoti?sno=" + sno;
                    sno = 0;
                } else {
                    alert("수정할 게시물을 선택해주세요.");
                }
            }
        },
        {
            text: '삭제',
            action: (e, dt) => {
                this.sno = sno;
                if (sno !== 0) {
                    if (confirm("정말 삭제하시겠습니까?")) {
                        $.fncDelete(sno);
                        dt.ajax.reload();
                        sno = 0;
                    }
                } else {
                    alert("삭제할 게시물을 선택해주세요.");
                }
            }
        }
    ],
    ajax: {
        'url': '/notiList',
        'type': 'POST',
        'dataSrc': ''
    },
    columns: [
        {data: null},
        {data: 'sno'},
        {data: 'title'},
        {data: 'reguser'},
        {data: 'regtime'},
        {data: 'hitcnt'}
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
            'width': '7%',
            "className": "text-center"
        },
        {
            'targets': 2,
            'width': '50%',
            'render': function (data, type, full, meta) {
                return '<a href="/notiRead?sno=' + full.sno + '"><span style="font-weight: bold">' + data + '</span></a>';
            }
        },
        {
            'targets': 3,
            'width': '10%',
            "className": "text-center"
        },
        {
            'targets': 4,
            'width': '18%',
            "className": "text-center"
        },
        {
            'targets': 5,
            'width': '10%',
            "className": "text-center"
        }
    ],
    select: {
        style: 'os',
        selector: 'td:first-child'
    }
});

$('#dataTable_filter').prepend('<select id="select"></select>');
$('#dataTable > thead > tr').children().each((indexInArray, valueOfElement) => {
    if (indexInArray !== 0) {
        $('#select').append('<option>' + valueOfElement.innerHTML + '</option>');
    }
});

$('.dataTables_filter input').unbind().bind('keyup', () => {
    let colIndex = document.querySelector('#select').selectedIndex;
    table.column(colIndex + 1).search(this.value).draw();
});

$.fncDelete = function (sno) {
    $.ajax({
        url: '/detelenoti',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify({
            sno: sno
        }),
        success: (data) => {
            if (data >= 1) {
                alert('공지사항이 삭제 되었습니다.');
            } else if (data === 0) {
                alert('공지사항이 삭제 되지 않았습니다.');
            }
        }
    });
}

table.on('select', (e, dt, type, indexes) => {
    let rowData1 = table.rows(indexes).data().toArray();
    sno = rowData1[0].sno;
})