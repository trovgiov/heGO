<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User</title>
</head>
<body>
<h1>Gli utenti nel db sono:</h1>
<br/>

<s:iterator value="lista" status="itstatus">

    <s:property value="iduser"/>
    <s:property value="name"/>
    <s:property value="surname"/>
    <br/>
  </s:iterator>
</body>
</html>
