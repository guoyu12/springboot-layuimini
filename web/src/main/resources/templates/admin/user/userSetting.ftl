<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>基本资料</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">管理账号</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="required" lay-reqtext="管理账号不能为空" placeholder="请输入管理账号"  value="${user.username}" class="layui-input" readonly="readonly">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">头像</label>
                <div class="layui-input-block">
                    <input type="text" name="headPortrait" lay-verify="required" lay-reqtext="头像不能为空" placeholder="请输入头像地址"  value="${user.headPortrait}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">手机</label>
                <div class="layui-input-block">
                    <input type="text" name="phone" lay-verify="required" lay-reqtext="手机号不能为空" placeholder="请输入手机号"  value="${user.phone}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">邮箱</label>
                <div class="layui-input-block">
                    <input type="text" name="email" lay-verify="required" lay-reqtext="邮箱不能为空" placeholder="请输入邮箱"  value="${user.email}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">创建时间</label>
                <div class="layui-input-block">
                    <input type="text" name="createAt" lay-verify="required" lay-reqtext="时间" placeholder="请输入管理账号"  value="${(user.createAt).format('yyyy-MM-dd HH:ss:mm')}" class="layui-input" readonly="readonly">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="/static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form','miniTab','jquery'], function () {
        var form = layui.form,
            layer = layui.layer,
            miniTab = layui.miniTab,
            $ = layui.jquery;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            console.log(data.field)
            layer.confirm('确定要更新?', {icon: 3, title:'更新'}, function(index){
                $.ajax({
                    url: USERSETTING_SUBMIT_URL,
                    type: 'POST',
                    dataType: "json",
                    data: data.field,
                    beforeSend: function (request) {
                        request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                        request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                    },
                    success: function (result) {
                        if(result.code == 0){
                           layer.msg("更新成功");
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