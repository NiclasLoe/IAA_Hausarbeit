<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="loginUser">
    <s:textfield name="userName" label="User Name"></s:textfield>
    <s:textfield name="password" label="Password" type="password"></s:textfield>
    <s:submit value="login"></s:submit>
    <s:actionerror/>
</s:form>