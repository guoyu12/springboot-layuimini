<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页二</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="/static/css/public.css" media="all">
    <style>
        .layui-card {border:1px solid #f2f2f2;border-radius:5px;}
        .icon {margin-right:10px;color:#1aa094;}
        .icon-cray {color:#ffb800!important;}
        .icon-blue {color:#1e9fff!important;}
        .icon-tip {color:#ff5722!important;}
        .layuimini-qiuck-module {text-align:center;margin-top: 10px}
        .layuimini-qiuck-module a i {display:inline-block;width:100%;height:60px;line-height:60px;text-align:center;border-radius:2px;font-size:30px;background-color:#F8F8F8;color:#333;transition:all .3s;-webkit-transition:all .3s;}
        .layuimini-qiuck-module a cite {position:relative;top:2px;display:block;color:#666;text-overflow:ellipsis;overflow:hidden;white-space:nowrap;font-size:14px;}
        .welcome-module {width:100%;height:210px;}
        .panel {background-color:#fff;border:1px solid transparent;border-radius:3px;-webkit-box-shadow:0 1px 1px rgba(0,0,0,.05);box-shadow:0 1px 1px rgba(0,0,0,.05)}
        .panel-body {padding:10px}
        .panel-title {margin-top:0;margin-bottom:0;font-size:12px;color:inherit}
        .label {display:inline;padding:.2em .6em .3em;font-size:75%;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:baseline;border-radius:.25em;margin-top: .3em;}
        .layui-red {color:red}
        .main_btn > p {height:40px;}
        .layui-bg-number {background-color:#F8F8F8;}
        .layuimini-notice:hover {background:#f6f6f6;}
        .layuimini-notice {padding:7px 16px;clear:both;font-size:12px !important;cursor:pointer;position:relative;transition:background 0.2s ease-in-out;}
        .layuimini-notice-title,.layuimini-notice-label {
            padding-right: 70px !important;text-overflow:ellipsis!important;overflow:hidden!important;white-space:nowrap!important;}
        .layuimini-notice-title {line-height:28px;font-size:14px;}
        .layuimini-notice-extra {position:absolute;top:50%;margin-top:-8px;right:16px;display:inline-block;height:16px;color:#999;}
    </style>
</head>
<body>
<input type="hidden" value="${uname}" id="uname">
<input type="hidden" value="${data}" id="datas">
<div class="layuimini-container">
    <div class="layuimini-main">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md8">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="layui-card-header"><i class="fa fa-warning icon"></i>数据统计</div>
                            <div class="layui-card-body">
                                <div class="welcome-module">
                                    <div class="layui-row layui-col-space10">
                                        <div class="layui-col-xs6">
                                            <div class="panel layui-bg-number">
                                                <div class="panel-body">
                                                    <div class="panel-title">
                                                        <span class="label pull-right layui-bg-blue">实时</span>
                                                        <h5>用户统计</h5>
                                                    </div>
                                                    <div class="panel-content">
                                                        <h1 class="no-margins" id="totalUserCount">${datastatist.totalUserCount}</h1>
                                                        <small>历史用户数</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="layui-col-xs6">
                                            <div class="panel layui-bg-number">
                                                <div class="panel-body">
                                                    <div class="panel-title">
                                                        <span class="label pull-right layui-bg-cyan">实时</span>
                                                        <h5>在线用户数</h5>
                                                    </div>
                                                    <div class="panel-content">
                                                        <h1 class="no-margins" id="totalUserOnlineCount">${datastatist.totalUserOnlineCount}</h1>
                                                        <small>在线用户数</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="layui-col-xs6">
                                            <div class="panel layui-bg-number">
                                                <div class="panel-body">
                                                    <div class="panel-title">
                                                        <span class="label pull-right layui-bg-orange">实时</span>
                                                        <h5>浏览总数</h5>
                                                    </div>
                                                    <div class="panel-content">
                                                        <h1 class="no-margins" id="totalBrowseCount">${datastatist.totalBrowseCount}</h1>
                                                        <small>历史浏览总数</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="layui-col-xs6">
                                            <div class="panel layui-bg-number">
                                                <div class="panel-body">
                                                    <div class="panel-title">
                                                        <span class="label pull-right layui-bg-green">实时</span>
                                                        <h5>当日浏览数</h5>
                                                    </div>
                                                    <div class="panel-content">
                                                        <h1 class="no-margins" id="totalBrowseTodayCount">${datastatist.totalBrowseTodayCount}</h1>
                                                        <small>日浏览数</small>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="layui-card-header"><i class="fa fa-credit-card icon icon-blue"></i>快捷入口</div>
                            <div class="layui-card-body">
                                <div class="welcome-module">
                                    <div class="layui-row layui-col-space10 layuimini-qiuck" id="quickEntry">
                                        <#list quickEntryList as list>
                                            <div class="layui-col-xs3 layuimini-qiuck-module">
                                                <a href="javascript:;" layuimini-content-href="${list.href}" data-title="${list.title}" data-icon="${list.icon}">
                                                    <i class="${list.icon}"></i>
                                                    <cite>${list.title}</cite>
                                                </a>
                                            </div>
                                        </#list>
                                        <div class="layui-col-xs3 layuimini-qiuck-module">
                                            <a href="javascript:;" layuimini-content-href="https://www.baidu.com" data-title="百度搜索" data-icon="fa fa-search">
                                                <i class="fa fa-search"></i>
                                                <cite>百度搜索</cite>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="layui-col-md12">
                        <div class="layui-card">
                            <div class="layui-card-header"><i class="fa fa-line-chart icon"></i>报表统计</div>
                            <div class="layui-card-body">
                                <div id="echarts-records" style="width: 100%;min-height:500px"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-col-md4">

                <div class="layui-card">
                    <div class="layui-card-header"><i class="fa fa-bullhorn icon icon-tip"></i>系统公告</div>
                    <div class="layui-card-body layui-text" id="sysNotices">
                        <#list notice as list>
                            <div class="layuimini-notice">
                                <div class="layuimini-notice-title">${list.title}</div>
                                <div class="layuimini-notice-extra">${(list.createAt).format('yyyy-MM-dd HH:ss:mm')}</div>
                                <div class="layuimini-notice-content layui-hide">
                                    ${list.content}
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>

                <div class="layui-card">
                    <div class="layui-card-header"><i class="fa fa-fire icon"></i>版本信息</div>
                    <div class="layui-card-body layui-text">
                        <table class="layui-table">
                            <colgroup>
                                <col width="100">
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>项目名</td>
                                <td>
                                    ${pro.projectName}
                                </td>
                            </tr>
                            <tr>
                                <td>当前版本</td>
                                <td>${pro.projectVersion}</td>
                            </tr>
                            <tr>
                                <td>主要特色</td>
                                <td>${pro.projectDesc}</td>
                            </tr>
                            <tr>
                                <td>Gitee</td>
                                <td style="padding-bottom: 0;">
                                    <a href="${pro.giteeUrl}" target="_blank">gitee</a>
                                </td>
                            </tr>
                            <tr>
                                <td>Github</td>
                                <td style="padding-bottom: 0;">
                                    <a href="${pro.githubUrl}" target="_blank">github</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="layui-card">
                    <div class="layui-card-header"><i class="fa fa-paper-plane-o icon"></i>作者心语</div>
                    <div class="layui-card-body layui-text layadmin-text">
                        <p>${authercontent}</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="/static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="/static/js/commons.js" charset="UTF-8"></script>
<script src="/static/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="/static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>

    layui.use(['layer', 'miniTab','echarts'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            miniTab = layui.miniTab,
            echarts = layui.echarts;

        miniTab.listen();

        var reportForm = ${reportForm};
        //首次加载
        report(reportForm);

        $(function () {

            var socket;
            //判断当前浏览器是否支持websocket
            if (window.WebSocket) {
                socket = new WebSocket(HOME_WEB_SOCKET_DATA);
                socket.onmessage = function (result) {
                    var obj = eval('(' + result.data + ')');
                    //1代表是实时统计的数据统计
                    if(obj.code == 1){
                        $("#totalUserCount").html(obj.data.totalUserCount);
                        $("#totalUserOnlineCount").html(obj.data.totalUserOnlineCount);
                        $("#totalBrowseCount").html(obj.data.totalBrowseCount);
                        $("#totalBrowseTodayCount").html(obj.data.totalBrowseTodayCount);
                    }
                    //2代表的是实时统计的报表统计
                    if(obj.code == 2){
                        report(obj.data);
                    }
                    //3代表的是实时快捷入口
                    if(obj.code == 3){
                        initQuickEntry(obj.data);
                    }

                    //4代表的是系统实时公告
                    if(obj.code == 4){
                        initSysNotice(obj.data);
                    }
                }
                //连接开启事件
                socket.onopen = function (result) {
                    var username = $("#uname").val();
                    var msg = {"code": 1, "msg": username};
                    socket.send(JSON.stringify(msg));

                }

                socket.onclose = function (result) {
                    console.log(JSON.stringify(result));
                }
            } else {
                alert("您的浏览器不支持websocket");
            }
        })

        /**
         * 查看公告信息
         **/
        $('body').on('click', '.layuimini-notice', function () {
            var title = $(this).children('.layuimini-notice-title').text(),
                noticeTime = $(this).children('.layuimini-notice-extra').text(),
                content = $(this).children('.layuimini-notice-content').html();
            var html = '<div style="padding:15px 20px; text-align:justify; line-height: 22px;border-bottom:1px solid #e2e2e2;background-color: #2f4056;color: #ffffff">\n' +
                '<div style="text-align: center;margin-bottom: 20px;font-weight: bold;border-bottom:1px solid #718fb5;padding-bottom: 5px"><h4 class="text-danger">' + title + '</h4></div>\n' +
                '<div style="font-size: 12px">' + content + '</div>\n' +
                '</div>\n';
            parent.layer.open({
                type: 1,
                title: '系统公告'+'<span style="float: right;right: 1px;font-size: 12px;color: #b1b3b9;margin-top: 1px">'+noticeTime+'</span>',
                area: '300px;',
                shade: 0.8,
                id: 'layuimini-notice',
                btn: ['查看', '取消'],
                btnAlign: 'c',
                moveType: 1,
                content:html,
                success: function (layero) {
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        href: 'https://gitee.com/zhongshaofa/layuimini',
                        target: '_blank'
                    });
                }
            });
        });

        //实时系统公告
        function initSysNotice(data) {
            $("#sysNotices").empty();
            var str = "";
            for(var i = 0;i<data.length;i++){
                var d = data[i];
                str += "<div class='layuimini-notice'>";
                str += "<div class='layuimini-notice-title'>"+d.title+"</div>";
                str += "<div class='layuimini-notice-extra'>"+d.createAt+"</div>";
                str += "<div class='layuimini-notice-content layui-hide'>";
                str += d.content;
                str += "</div>";
                str += "</div>";
            }
            $("#sysNotices").append(str);
        }

        //实时快捷入口
        function initQuickEntry(data) {
            $("#quickEntry").empty();
            var str = "";
            for(var i = 0;i<data.length;i++){
                var d = data[i];
                str += "<div class='layui-col-xs3 layuimini-qiuck-module'>";
                str += "<a href='javascript:;' layuimini-content-href='"+d.href+"' data-title='"+d.title+"' data-icon='"+d.icon+"'>";
                str += "<i class='"+d.icon+"'></i>";
                str += "<cite>"+d.title+"</cite>";
                str += "</a>";
                str += "</div>";
            }

            str += "<div class='layui-col-xs3 layuimini-qiuck-module'>";
            str += "<a href='javascript:;' layuimini-content-href='https://www.baidu.com' data-title='百度搜索' data-icon='fa fa-search'>";
            str += "<i class='fa fa-search'></i>";
            str += "<cite>百度搜索</cite>";
            str += "</a>";
            str += "</div>";

            $("#quickEntry").append(str);
        }

        // 实时报表
        function report(data) {

            var d = data;
            /**
             * 报表功能
             */
            var echartsRecords = echarts.init(document.getElementById('echarts-records'), 'walden');
            var optionRecords = {
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: d.types
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: d.dates
                },
                yAxis: {
                    type: 'value'
                },
                series: d.series
            };
            echartsRecords.setOption(optionRecords);

            // echarts 窗口缩放自适应
            window.onresize = function(){
                echartsRecords.resize();
            }
        }



    });
</script>
</body>
</html>
