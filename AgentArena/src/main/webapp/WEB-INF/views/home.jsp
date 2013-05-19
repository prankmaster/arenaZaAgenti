<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form>
<textarea id="code" cols="80" rows="30" name="code" style="overflow: auto">
</textarea>
<button type="submit" name="submit_code" formmethod="post">Send code</button>
</form>
</body>
</html>
