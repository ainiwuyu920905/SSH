<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    	<html:form action="/person/personManage" method="post">
    		name:<html:text property="name"/>
    		<html:submit title="submit"/>
    		<input type="hidden" name="method" value="add">
    	</html:form>
  </body>
</html>
