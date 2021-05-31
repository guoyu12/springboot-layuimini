<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet" href="/static/lib/layui-v2.6.3/css/layui.css" media="all">
    </head>
    <body>
        <form class="layui-form" action="">
            <input type="hidden" value="${menu.id}" name="id">
            <div class="layui-form-item">
                <label class="layui-form-label required">标题</label>
                <div class="layui-input-inline">
                    <input type="text" name="title" placeholder="请输入菜单标题" class="layui-input" value="${menu.title}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">链接</label>
                <div class="layui-input-inline">
                    <input type="text" name="href" placeholder="请输入菜单链接" class="layui-input" value="${menu.href}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">背景图片</label>
                <div class="layui-input-inline">
                    <input type="text" name="image" placeholder="请输入背景图片" class="layui-input" value="${menu.image}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">图标</label>
                <div class="layui-input-inline">
                    <input type="text" name="icon" placeholder="请输入图标" class="layui-input" value="${menu.icon}">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">父类</label>
                    <div class="layui-input-inline">
                        <select name="parentId">
                            <#list pList as p>
                                <#if p.id == menu.parentId>
                                    <option value="${p.id}" selected>${p.title}</option>
                                <#else>
                                    <option value="${p.id}">${p.title}</option>
                                </#if>

                            </#list>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">排序</label>
                <div class="layui-input-inline">
                    <input type="text" name="sort" placeholder="请输入序列值" class="layui-input" value="${menu.sort}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">类型</label>
                <div class="layui-input-block">
                    <input type="radio" name="isMenu" value="0" title="菜单" <#if menu.isMenu == 0>checked="checked"</#if>>
                    <input type="radio" name="isMenu" value="1" title="按钮" <#if menu.isMenu == 1>checked="checked"</#if>>
                    <input type="radio" name="isMenu" value="2" title="目录" <#if menu.isMenu == 2>checked="checked"</#if>>
                </div>
            </div>

            <div class='layui-form-item'>
                <div class='layui-input-block'>
                    <button class='layui-btn layui-btn-normal' lay-submit lay-filter='menuEdit'>确认保存</button>
                </div>
            </div>
        </form>
        <script src="/static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
        <script src="/static/js/commons.js" charset="UTF-8"></script>
        <script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
        <script>
            layui.use(['jquery','form'], function () {
                var form = layui.form;
                form.on('submit(menuEdit)', function (data) {
                    layer.confirm('确定要更新?', {icon: 3, title:'更新'}, function(index){
                        $.ajax({
                            url: MENUS_UPDATE,
                            type: 'POST',
                            dataType: "json",
                            data:data.field,
                            beforeSend: function (request) {
                                request.setRequestHeader(GYADMIN_TOKEN, getCookie(GYADMIN_TOKEN));
                                request.setRequestHeader(LOGIN_WAY_REMEBER_ME, getCookie(LOGIN_WAY_REMEBER_ME));
                            },
                            success: function (result) {
                                if(result.code == 0){
                                    layer.msg("更新成功", {icon: 6,time: 2000},function () {
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