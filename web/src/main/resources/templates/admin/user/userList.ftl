<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/css/public.css" media="all">
</head>
<body>
<script type="text/html" id="headPortrait">
    {{# if(d.headPortrait != null){ }}
    <div><img src="{{d.headPortrait}}" style="height: 20%;width: 20%"/></div>
    {{# } }}
</script>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">手机</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="email" autocomplete="off" class="layui-input">
                            </div>
                        </div>
<#--                        <div class="layui-inline">-->
<#--                            <label class="layui-form-label">用户性别</label>-->
<#--                            <div class="layui-input-inline">-->
<#--                                <input type="text" name="sex" autocomplete="off" class="layui-input">-->
<#--                            </div>-->
<#--                        </div>-->
<#--                        <div class="layui-inline">-->
<#--                            <label class="layui-form-label">用户城市</label>-->
<#--                            <div class="layui-input-inline">-->
<#--                                <input type="text" name="city" autocomplete="off" class="layui-input">-->
<#--                            </div>-->
<#--                        </div>-->
<#--                        <div class="layui-inline">-->
<#--                            <label class="layui-form-label">用户职业</label>-->
<#--                            <div class="layui-input-inline">-->
<#--                                <input type="text" name="classify" autocomplete="off" class="layui-input">-->
<#--                            </div>-->
<#--                        </div>-->
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table,
            t;

        t = {
            elem: '#currentTableId',
            url: USER_LIST_URL,
            toolbar: '#toolbarDemo',
            // defaultToolbar: ['filter', 'exports', 'print', {
            //     title: '提示',
            //     layEvent: 'LAYTABLE_TIPS',
            //     icon: 'layui-icon-tips'
            // }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 80, title: 'ID', sort: true},
                {field: 'headPortrait', minWidth: 80, title: '头像',templet: '#headPortrait'},
                {field: 'username', minWidth: 80, title: '用户名'},
                {field: 'phone', minWidth: 80, title: '手机'},
                {field: 'email', minWidth: 80, title: '邮箱'},
                {field: 'createAt', minWidth: 135, title: '创建时间'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        }

        table.render(t);

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {

            t.where = data.field;
            table.reload('currentTableId', t);
            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/users/add',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {

                var index = layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/users/editPage?id='+data.id,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('确定要删除?', {icon: 3, title:'删除'}, function(index){
                    $.ajax({
                        url: USER_DEL_URL,
                        type: 'POST',
                        dataType: "json",
                        data: {id:data.id},
                        beforeSend: function (request) {
                            request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                            request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                        },
                        success: function (result) {
                            if(result.code == 0){
                                layer.msg("删除成功");
                            }else {
                                layer.msg(result.msg);
                            }
                        },
                        error:function () {
                            layer.msg("网络错误");
                        }

                    });
                });
            }
        });

    });
</script>

</body>
</html>