<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="companyForm.header">
        <s:hidden name="company.id"/>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="company.nameSection"/></div>
            <div class="panel-body">
                <s:textfield key="company.companyName1"/>
                <s:textfield key="company.companyName2"/>
                <s:textfield key="company.shortName"/>
                <s:textfield key="company.contactPerson"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="company.contactInformation"/></div>
            <div class="panel-body">
                <s:textfield key="company.phoneNumber"/>
                <s:textfield key="company.faxNumber"/>
                <s:textfield key="company.mailAddress"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="company.addressInformation"/></div>
            <div class="panel-body">
                <s:textfield key="company.streetName"/>
                <s:textfield key="company.houseNumber"/>
                <s:textfield key="company.postalCode"/>
                <s:textfield key="company.city"/>
            </div>
        </div>
        <s:submit key="button.saveCompany" action="saveCompany" cssClass="btn"/>
        <s:submit key="button.cancel" action="cancelCompany" cssClass="btn"/>
    </s:form>
</div>