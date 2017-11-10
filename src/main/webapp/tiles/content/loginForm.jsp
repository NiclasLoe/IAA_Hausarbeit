<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <s:form action="loginUser" theme="bootstrap" cssClass="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading"><h2><s:text name="login.header"/></h2></div>
            <div class="panel-body">
                <s:textfield name="userName" key="login.username"/>
                <s:textfield name="password" key="login.password" type="password"/>
                <s:actionerror/>
                <s:submit key="button.login" cssClass="btn"/>
            </div>
        </div>
    </s:form>
</div>