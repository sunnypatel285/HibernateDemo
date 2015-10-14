<%-- 
    Document   : index
    Created on : 6 Oct, 2015, 4:23:56 PM
    Author     : sunnyp
--%>

<%@page import="org.apache.catalina.util.Base64"%>
<%@page import="com.ecw.pojo.Staff"%>
<%@page import="com.ecw.dao.StaffDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
StaffDaoImpl st = new StaffDaoImpl();
Staff staff = st.getStaff(5);
String s = new String(staff.getPicture());
String url = "data:image/jpg,base64," + Base64.encode(staff.getPicture());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Hello, <%=staff.getFirstName()%> !
        <%=staff.getPicture()%>
        <img src="/HibernateDemo/UploadedPhoto?id=5"/>
    </body>
</html>
