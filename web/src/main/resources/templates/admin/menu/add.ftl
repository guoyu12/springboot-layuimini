<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet" href="/static/lib/layui-v2.6.3/css/layui.css" media="all">
    </head>
    <body>
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label required">标题</label>
                <div class="layui-input-inline">
                    <input type="text" name="title" placeholder="请输入菜单标题" class="layui-input" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">链接</label>
                <div class="layui-input-inline">
                    <input type="text" name="href" placeholder="请输入菜单链接" class="layui-input" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">图标</label>
                <div class="layui-input-inline">
                    <input type="text" name="icon" placeholder="请输入图标" class="layui-input" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">父ID</label>
                <div class="layui-input-inline">
                    <input type="text" name="parentId" placeholder="父ID" class="layui-input" value="${id}" readonly="readonly">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">排序</label>
                <div class="layui-input-inline">
                    <input type="text" name="sort" placeholder="请输入序列值" class="layui-input" value="">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">类型</label>
                <div class="layui-input-block">
                    <input type="radio" name="isMenu" value="0" title="菜单" checked="checked">
                    <input type="radio" name="isMenu" value="1" title="按钮">
                    <input type="radio" name="isMenu" value="2" title="目录">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label required">打开方式</label>
                <div class="layui-input-inline">
                    <input type="radio" name="target" value="_self" title="本窗口" checked="checked">
                    <input type="radio" name="target" value="_blank" title="新窗口">
                </div>

            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">是否是快捷入口</label>
                <div class="layui-input-block">
                    <input type="radio" name="isQuickEntry" value="0" title="非快捷入口" checked="checked">
                    <input type="radio" name="isQuickEntry" value="1" title="快捷入口">
                </div>
            </div>

            <div class='layui-form-item'>
                <div class='layui-input-block'>
                    <button class='layui-btn layui-btn-normal' lay-submit lay-filter='menuAdd'>确认保存</button>
                </div>
            </div>
        </form>
        <script src="/static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
        <script src="/static/js/commons.js" charset="UTF-8"></script>
        <script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
        <script>
            layui.use(['jquery','form'], function () {
                var form = layui.form;
                form.on('submit(menuAdd)', function (data) {
                    layer.confirm('确定要添加?', {icon: 3, title:'添加'}, function(index){
                        $.ajax({
                            url: ADD_MENU_URL,
                            type: 'POST',
                            dataType: "json",
                            data:data.field,
                            beforeSend: function (request) {
                                request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                                request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                            },
                            success: function (result) {
                                if(result.code == 0){
                                    layer.msg("添加成功", {icon: 6,time: 2000},function () {
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

                    return false;
                });
            });
        </script>
    </body>
</html>