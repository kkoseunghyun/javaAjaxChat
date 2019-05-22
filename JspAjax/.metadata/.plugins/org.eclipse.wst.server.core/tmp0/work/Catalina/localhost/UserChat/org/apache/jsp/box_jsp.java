/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.38
 * Generated at: 2019-05-22 05:54:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class box_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");

	String userID = null;
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null) { 
		session.setAttribute("messageType", "오류 메세지");
		session.setAttribute("messageContent", "현재 로그인이 되어 있지 않습니다."); 
		response.sendRedirect("index.jsp");	
		return;
	}

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom2.css\">\r\n");
      out.write("\t<title>JSP Ajax 실시간 회원제 채팅 서비스</title>\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction getUnread() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\turl: \"./chatUnread\",\r\n");
      out.write("\t\t\t\tdata: {\r\n");
      out.write("\t\t\t\t\tuserID: encodeURIComponent('");
      out.print( userID );
      out.write("'),\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess: function(result) {\r\n");
      out.write("\t\t\t\t\tif(result >= 1) {\r\n");
      out.write("\t\t\t\t\t\tshowUnread(result);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tshowUnread('');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction getInfiniteUnread() {\r\n");
      out.write("\t\t\tsetInterval(function() {\r\n");
      out.write("\t\t\t\tgetUnread();\r\n");
      out.write("\t\t\t}, 4000);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction showUnread(result) {\r\n");
      out.write("\t\t\t$('#unread').html(result);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction chatBoxFunction() {\r\n");
      out.write("\t\t\tvar userID = '");
      out.print( userID );
      out.write("';\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\turl: \"./chatBox\",\r\n");
      out.write("\t\t\t\tdata: {\r\n");
      out.write("\t\t\t\t\tuserID: encodeURIComponent(userID),\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\tif(data == \"\") return;\r\n");
      out.write("\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t$('#boxTable').html('');\r\n");
      out.write("\t\t\t\t\tvar parsed = JSON.parse(data);\r\n");
      out.write("\t\t\t\t\tvar result = parsed.result;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < result.length; i++) {\r\n");
      out.write("\t\t\t\t\t\tif(result[i][0].value1 == userID) {\r\n");
      out.write("\t\t\t\t\t\t\tresult[i][0].value1 = result[i][0].value2;\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tresult[i][0].value2 = result[i][0].value1;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\taddBox(result[i][0].value1, result[i][0].value2, result[i][0].value3, result[i][0].value4, result[i][0].value5);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction addBox(lastID, toId, chatContent, chatTime, unread) {\r\n");
      out.write("\t\t\t$('#boxTable').append('<tr onclick=\"location.href=\\'chat.jsp?toID=' + toId + '\\'\">' +\r\n");
      out.write("\t\t\t\t\t'<td style=\"width: 150px;\"><h5>' + lastID + '</h5></td>' +\r\n");
      out.write("\t\t\t\t\t'<td>' +\r\n");
      out.write("\t\t\t\t\t'<h5>' + chatContent + \r\n");
      out.write("\t\t\t\t\t'&nbsp' +\r\n");
      out.write("\t\t\t\t\t'<span class=\"label label-info\">' + unread + '</span></h5>' +\r\n");
      out.write("\t\t\t\t\t'<div class=\"pull-right\">' + chatTime + '</div>' +\r\n");
      out.write("\t\t\t\t\t'</td>' +\r\n");
      out.write("\t\t\t\t\t'</tr>');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction getInfiniteBox() {\r\n");
      out.write("\t\t\tsetInterval(function() {\r\n");
      out.write("\t\t\t\tchatBoxFunction();\r\n");
      out.write("\t\t\t}, 3000);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"index.jsp\">실시간 회원제 채팅 서비스</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"index.jsp\">메인</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"find.jsp\">친구찾기</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"box.jsp\">메세지함<span id=\"unread\" class=\"label label-info\"></span></a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">회원관리<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"update.jsp\">회원정보수정</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"logoutAction.jsp\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<table class=\"table\" style=\"margin: 0 auto;\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th><h4>주고받은 메세지 목록</h4></th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<div style=\"overflow-y: auto; width: 100%; max-height: 450px;\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-bordered table-hover\" style=\"text-align: center; border: 1px solid #dddddd; margin: 0 auto;\">\r\n");
      out.write("\t\t\t\t\t<tbody id=\"boxTable\">\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");

		String messageContent = null;
		if (session.getAttribute("messageContent") != null) {
			messageContent = (String) session.getAttribute("messageContent");
		}
		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String) session.getAttribute("messageType");
		}
		if (messageContent != null) {
	
      out.write("\r\n");
      out.write("\t<!--  messageModal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"messageModal\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"vertical-alignment-helper\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog vertical-align-center\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-content ");
 if(messageType.equals("오류 메세지")) out.println("panel-warning"); else out.println("panel-success");
      out.write(" \">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t\t\t<span aria-hidden=\"true\">&times</span>\t\t<!-- x버튼 -->\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"sr-only\">Close</span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"modal-title\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print( messageType );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( messageContent );
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">확인</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

		session.removeAttribute("messageContent");
		session.removeAttribute("messageType");
		}
	
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('#messageModal').modal(\"show\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");

		if(userID != null) {
	
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t\tgetUnread(); // 4초 안기다리고 바로 볼 수 있게 먼저해놓음 \r\n");
      out.write("\t\t\t\tgetInfiniteUnread();\r\n");
      out.write("\t\t\t\tchatBoxFunction(); // 4초 안기다리고 바로 볼 수 있게 먼저해놓음 \r\n");
      out.write("\t\t\t\tgetInfiniteBox();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
