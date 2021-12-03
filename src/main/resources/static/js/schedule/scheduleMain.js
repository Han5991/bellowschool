const containerEl = $('#external-events-list')[0];
new FullCalendar.Draggable(containerEl, {
    itemSelector: '.fc-event'
    // eventData: function (eventEl) {
    //     return {
    //         title: eventEl.innerText.trim()
    //     }
    // }
});

const calendarEl = $('#calendar')[0];
const calendar = new FullCalendar.Calendar(calendarEl, {
    locale: "ko",
    headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    editable: true,
    contentHeight: 'auto',
    selectable: true,
    droppable: true,
    dateClick: function (info) {
        $('#edit-start-date').val(info.dateStr);
        $(".add").modal('show');
        $(".modalBtnContainer-modifyEvent").hide();
        $(".modalBtnContainer-addEvent").show();
    },
    eventClick: function (event) {
        paramsUpdate(event);

        $(".add").modal('show');
        $(".modalBtnContainer-modifyEvent").show();
        $(".modalBtnContainer-addEvent").hide();
    },
    drop: function (arg) {
        $('#edit-start-date').val(arg.dateStr);
        $('#edit-start-time').val(arg.draggedEl.innerText.slice(-11, -6).trim());
        $('#edit-end-date').val(arg.dateStr);
        $('#edit-end-time').val(arg.draggedEl.innerText.slice(-5).trim());
        $('#edit-title').val(arg.draggedEl.innerText.substr(0, 3).trim());
        $('#edit-type').val(0);
        $('#edit-color').val("#74c0fc");
        regSchedule();
        if (document.getElementById('drop-remove').checked) {
            arg.draggedEl.parentNode.removeChild(arg.draggedEl);
        }
    },
    eventDrop: function (event) {
        let date = {};
        date.id = event.event.id;
        date.start = event.event.startStr.substr(0, 16);
        if (!JSON.parse(event.event.extendedProps.allday)) {
            date.end = event.event.endStr.substr(0, 16);
        }
        // if (confirm("수정하시겠습니까?") == true) {
            $.ajax({
                url: '/updateschedule',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify(date),
                success: function onData(data) {
                    if (data >= 1) {
                        alert('수정 되었습니다.');
                        calendar.refetchEvents();
                    } else if (data === 0) {
                        alert('실패하였습니다.');
                    }
                }
            });
        // }
    },
    events: {
        url: '/scheduleList',
        method: 'POST',
        failure: function () {
            alert('스케줄을 가져오지 못 했습니다.');
        }
        // color: 'yellow',   // a non-ajax option
        // textColor: 'black' // a non-ajax option
    },
    eventSourceSuccess: function (content) {
        //여기서 수정 가능
        content.forEach(function (element) {
            // console.log(element.title);
        });
        return content;
    },
    eventMouseEnter: function (info) {
        tippy(info.el, {
            content: info.event.extendedProps.description//이벤트 디스크립션을 툴팁으로 가져옵니다.
        });
    }
});
calendar.render();