<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading"><h2><s:text name="supervisor.addNewSupervisor"/></h2></div>
            <div class="panel-body">
                <s:hidden name="company.id"/>
                <s:hidden name="companyId" value="%{company.id}"/>
                <s:hidden name="supervisor.id"/>
                <s:textfield key="supervisor.firstName"/>
                <s:textfield key="supervisor.lastName"/>
            </div>
        </div>
        <s:submit key="button.addSupervisor" action="addSupervisorToCompany" cssClass="btn"/>
        <s:submit key="button.goBack" action="loadCompany" cssClass="btn"/>
    </s:form>
</div>