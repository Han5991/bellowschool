var sno = 0;
var qrname = '';

// function tableBuller() {
var table = $("#dataTable").DataTable({
    dom: 'Blfrtip',
    select: true,
    // serverSide: true,
    processing: true,
    ordering: false,
    buttons: [{
        extend: 'csvHtml5',
        text: 'Export CSV',
        footer: true,
        className: 'exportBtn'
    }],
    ajax: {
        url: '/userattendanceList',
        type: 'POST',
        dataSrc: function (json) {
            // for (var i = 0, ien = json.length; i < ien; i++) {
            //     json[i][0] = '<a href="/message/' + json[i][0] + '>View message</a>';
            // }
            return json;
        }
    },
    columns: [
        {data: 'usernum'},
        {data: 'username'},
        {data: 'usertype'},
        {data: 'userclass'},
        {data: 'addtendance'}
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
    columnDefs: [
        {
            'targets': 0,
            'width': '10%',
            "className": "text-center"
        },
        {
            'targets': 1,
            'width': '10%',
            "className": "text-center",
            'render': function (data, type, full, meta) {
                return '<a href="/userRead?usernum=' + full.usernum + '"><span style="font-weight: bold">' + data + '</span></a>';
            }
        },
        {
            'targets': 2,
            'width': '10%',
            "className": "text-center",
            'render': function (data, type, full, meta) {
                switch (data) {
                    case '0':
                        return '관리자'
                        break;
                    case '1':
                        return '선생님'
                        break;
                    case '2':
                        return '어머님'
                        break;
                }
            }
        },
        {
            'targets': 3,
            'width': '10%',
            "className": "text-center",
            'render': function (data, type, full, meta) {
                switch (data) {
                    case '0':
                        return '교무실'
                        break;
                    case '1':
                        return '고급2'
                        break;
                    case '2':
                        return '고급1'
                        break;
                    case '3':
                        return '중급'
                        break;
                }
            }
        },
        {
            'targets': 4,
            'width': '10%',
            "className": "text-center",
            "createdCell": function (td, cellData, rowData, row, col) {
                if (cellData > 1) {
                    $(td).css('background-color', 'rgb(' + (250 - (cellData * 1.5)) + ',' + '250' + ',' + (250 - (cellData * 1.5)) + ')')
                }
            },
            'render': function (data, type, full, meta) {
                return data + '%';
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
    if (indexInArray != 0) {
        $('#select').append('<option>' + valueOfElement.innerHTML + '</option>');
    }
});

$('.dataTables_filter input').unbind().bind('keyup', function () {
    var colIndex = document.querySelector('#select').selectedIndex;
    table.column(colIndex + 1).search(this.value).draw();
});

table.on('select', function (e, dt, type, indexes) {
    var rowData1 = table.rows(indexes).data().toArray();
    sno = rowData1[0].usernum;
    qrname = rowData1[0].qrname;
})
// .on('deselect', function (e, dt, type, indexes) {
//     var rowData2 = table.rows(indexes).data().toArray();
//     console.log(rowData2[0].sno);
// });

function search() {
    $.ajax({
        url: '/userattendanceList2',
        type: 'POST',
        async: false,
        contentType: "application/json",
        data: JSON.stringify({
            dateStart: $('#dateStart').val().replace(/-/g, ""),
            dateEnd: $('#dateEnd').val().replace(/-/g, ""),
        }),
        success: function onData(data) {
            table.clear();
            for (var i = 0; i < data.length; i++) {
                table.row.add(data[i]).draw();
            }
        }
    });
}