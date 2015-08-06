<%@ taglib uri="/struts-tags-extd" prefix="s"%>
<!DOCTYPE html>

<html>
<head>
<title>Hello World</title>
</head>
<body>
Hello World!<br/>
<%
out.println("Your IP address is " + request.getRemoteAddr());
%>
</body>
</html>