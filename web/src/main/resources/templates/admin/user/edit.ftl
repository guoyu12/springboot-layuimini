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
    <input type="hidden" name="id" value="${user.id}">
    <div class="layui-form-item">
        <label class="layui-form-label required">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="用户名不能为空" placeholder="请输入用户名" value="${user.username}" class="layui-input" readonly="readonly">
            <tip>填写自己管理账号的名称。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">头像</label>
        <div class="layui-input-block">
            <input type="headPortrait" name="headPortrait" placeholder="请输入头像地址" value="${user.headPortrait}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">手机</label>
        <div class="layui-input-block">
            <input type="number" name="phone" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" value="${user.phone}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="email" name="email" placeholder="请输入邮箱" value="${user.email}" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
</div>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            layer.confirm('确定要更新?', {icon: 3, title:'更新'}, function(index){
                $.ajax({
                    url: USER_EDIT_URL,
                    type: 'POST',
                    dataType: "json",
                    data: data.field,
                    beforeSend: function (request) {
                        request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                        request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                    },
                    success: function (result) {
                        if(result.code == 0){
                            layer.msg("更新成功", {icon: 6,time: 2000},function () {
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

    });
</script>
</body>
</html>