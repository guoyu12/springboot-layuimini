/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : gyadmin

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2021-05-27 18:28:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gy_menus
-- ----------------------------
DROP TABLE IF EXISTS `gy_menus`;
CREATE TABLE `gy_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `href` varchar(255) DEFAULT NULL COMMENT '链接',
  `image` varchar(255) DEFAULT NULL COMMENT '背景图片',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` tinyint(2) NOT NULL DEFAULT '2' COMMENT '0代表首页1 logo 2目录',
  `target` varchar(255) DEFAULT NULL COMMENT '打开方式',
  `sort` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gy_menus
-- ----------------------------
INSERT INTO `gy_menus` VALUES ('1', '首页', '/static/page/welcome.html', '', '', '0', '0', '2021-05-26 13:49:43', '2021-05-26 19:07:53', '0', '', '0');
INSERT INTO `gy_menus` VALUES ('2', 'LAYUI MINI', '', '/static/images/logo.png', '', '0', '0', '2021-05-26 13:50:52', '2021-05-26 18:47:15', '1', '', '0');
INSERT INTO `gy_menus` VALUES ('3', '常规管理', '', null, 'fa fa-address-book', '0', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('4', '主页模板', '', null, 'fa fa-home', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('5', '主页一', 'page/welcome-1.html', null, 'fa fa-tachometer', '4', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('6', '主页二', 'page/welcome-2.html', null, 'fa fa-tachometer', '4', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('7', '主页三', 'page/welcome-3.html', null, 'fa fa-tachometer', '4', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('8', '菜单管理', 'page/menu.html', null, 'fa fa-window-maximize', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('9', '系统设置', 'page/setting.html', null, 'fa fa-gears', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('10', '表格示例', 'page/table.html', null, 'fa fa-file-text', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('11', '表单示例', '', null, 'fa fa-calendar', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('12', '普通表单', 'page/form.html', null, 'fa fa-list-alt', '11', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('13', '分步表单', 'page/form-step.html', null, 'fa fa-navicon', '11', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('14', '登录模板', '', null, 'fa fa-flag-o', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('15', '登录-1', 'page/login-1.html', null, 'fa fa-stumbleupon-circle', '14', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_blank', '0');
INSERT INTO `gy_menus` VALUES ('16', '登录-2', 'page/login-2.html', null, 'fa fa-viacoin', '14', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_blank', '0');
INSERT INTO `gy_menus` VALUES ('17', '登录-3', 'page/login-3.html', null, 'fa fa-tags', '14', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_blank', '0');
INSERT INTO `gy_menus` VALUES ('18', '异常页面', '', null, 'fa fa-home', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('19', '404页面', 'page/404.html', null, 'fa fa-hourglass-end', '18', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('20', '其它界面', '', null, 'fa fa-snowflake-o', '3', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '', '0');
INSERT INTO `gy_menus` VALUES ('21', '按钮示例', 'page/button.html', null, 'fa fa-snowflake-o', '20', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('22', '弹出层', 'page/layer.html', null, 'fa fa-shield', '20', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('23', '组件管理', '', null, 'fa fa-lemon-o', '0', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('24', '图标列表', 'page/icon.html', null, 'fa fa-dot-circle-o', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('25', '图标选择', 'page/icon-picker.html', null, 'fa fa-adn', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('26', '颜色选择', 'page/color-select.html', null, 'fa fa-dashboard', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('27', '下拉选择', 'page/table-select.html', null, 'fa fa-angle-double-down', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('28', '文件上传', 'page/upload.html', null, 'fa fa-arrow-up', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('29', '富文本编辑器', 'page/editor.html', null, 'fa fa-edit', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('30', '省市县区选择器', 'page/area.html', null, 'fa fa-rocket', '23', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('31', '其它管理', '', null, 'fa fa-slideshare', '0', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('32', '多级菜单', '', null, 'fa fa-meetup', '31', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '', '0');
INSERT INTO `gy_menus` VALUES ('33', '按钮1', 'page/button.html?v=1', null, 'fa fa-calendar', '32', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('34', '按钮2', 'page/button.html?v=2', null, 'fa fa-snowflake-o', '33', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('35', '按钮3', 'page/button.html?v=3', null, 'fa fa-snowflake-o', '34', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('36', '表单4', 'page/form.html?v=1', null, 'fa fa-calendar', '34', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');
INSERT INTO `gy_menus` VALUES ('37', '失效菜单', 'page/error.html', null, 'fa fa-superpowers', '31', '0', '2021-05-26 14:07:58', '2021-05-26 14:07:58', '2', '_self', '0');

-- ----------------------------
-- Table structure for gy_request_log
-- ----------------------------
DROP TABLE IF EXISTS `gy_request_log`;
CREATE TABLE `gy_request_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `code` int(3) DEFAULT NULL,
  `request_uri` varchar(255) DEFAULT NULL,
  `ip_addr` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `request_param` text,
  `response_msg` varchar(255) DEFAULT NULL,
  `response_data` text,
  `trace_stack` text COMMENT '错误信息',
  `create_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gy_request_log
-- ----------------------------
INSERT INTO `gy_request_log` VALUES ('1', null, '0', '/test/json', '127.0.0.1', '{}', null, '{\"code\":0,\"data\":{\"username\":\"qwe\"},\"msg\":\"success\"}', null, '2021-05-27 18:23:21');
INSERT INTO `gy_request_log` VALUES ('2', null, '1', '/test/json', '127.0.0.1', '{}', 'Required request body is missing: public com.anshark.response.ResultType com.anshark.controller.test.TestController.body(com.anshark.model.GyUsers)', '{\"code\":1,\"msg\":\"error\"}', 'org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing: public com.anshark.response.ResultType com.anshark.controller.test.TestController.body(com.anshark.model.GyUsers)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.readWithMessageConverters(RequestResponseBodyMethodProcessor.java:161)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:131)\r\n	at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121)\r\n	at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:170)\r\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:137)\r\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)\r\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1063)\r\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)\r\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\r\n	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)\r\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)\r\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\r\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\r\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\r\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\r\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\r\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\r\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357)\r\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\r\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\r\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893)\r\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1707)\r\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\r\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\r\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n	at java.lang.Thread.run(Thread.java:748)\r\n', '2021-05-27 18:23:42');
INSERT INTO `gy_request_log` VALUES ('3', null, '0', '/test/json', '127.0.0.1', '{}', null, '{\"code\":0,\"data\":{\"username\":\"qwe\"},\"msg\":\"success\"}', null, '2021-05-27 18:26:33');
INSERT INTO `gy_request_log` VALUES ('4', null, '3', '/users/logout', '127.0.0.1', '{}', '已退出', '{\"code\":3,\"msg\":\"已退出\"}', 'com.anshark.exception.SysException', '2021-05-27 18:26:48');
INSERT INTO `gy_request_log` VALUES ('5', null, '3', '/users/indexData', '127.0.0.1', '{}', '已退出', '{\"code\":3,\"msg\":\"已退出\"}', 'com.anshark.exception.SysException', '2021-05-27 18:26:58');
INSERT INTO `gy_request_log` VALUES ('6', null, '0', '/login/submit', '127.0.0.1', '{\"username\":[\"admin\"],\"password\":[\"admin\"],\"captcha\":[\"cekb\"]}', null, '{\"code\":0,\"data\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMSIsImNyZWF0ZV9hdCI6MTYyMjExMTIyNTgwMCwiZXhwIjoxNjIyNzE2MDI1LCJpYXQiOjE2MjIxMTEyMjV9.RWnz8S5keHPGSD0w6IMhl89ymKGtzONrEvN7RqQFQI0\",\"msg\":\"success\"}', null, '2021-05-27 18:27:06');
INSERT INTO `gy_request_log` VALUES ('7', '1', '0', '/users/indexData', '127.0.0.1', '{}', null, '{\"code\":0,\"data\":{\"homeInfo\":{\"createAt\":\"2021-05-26T13:49:43\",\"href\":\"/static/page/welcome.html\",\"icon\":\"\",\"id\":1,\"image\":\"\",\"isDeleted\":false,\"parentId\":0,\"sort\":0,\"target\":\"\",\"title\":\"首页\",\"type\":0,\"updateAt\":\"2021-05-26T19:07:53\"},\"logoInfo\":{\"createAt\":\"2021-05-26T13:50:52\",\"href\":\"\",\"icon\":\"\",\"id\":2,\"image\":\"/static/images/logo.png\",\"isDeleted\":false,\"parentId\":0,\"sort\":0,\"target\":\"\",\"title\":\"LAYUI MINI\",\"type\":1,\"updateAt\":\"2021-05-26T18:47:15\"},\"menuInfo\":[{\"child\":[{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/welcome-1.html\",\"icon\":\"fa fa-tachometer\",\"id\":5,\"isDeleted\":false,\"parentId\":4,\"sort\":0,\"target\":\"_self\",\"title\":\"主页一\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/welcome-2.html\",\"icon\":\"fa fa-tachometer\",\"id\":6,\"isDeleted\":false,\"parentId\":4,\"sort\":0,\"target\":\"_self\",\"title\":\"主页二\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/welcome-3.html\",\"icon\":\"fa fa-tachometer\",\"id\":7,\"isDeleted\":false,\"parentId\":4,\"sort\":0,\"target\":\"_self\",\"title\":\"主页三\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-home\",\"id\":4,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"主页模板\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/menu.html\",\"icon\":\"fa fa-window-maximize\",\"id\":8,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"菜单管理\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/setting.html\",\"icon\":\"fa fa-gears\",\"id\":9,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"系统设置\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/table.html\",\"icon\":\"fa fa-file-text\",\"id\":10,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"表格示例\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/form.html\",\"icon\":\"fa fa-list-alt\",\"id\":12,\"isDeleted\":false,\"parentId\":11,\"sort\":0,\"target\":\"_self\",\"title\":\"普通表单\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/form-step.html\",\"icon\":\"fa fa-navicon\",\"id\":13,\"isDeleted\":false,\"parentId\":11,\"sort\":0,\"target\":\"_self\",\"title\":\"分步表单\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-calendar\",\"id\":11,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"表单示例\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/login-1.html\",\"icon\":\"fa fa-stumbleupon-circle\",\"id\":15,\"isDeleted\":false,\"parentId\":14,\"sort\":0,\"target\":\"_blank\",\"title\":\"登录-1\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/login-2.html\",\"icon\":\"fa fa-viacoin\",\"id\":16,\"isDeleted\":false,\"parentId\":14,\"sort\":0,\"target\":\"_blank\",\"title\":\"登录-2\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/login-3.html\",\"icon\":\"fa fa-tags\",\"id\":17,\"isDeleted\":false,\"parentId\":14,\"sort\":0,\"target\":\"_blank\",\"title\":\"登录-3\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-flag-o\",\"id\":14,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"登录模板\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/404.html\",\"icon\":\"fa fa-hourglass-end\",\"id\":19,\"isDeleted\":false,\"parentId\":18,\"sort\":0,\"target\":\"_self\",\"title\":\"404页面\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-home\",\"id\":18,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"_self\",\"title\":\"异常页面\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/button.html\",\"icon\":\"fa fa-snowflake-o\",\"id\":21,\"isDeleted\":false,\"parentId\":20,\"sort\":0,\"target\":\"_self\",\"title\":\"按钮示例\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/layer.html\",\"icon\":\"fa fa-shield\",\"id\":22,\"isDeleted\":false,\"parentId\":20,\"sort\":0,\"target\":\"_self\",\"title\":\"弹出层\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-snowflake-o\",\"id\":20,\"isDeleted\":false,\"parentId\":3,\"sort\":0,\"target\":\"\",\"title\":\"其它界面\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-address-book\",\"id\":3,\"isDeleted\":false,\"parentId\":0,\"sort\":0,\"target\":\"_self\",\"title\":\"常规管理\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/icon.html\",\"icon\":\"fa fa-dot-circle-o\",\"id\":24,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"图标列表\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/icon-picker.html\",\"icon\":\"fa fa-adn\",\"id\":25,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"图标选择\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/color-select.html\",\"icon\":\"fa fa-dashboard\",\"id\":26,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"颜色选择\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/table-select.html\",\"icon\":\"fa fa-angle-double-down\",\"id\":27,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"下拉选择\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/upload.html\",\"icon\":\"fa fa-arrow-up\",\"id\":28,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"文件上传\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/editor.html\",\"icon\":\"fa fa-edit\",\"id\":29,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"富文本编辑器\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/area.html\",\"icon\":\"fa fa-rocket\",\"id\":30,\"isDeleted\":false,\"parentId\":23,\"sort\":0,\"target\":\"_self\",\"title\":\"省市县区选择器\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-lemon-o\",\"id\":23,\"isDeleted\":false,\"parentId\":0,\"sort\":0,\"target\":\"_self\",\"title\":\"组件管理\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"child\":[{\"child\":[{\"child\":[{\"child\":[{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/button.html?v=3\",\"icon\":\"fa fa-snowflake-o\",\"id\":35,\"isDeleted\":false,\"parentId\":34,\"sort\":0,\"target\":\"_self\",\"title\":\"按钮3\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/form.html?v=1\",\"icon\":\"fa fa-calendar\",\"id\":36,\"isDeleted\":false,\"parentId\":34,\"sort\":0,\"target\":\"_self\",\"title\":\"表单4\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/button.html?v=2\",\"icon\":\"fa fa-snowflake-o\",\"id\":34,\"isDeleted\":false,\"parentId\":33,\"sort\":0,\"target\":\"_self\",\"title\":\"按钮2\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/button.html?v=1\",\"icon\":\"fa fa-calendar\",\"id\":33,\"isDeleted\":false,\"parentId\":32,\"sort\":0,\"target\":\"_self\",\"title\":\"按钮1\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-meetup\",\"id\":32,\"isDeleted\":false,\"parentId\":31,\"sort\":0,\"target\":\"\",\"title\":\"多级菜单\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"},{\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"page/error.html\",\"icon\":\"fa fa-superpowers\",\"id\":37,\"isDeleted\":false,\"parentId\":31,\"sort\":0,\"target\":\"_self\",\"title\":\"失效菜单\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}],\"createAt\":\"2021-05-26T14:07:58\",\"href\":\"\",\"icon\":\"fa fa-slideshare\",\"id\":31,\"isDeleted\":false,\"parentId\":0,\"sort\":0,\"target\":\"_self\",\"title\":\"其它管理\",\"type\":2,\"updateAt\":\"2021-05-26T14:07:58\"}]},\"msg\":\"success\"}', null, '2021-05-27 18:27:07');
INSERT INTO `gy_request_log` VALUES ('8', '1', '0', '/users/logout', '127.0.0.1', '{}', null, '{\"code\":0,\"msg\":\"success\"}', null, '2021-05-27 18:27:28');

-- ----------------------------
-- Table structure for gy_roles
-- ----------------------------
DROP TABLE IF EXISTS `gy_roles`;
CREATE TABLE `gy_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gy_roles
-- ----------------------------
INSERT INTO `gy_roles` VALUES ('1', '超级管理员', '2021-05-26 19:19:23', '2021-05-26 19:19:23', '0');
INSERT INTO `gy_roles` VALUES ('2', '管理员', '2021-05-26 19:19:30', '2021-05-26 19:19:30', '0');
INSERT INTO `gy_roles` VALUES ('3', '财务', '2021-05-26 19:19:38', '2021-05-26 19:19:38', '0');

-- ----------------------------
-- Table structure for gy_user_perm
-- ----------------------------
DROP TABLE IF EXISTS `gy_user_perm`;
CREATE TABLE `gy_user_perm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_perm` varchar(255) DEFAULT NULL COMMENT '用户权限用英文逗号隔开',
  `is_deleted` tinyint(1) DEFAULT '0',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gy_user_perm
-- ----------------------------
INSERT INTO `gy_user_perm` VALUES ('1', '1', '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37', '0', '2021-05-26 19:20:07', '2021-05-26 19:20:07');

-- ----------------------------
-- Table structure for gy_user_role
-- ----------------------------
DROP TABLE IF EXISTS `gy_user_role`;
CREATE TABLE `gy_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_role` varchar(255) NOT NULL COMMENT '用户角色用英文逗号隔开',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gy_user_role
-- ----------------------------
INSERT INTO `gy_user_role` VALUES ('1', '1', '1,2,3', '0', '2021-05-26 19:19:12', '2021-05-26 19:20:22');

-- ----------------------------
-- Table structure for gy_users
-- ----------------------------
DROP TABLE IF EXISTS `gy_users`;
CREATE TABLE `gy_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gy_users
-- ----------------------------
INSERT INTO `gy_users` VALUES ('1', 'admin', 'a5e1cf4af5c5c39124ad242b3ed48f42', '2021-05-26 19:17:50', '2021-05-27 10:41:06', '0');
