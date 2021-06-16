//请求路径
const LOGIN_URL = "/login/submit";
//登录成功后跳转的请求
const LOGIN_SUC_URL = "/users/index";
//图片验证码请求
const IMAGE_CODE_URL = "/login/getVerifyCode";
//登录成功后获取数据的请求
const LOGIN_SUC_DATA_URL = "/users/indexData";
//退出请求
const LOGIN_OUT_URL = "/users/logout";
//登录页
const LOGIN_PAGE = "/login/page";
//菜单栏数据请求
const MENU_URL = "/gyMenus/list";
//系统配置请求
const SYS_CONFIG_LIST_URL = "/sysConfig/list";
//系统配置请求提交
const SYS_CONFIG_SUBMIT_URL = "/sysConfig/submit";
//删除菜单请求
const MENUS_DELETE_URL = "/gyMenus/delete";
//更新菜单
const MENUS_UPDATE = "/gyMenus/update";

//token
const GYADMIN_TOKEN = "GYADMIN_TOKEN";
//是否记住我
const LOGIN_WAY_REMEBER_ME = "GYADMIN_REMEBER_ME";

//修改密码请求
const EDIT_PASSWORD = "/users/editPassSubmit";

//添加菜单请求
const ADD_MENU_URL = "/gyMenus/addSubmit";

//用户信息
const USER_LIST_URL = "/users/list";
//用户设置更新
const USERSETTING_SUBMIT_URL = "/users/settingSubmit";
//用户删除
const USER_DEL_URL = "/users/del";
//编辑用户
const USER_EDIT_URL = "/users/editSubmit";
//新增用户
const USER_ADD_URL = "/users/addSubmit";
//netty
const HOME_WEB_SOCKET_DATA = "ws://localhost:9898/websocket";
//公告
const NOTICE_LIST = "/notice/list";

function setCookie(cname,cvalue,exdays){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = cname+"="+cvalue+"; "+expires+";path=/";
}
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) { return c.substring(name.length,c.length); }
    }
    return "";
}

function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null){
        document.cookie= name + "="+cval+";expires="+exp.toGMTString()+";path=/";;
    }

}