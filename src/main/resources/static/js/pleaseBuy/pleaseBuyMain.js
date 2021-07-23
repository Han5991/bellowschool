$('#pleaseBuyTable tr').click(function () {
    read(this.dataset);
});

function resetSearch() {
    $(".type option:eq(0)").prop("selected", true);
    $(".status option:eq(0)").prop("selected", true);
}

function read(dataset) {
    $('.add').modal('show');
    $('.modalBtnContainer-addEvent').hide();
    $('#pleaseBuyId').text(dataset.id);
    $('#pleaseBuyStatus').val(dataset.status);
    if (dataset.status == 3) {
        $('#pleaseBuyStatus').attr('disabled', true);
    }
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
    $('#pleaseBuyPlace').val(0);

    $('#pleaseBuy > tbody > tr:nth-child(3)').hide();
    $("#pleaseBuy > tbody > tr:nth-child(1)").show();
    $("#pleaseBuy > tbody > tr:nth-child(2)").show();
    $("#pleaseBuy > tbody > tr:nth-child(9)").show();
    $("#pleaseBuy > tbody > tr:nth-child(10)").show();
    $("#pleaseBuy > tbody > tr:nth-child(11)").show();
    $("#pleaseBuy > tbody > tr:nth-child(12)").show();
    $("#pleaseBuy > tbody > tr:nth-child(13)").show();

    $(".modalBtnContainer-addEvent").show();
    $(".modalBtnContainer-modifyEvent").show();

    $('#pleaseBuy > tbody > tr:nth-child(3)').css('background-color', '#fadbd8');
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
        $.ajax({
            url: '/regPleaseBuy',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                usernum: /*[[${session.user.usernum}]]*/'',
                type: $('#pleaseBuyType').val(),
                name: $('#pleaseBuyGoods').val(),
                amount: $('#pleaseBuyCount').val(),
                price: $('#pleaseBuyPrice').val(),
                option: $('#pleaseBuyOption').val()
            }),
            success: function onData(data) {
                if (data >= 1) {
                    alert('사주세요~');
                    $(".add").modal('hide');
                    window.location.reload();
                } else if (data == 0) {
                    alert('수업 등록에 실패하였습니다.');
                }
            }
        });
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

function statusCheck(status) {
    if (status.value == 3) {
        alert("보관장소를 확인해주세요.");
        $('#pleaseBuy > tbody > tr:nth-child(3)').show();
        $('#pleaseBuyEnd').val(new Date().toISOString().slice(0, 10));
    }else{
        $('#pleaseBuy > tbody > tr:nth-child(3)').hide();
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
                type: $('#pleaseBuyType').val(),
                price: $('#pleaseBuyPrice').val(),
                name: $('#pleaseBuyGoods').val(),
                amount: $('#pleaseBuyCount').val(),
                option: $('#pleaseBuyOption').val(),
                company: $('#pleaseBuyCompany').val(),
                invoice: $('#pleaseBuyInvoice').val(),
                DATE: $('#pleaseBuyEnd').val().replaceAll('-', ''),
                place: $('#pleaseBuyPlace').val()
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