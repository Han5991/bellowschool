function allDayCheck() {
    if ($('#edit-allDay').is(":checked")) {
        $('#edit-start-time').attr("disabled", true);
        $('#edit-end-date').attr("disabled", true);
        $('#edit-end-time').attr("disabled", true);
    } else {
        $('#edit-start-time').attr("disabled", false);
        $('#edit-end-date').attr("disabled", false);
        $('#edit-end-time').attr("disabled", false);
    }
}

function date(date, time) {
    if (time == '') {
        return date
    } else {
        return date + "T" + time;
    }
}

function paramsUpdate(event) {
    $('#edit-id').val(event.event.id);
    $('#edit-title').val(event.event.title);
    $('#edit-desc').val(event.event.extendedProps.description);

    $('#edit-start-date').val(event.event.startStr.substr(0, 10));
    $('#edit-start-time').val(event.event.startStr.substr(11, 5));
    $('#edit-end-date').val(event.event.endStr.substr(0, 10));
    $('#edit-end-time').val(event.event.endStr.substr(11, 5));

    $('#edit-type').val(event.event.extendedProps.type);
    $('#edit-color').val(event.event.backgroundColor);
    $('#edit-allDay').prop("checked", JSON.parse(event.event.extendedProps.allday));
}

function paramsReset() {
    $("#edit-id").val('');
    $('#edit-title').val('');
    $('#edit-desc').val('');

    $('#edit-start-date').val("");
    $('#edit-start-time').val("");
    $('#edit-end-date').val("");
    $('#edit-end-time').val("");

    $('#edit-type').val('0');
    $('#edit-color').val('#D25565');
    $('#edit-allDay').prop("checked", false);

    $('#edit-start-time').attr("disabled", false);
    $('#edit-end-date').attr("disabled", false);
    $('#edit-end-time').attr("disabled", false);
}

function updateSchedule() {
    if (confirm("수정하시겠습니까?") == true) {
        if ($('#edit-title').val() != "") {
            $.ajax({
                url: '/updateschedule',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    id: $('#edit-id').val(),
                    title: $('#edit-title').val(),
                    description: $('#edit-desc').val(),
                    start: date($('#edit-start-date').val(), $('#edit-start-time').val()),
                    end: date($('#edit-end-date').val(), $('#edit-end-time').val()),
                    type: $('#edit-type').val(),
                    username: '관리자',
                    backgroundcolor: $('#edit-color').val(),
                    allday: $('#edit-allDay').is(":checked") ? 'true' : 'false'
                }),
                success: function onData(data) {
                    if (data >= 1) {
                        alert('수정 되었습니다.');
                        $('.add').modal("hide");
                        calendar.refetchEvents();
                    } else if (data == 0) {
                        alert('실패하였습니다.');
                    }
                }
            });
        }
    }
    paramsReset();
}

function deleteSchedule() {
    if (confirm("정말 삭제하시겠습니까?") == true) {
        if ($('#edit-title').val() != "") {
            $.ajax({
                url: '/deleteschedule',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    id: $('#edit-id').val()
                }),
                success: function onData(data) {
                    if (data >= 1) {
                        alert('삭제 되었습니다.');
                        $('.add').modal("hide");
                        calendar.refetchEvents();
                        paramsReset();
                    } else if (data == 0) {
                        alert('실패하였습니다.');
                    }
                }
            });
        }
    }
    paramsReset();
}