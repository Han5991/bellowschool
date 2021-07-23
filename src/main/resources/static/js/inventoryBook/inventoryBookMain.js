let root = new TreeNode("야학물품대장");
let view = new TreeView(root, "#container");
makeInventoryBookList();

function makeInventoryBookList() {
    $.ajax({
        url: '/inventoryBookList',
        type: 'POST',
        async: false,
        contentType: "application/json",
        success: function onData(data) {
            data.inventoryList.forEach(Vo => root.addChild(new TreeNode(Vo.inventoryname, Vo)));
                root.getChildren().forEach(value => {
                    data.inventoryBookList.forEach(Vo => {
                        if (value.getOptions().inventoryid == Vo.place) {
                            value.addChild(new TreeNode(Vo.name, Vo))
                        }
                    })
                });
            view.expandAllNodes();
            view.reload();
        }
    });

    root.getChildren().forEach(value => {
        value.getChildren().forEach(children => {
            children.on('click', function () {
                $('#id2').text(children.getOptions().id);
                switch (children.getOptions().type) {
                    case '0':
                        $('#type2').text('간식류');
                        break;
                    case '1':
                        $('#type2').text('문구류');
                        break;
                    case '2':
                        $('#type2').text('비품류');
                        break;
                    case '3':
                        $('#type2').text('기타');
                        break;
                }
                switch (children.getOptions().place) {
                    case '0':
                        $('#place2').text('교무실');
                        break;
                    case '1':
                        $('#place2').text('큰교실');
                        break;
                    case '2':
                        $('#place2').text('작은교실');
                        break;
                    case '3':
                        $('#place2').text('화장실창고');
                        break;
                }
                $('#name2').text(children.getOptions().name);
                $('#amount2').text(children.getOptions().amount);
                $('#price2').text(children.getOptions().price.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") + ' 원');
                $('#date2').text(children.getOptions().date);
            })
        })
    });
}

function add() {
    $('.add').show();
    $("#update-event").hide();
}

function reset() {
    $('.add').hide();
    $("#update-event").show();
    $("#save-event").show();

    $('#type').val(0);
    $('#place').val(0);
    $('#price').val(0);
    $('#name').val('');
    $('#amount').val(0);
    $('#date').val('');
}

function update() {
    $('.add').show();
    $("#save-event").hide();

    $('#type').val(view.getSelectedNodes()[0].getOptions().type);
    $('#place').val(view.getSelectedNodes()[0].getOptions().place);
    $('#price').val(view.getSelectedNodes()[0].getOptions().price);
    $('#name').val(view.getSelectedNodes()[0].getOptions().name);
    $('#amount').val(view.getSelectedNodes()[0].getOptions().amount);
    $('#date').val(view.getSelectedNodes()[0].getOptions().date);
}

function regInventoryBook() {
    if (confirm("정말 등록하시겠습니까?") == true) {
        $.ajax({
            url: '/regInventoryBook',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                type: $('#type').val(),
                place: $('#place').val(),
                price: $('#price').val(),
                name: $('#name').val(),
                amount: $('#amount').val(),
                DATE: $('#date').val().replaceAll('-', '')
            }),
            success: function onData(data) {
                if (data >= 1) {
                    alert('사주세요~');
                    reload();
                    reset();
                } else if (data == 0) {
                }
            }
        });
    }
}

function updateInventoryBook(id) {
    if (confirm("정말 수정하시겠습니까?") == true) {
        $.ajax({
            url: '/updateInventoryBook',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                id: id,
                type: $('#type').val(),
                place: $('#place').val(),
                price: $('#price').val(),
                name: $('#name').val(),
                amount: $('#amount').val(),
                DATE: $('#date').val().replaceAll('-', '')
            }),
            success: function onData(data) {
                if (data >= 1) {
                    reload();
                    reset();
                } else if (data == 0) {
                    alert('수정실패');
                }
            }
        });
    }
}

function deleteInventoryBook(id) {
    if (confirm("정말 삭제하시겠습니까?") == true) {
        $.ajax({
            url: '/deleteInventoryBook',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                id: id
            }),
            success: function onData(data) {
                if (data >= 1) {
                    alert('삭제완료');
                    reload();
                    reset();
                } else if (data == 0) {
                    alert('삭제실패');
                }
            }
        });
    }
}

function reload() {
    root = new TreeNode("야학물품대장");
    view = new TreeView(root, "#container");
    makeInventoryBookList();
}