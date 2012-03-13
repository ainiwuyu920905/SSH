<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'personlist.jsp' starting page</title>
    

  </head>
  
  <body>
    <c:forEach items="${personList }" var="person">
    	ID=${person.id }   Name=${person.name }<br/>
    </c:forEach>
  </body>
</html>
