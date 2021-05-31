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