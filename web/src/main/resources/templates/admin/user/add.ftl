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
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="用户名不能为空" placeholder="请输入用户名" class="layui-input">
            <tip>填写自己管理账号的名称。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" lay-verify="required" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">头像</label>
        <div class="layui-input-block">
            <input type="headPortrait" name="headPortrait" lay-verify="required" placeholder="请输入头像地址" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">手机</label>
        <div class="layui-input-block">
            <input type="number" name="phone" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">邮箱</label>
        <div class="layui-input-block">
            <input type="email" name="email" lay-verify="required" placeholder="请输入邮箱" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">权限设置</label>
        <div class="layui-input-block">
            <div id="menuTree" class="demo-tree-more"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">角色设置</label>
        <div class="layui-input-block">
            <#list roles as list>
                <input type="checkbox" name="roles" title="${list.roleName}" value="${list.id}">
            </#list>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
</div>
<script src="/static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','tree', 'util'], function () {
        var form = layui.form,
            layer = layui.layer,
            tree = layui.tree,
            $ = layui.jquery;

        // //基本演示
        tree.render({
            elem: '#menuTree'
            ,data: ${data}
            ,id: 'menuTree'
            ,showCheckbox: true
            ,isJump: true //是否允许点击节点时弹出新窗口跳转
            // ,operate: function(obj){
            //     console.log("==1==")
            //     console.log(JSON.stringify(obj))
            //     // console.log(obj.type);
            //     // console.log(obj.data);
            //     // if(obj.type === 'add'){
            //     //     return "1531514";
            //     // }
            //     // if(obj.type == 'del'){
            //     // }
            // }
            // ,click: function(obj){
            //     console.log("==2==")
            //     console.log(JSON.stringify(obj))
            //     // var data = obj.data;  //获取当前点击的节点数据
            //     // layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
            // }
        });

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            layer.confirm('确定要添加?', {icon: 3, title:'添加'}, function(index){

                var checkedData = tree.getChecked('menuTree');
                var perms = getCheckedList(checkedData);

                var roleStr = "";
                $('input[name="roles"]:checked').each(function(){
                    roleStr += $(this).val()+",";
                });

                var roles = roleStr.substr(0,roleStr.length-1);

                data.field.perms = perms;
                data.field.roles = roles;

                $.ajax({
                    url: USER_ADD_URL,
                    type: 'POST',
                    dataType: "json",
                    data: data.field,
                    beforeSend: function (request) {
                        request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                        request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                    },
                    success: function (result) {
                        if(result.code == 0){
                            layer.msg("添加成功", {icon: 6,time: 2000},function () {
                                layer.close(index);
                                var iframeIndex = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(iframeIndex);
                            });
                        }else {
                            layer.msg(result.msg);
                        }
                    },
                    error:function () {
                        layer.msg("网络错误");
                    }

                });

            });

            return false;
        });

        // 获取选中节点的id
        function getCheckedList(data) {
            var id = "";
            $.each(data, function (index, item) {
                if (id != "") {
                    id = id + "," + item.id;
                }
                else {
                    id = item.id;
                }
                var i = getCheckedList(item.children);
                if (i != "") {
                    id = id + "," + i;
                }
            });
            return id;
        }

    });
</script>
</body>
</html>