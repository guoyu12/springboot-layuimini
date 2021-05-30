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
                        <select name="quiz1">
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

        </form>
        <script src="/static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
        <script src="/static/js/commons.js" charset="UTF-8"></script>
        <script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    </body>
</html>