<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form action="loginUser" theme="bootstrap" cssClass="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading"><h2><s:text name="login.header"/></h2></div>
            <div class="panel-body">
                <s:textfield name="userName" label="login.username"></s:textfield>
                <s:textfield name="password" label="login.password" type="password"></s:textfield>
                <s:submit value="login"></s:submit>
                <s:actionerror/>
            </div>
        </div>
    </s:form>
</div>