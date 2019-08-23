var menu = {
    setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    },
    loadMenuTree: function () {

        $.ajax({
            url: '/getMenuPopes.json',
            type: 'POST', //method  get post
            async: true,    //或false,是否异步
            data: {
            },
            timeout: 15000,    //超时时间
            dataType: 'json',  //响应返回的数据格式

            success: function (data) {
                $("#menuTree").zTree(menu.setting, data);
            },

            error: function (e) {
                alert('AJAX失败！');

            }

        });

    }
};

$().ready(function () {
    menu.loadMenuTree();
});
