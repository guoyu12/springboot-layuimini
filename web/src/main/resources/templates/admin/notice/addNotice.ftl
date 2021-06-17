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
        <label class="layui-form-label required">公告标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="required" lay-reqtext="标题不能为空" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">公告内容</label>
    </div>
    <div class="layui-form-item">
        <div id="editor">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
    <input type="hidden" id="contents">
</div>
</div>
<script src="/static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="/static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'util','wangEditor'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.jquery,
            wangEditor = layui.wangEditor;

        var editor = new wangEditor('#editor');
        // editor.customConfig.uploadImgServer = "../api/upload.json";
        // editor.customConfig.uploadFileName = 'image';
        // editor.customConfig.pasteFilterStyle = false;
        // editor.customConfig.uploadImgMaxLength = 5;
        // editor.customConfig.uploadImgHooks = {
        //     // 上传超时
        //     timeout: function (xhr, editor) {
        //         layer.msg('上传超时！')
        //     },
        //     // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        //     customInsert: function (insertImg, result, editor) {
        //         console.log(result);
        //         if (result.code == 1) {
        //             var url = result.data.url;
        //             url.forEach(function (e) {
        //                 insertImg(e);
        //             })
        //         } else {
        //             layer.msg(result.msg);
        //         }
        //     }
        // };
        editor.customConfig.customAlert = function (info) {
            layer.msg(info);
        };

        editor.customConfig.onchange = function (newHtml) {
            $("#contents").val(newHtml);
        };
        editor.create();



        //监听提交
        form.on('submit(saveBtn)', function (data) {
            layer.confirm('确定要添加?', {icon: 3, title:'添加'}, function(index){

                console.log($("#contents").val());

                data.field.content = $("#contents").val();

                $.ajax({
                    url: ADD_NOTICE_SUBMIT,
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
                                parent.location.reload();
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