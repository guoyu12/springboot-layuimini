<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统设置</title>
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

        <div class="layui-form layuimini-form" id="sysConfig">
<!--            <div class="layui-form-item">-->
<!--                <label class="layui-form-label required">网站名称</label>-->
<!--                <div class="layui-input-inline">-->
<!--                    <input type="text" name="website" lay-verify="required" lay-reqtext="网站域名不能为空" placeholder="请输入网站名称"  value="layuimini" class="layui-input">-->
<!--                    <tip>填写自己部署网站的名称。</tip>-->
<!--                </div>-->
<!--            </div>-->
<!--            <div class="layui-form-item">-->
<!--                <div class="layui-input-block">-->
<!--                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="setting">确认保存</button>-->
<!--                </div>-->
<!--            </div>-->
        </div>
    </div>
</div>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['jquery','form'], function () {
        var form = layui.form
            , layer = layui.layer,
            $ = layui.jquery;
        $(function () {
            $.ajax({
                url: SYS_CONFIG_LIST_URL,
                type: 'POST',
                dataType: "json",
                beforeSend: function (request) {
                    request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                    request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                },
                success: function (result) {
                    if(result.code == 0){
                        init(result.data);
                    }else {
                        layer.msg(result.msg)
                    }
                },
                error: function () {
                    layer.msg("网络错误");
                }

            });
        })

        function init(datas){

            console.log(JSON.stringify(datas))

            $("#sysConfig").empty();

            var content = "";

            for(var i = 0;i<datas.length;i++){

                var data = datas[i];

                content += "<div class='layui-form-item'>";
                content += "<label class='layui-form-label required'>"+data.cfgTitle+"</label>";
                content += "<div class='layui-input-block'>";
                content += "<input type='text' name='"+data.cfgName.toLowerCase()+"' lay-verify='required'  placeholder='"+data.cfgDescribe+"' class='layui-input' value='"+data.cfgValue+"'>";
                content += "<tip>"+data.cfgDescribe+"</tip>";
                content += "</div></div>";
            }

            content += "<div class='layui-form-item'>";
            content += "<div class='layui-input-block'>";
            content += "<button class='layui-btn layui-btn-normal' lay-submit lay-filter='setting'>确认保存</button>";
            content += "</div></div>";
            $("#sysConfig").append(content);
        }

        //监听提交
        form.on('submit(setting)', function (data) {

            layer.confirm('确定要更新?', {icon: 3, title:'更新'}, function(index){
                $.ajax({
                    url: SYS_CONFIG_SUBMIT_URL,
                    type: 'POST',
                    dataType: "json",
                    data:data.field,
                    beforeSend: function (request) {
                        request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                        request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                    },
                    success: function (result) {
                        if(result.code == 0){
                            layer.msg("更新成功", {icon: 6,time: 2000});
                        }else {
                            layer.msg(result.msg, {icon: 6,time: 2000});
                        }
                    },
                    error: function () {
                        layer.msg("网络错误");
                    }

                });
            });



            // parent.layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // });
            return false;
        });

    });
</script>
</body>
</html>