<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>


<h1><s:property value="nome" /></h1>
<h1><s:property value="cognome" /></h1>

<p>Capture Image: <input type="file" accept="image/*" id="capture" capture="camera">

</body>
</html>



