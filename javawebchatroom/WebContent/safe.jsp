<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%if(null == session.getAttribute("existUser")){
	out.println("<script language='javascript'>alert('您的账户已经过期，请重新登录!');window.location='login.jsp';</script>");
	return;
}%>
