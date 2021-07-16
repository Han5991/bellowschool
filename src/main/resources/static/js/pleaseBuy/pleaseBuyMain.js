$('#pleaseBuyTable tr').click(function () {
    read(this.dataset);
});

function reset() {
    $(".type option:eq(0)").prop("selected", true);
    $(".status option:eq(0)").prop("selected", true);
}

function read(dataset) {
    $('.add').modal('show');
    $('.modalBtnContainer-addEvent').hide();

    $('#pleaseBuyId').text(dataset.id);
    $('#pleaseBuyStatus').val(dataset.status);
    // $('#pleaseBuyStatus').attr('disabled', true);
    $('#pleaseBuyType').val(dataset.goodstype);
    $('#pleaseBuyPrice').val(dataset.goodsprice);
    $('#pleaseBuyGoods').val(dataset.goods);
    $('#pleaseBuyCount').val(dataset.goodscount);
    $('#pleaseBuySum').val(dataset.goodsprice * dataset.goodscount);
    $('#pleaseBuyOption').val(dataset.option);
    $('#pleaseBuyCompany').val(dataset.company);
    $('#pleaseBuyInvoice').val(dataset.invoice);
    $('#pleaseBuyStart').val(dataset.start);
    $('#pleaseBuyEnd').val(dataset.end);
}

function paramsReset() {
    $('#pleaseBuyId').text('');
    $('#pleaseBuyStatus').val(0);
    $('#pleaseBuyType').val(0);
    $('#pleaseBuyPrice').val(0);
    $('#pleaseBuyGoods').val('');
    $('#pleaseBuyCount').val(0);
    $('#pleaseBuySum').val(0);
    $('#pleaseBuyOption').val('');
    $('#pleaseBuyCompany').val(0);
    $('#pleaseBuyInvoice').val('');
    $('#pleaseBuyStart').val('');
    $('#pleaseBuyEnd').val('');

    $("#pleaseBuy > tbody > tr:nth-child(1)").show();
    $("#pleaseBuy > tbody > tr:nth-child(2)").show();
    $("#pleaseBuy > tbody > tr:nth-child(9)").show();
    $("#pleaseBuy > tbody > tr:nth-child(10)").show();
    $("#pleaseBuy > tbody > tr:nth-child(11)").show();
    $("#pleaseBuy > tbody > tr:nth-child(12)").show();
    $("#pleaseBuy > tbody > tr:nth-child(13)").show();
    $(".modalBtnContainer-addEvent").show();
    $(".modalBtnContainer-modifyEvent").show();
}

function add() {
    $(".add").modal('show');
    $("#pleaseBuy > tbody > tr:nth-child(1)").hide();
    $("#pleaseBuy > tbody > tr:nth-child(2)").hide();
    $("#pleaseBuy > tbody > tr:nth-child(9)").hide();
    $("#pleaseBuy > tbody > tr:nth-child(10)").hide();
    $("#pleaseBuy > tbody > tr:nth-child(11)").hide();
    $("#pleaseBuy > tbody > tr:nth-child(12)").hide();
    $("#pleaseBuy > tbody > tr:nth-child(13)").hide();
    $(".modalBtnContainer-modifyEvent").hide();
}

function sum() {
    let amount = $('#pleaseBuyCount').val();
    let Price = $('#pleaseBuyPrice').val();
    $('#pleaseBuySum').val(amount * Price);
}

$.fncAutoTime = function (object) {
    $('#endTime').val(object.value.substr(0, 2) * 1 + 2 + object.value.substr(2, 5));
}
regPleaseBuy = function () {
    if (confirm("정말 등록하시겠습니까?") == true) {
        if ($('#startTime').val() != "") {
            $.ajax({
                url: '/regPleaseBuy',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    usernum: 0,
                    goodstype: $('#pleaseBuyType').val(),
                    goods: $('#pleaseBuyGoods').val(),
                    goodscount: $('#pleaseBuyCount').val(),
                    goodsprice: $('#pleaseBuyPrice').val(),
                    option: $('#pleaseBuyOption').val()
                }),
                success: function onData(data) {
                    if (data >= 1) {
                        alert('사주세요~');
                    } else if (data == 0) {
                        alert('수업 등록에 실패하였습니다.');
                    }
                }
            });
        }
    }
}

function deletePleaseBuy() {
    if (confirm("정말 삭제하시겠습니까?") == true) {
        $.ajax({
            url: '/deletePleaseBuy',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                id: $('#pleaseBuyId').text()
            }),
            success: function onData(data) {
                if (data >= 1) {
                    alert('삭제 되었습니다');
                    $(".add").modal('hide');
                    window.location.reload();
                } else if (data == 0) {
                    alert('삭제에 실패하였습니다.');
                }
            }
        });
    }
}

function updatePleaseBuy() {
    if (confirm("정말 수정하시겠습니까?") == true) {
        $.ajax({
            url: '/updatePleaseBuy',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                id: $('#pleaseBuyId').text(),
                status: $('#pleaseBuyStatus').val(),
                goodstype: $('#pleaseBuyType').val(),
                goodsprice: $('#pleaseBuyPrice').val(),
                goods: $('#pleaseBuyGoods').val(),
                goodscount: $('#pleaseBuyCount').val(),
                option: $('#pleaseBuyOption').val(),
                company: $('#pleaseBuyCompany').val(),
                invoice: $('#pleaseBuyInvoice').val(),
                end: $('#pleaseBuyEnd').val().replaceAll('-','')
            }),
            success: function onData(data) {
                if (data >= 1) {
                    alert('수정 되었습니다');
                    $(".add").modal('hide');
                    window.location.reload();
                } else if (data == 0) {
                    alert('수정 되었습니다.');
                }
            }
        });
    }
}