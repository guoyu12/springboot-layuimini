<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>menu</title>
    <link rel="stylesheet" href="/static/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/css/public.css" media="all">
    <style>
        .layui-btn:not(.layui-btn-lg ):not(.layui-btn-sm):not(.layui-btn-xs) {
            height: 34px;
            line-height: 34px;
            padding: 0 8px;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
<!--        <blockquote class="layui-elem-quote">-->
<!--            Layui的树形表格treeTable，支持异步加载(懒加载)、复选框联动、折叠状态记忆。<br>-->
<!--            <a href="https://gitee.com/whvse/treetable-lay" target="_blank" class="layui-btn layui-btn-danger">treetable-lay</a>-->
<!--        </blockquote>-->
        <div>
            <div class="layui-btn-group">
                <button class="layui-btn" id="btn-expand">全部展开</button>
                <button class="layui-btn layui-btn-normal" id="btn-fold">全部折叠</button>
            </div>
            <table id="munu-table" class="layui-table" lay-filter="munu-table"></table>
        </div>
    </div>
</div>
<!-- 操作列 -->
<script type="text/html" id="auth-state">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="/static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['table', 'treetable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treetable = layui.treetable;

        // 渲染表格
        layer.load(2);
        treetable.render({
            treeColIndex: 1,
            treeSpid: -1,
            treeIdName: 'authorityId',
            treePidName: 'parentId',
            elem: '#munu-table',
            url: MENU_URL,
            // url: '../api/menus.json',
            page: false,
            cols: [[
                {type: 'numbers'},
                {field: 'authorityName', minWidth: 200, title: '权限名称'},
                {field: 'authority', title: '权限标识'},
                {field: 'menuUrl', title: '菜单url'},
                {field: 'orderNumber', width: 80, align: 'center', title: '排序号'},
                {
                    field: 'isMenu', width: 80, align: 'center', templet: function (d) {
                        if (d.isMenu == 1) {
                            return '<span class="layui-badge layui-bg-gray">按钮</span>';
                        }
                        if (d.parentId == -1) {
                            return '<span class="layui-badge layui-bg-blue">目录</span>';
                        } else {
                            return '<span class="layui-badge-rim">菜单</span>';
                        }
                    }, title: '类型'
                },
                {templet: '#auth-state', width: 120, align: 'center', title: '操作'}
            ]],
            done: function () {
                layer.closeAll('loading');
            }
        });

        $('#btn-expand').click(function () {
            treetable.expandAll('#munu-table');
        });

        $('#btn-fold').click(function () {
            treetable.foldAll('#munu-table');
        });

        //监听工具条
        table.on('tool(munu-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'del') {
                layer.confirm('确定要删除菜单及其子菜单?', {icon: 3, title:'删除'}, function(index){
                    $.ajax({
                        url: MENUS_DELETE_URL,
                        type: 'POST',
                        dataType: "json",
                        data:{id:data.id},
                        beforeSend: function (request) {
                            request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                            request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                        },
                        success: function (result) {
                            if(result.code == 0){
                                layer.msg("删除成功", {icon: 6,time: 2000},function () {
                                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                    parent.location.reload();//刷新父页面，注意一定要在关闭当前iframe层之前执行刷新
                                    parent.layer.close(index); //再执行关闭
                                });
                            }else {
                                layer.msg(result.msg, {icon: 2,time: 2000});
                            }
                        },
                        error: function () {
                            layer.msg("网络错误");
                        }

                    });
                });
            } else if (layEvent === 'edit') {
                console.log("data.id " + data.id);
                if(data.id == 0){
                    layer.msg("当前不允许修改", {icon: 2,time: 2000});
                    return;
                }
                layer.open({
                    type: 2,
                    title: '修改菜单',
                    shadeClose: true,
                    maxmin: true,
                    shade: 0.8,
                    area: ['100%', '100%'],
                    shadeClose: false,
                    content: '/gyMenus/editPage?id='+data.id //iframe的url
                });
            }
        });
    });
</script>
</body>
</html>