<%--
  Created by IntelliJ IDEA.
  User: jinelei
  Date: 17-4-9
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h1>Login</h1>
<h2>asdfasdf</h2>
<form name='f' action="/perform_login" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="${_csrf.parameterNmae}" value="${_csrf.token}"/>
                <input name="submit" type="submit" value="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
