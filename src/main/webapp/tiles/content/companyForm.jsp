<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="companyForm.header">
        <s:hidden name="company.id"/>
        <s:hidden name="companyId" value="%{company.id}"/>
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

        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="company.supervisorSection"/></div>
            <div class="panel-body">

                <s:if test="supervisorList.size() > 0">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="no-sort"></th>
                            <th><s:text name="tableView.firstName"/></th>
                            <th><s:text name="tableView.lastName"/></th>
                        </tr>
                        </thead>

                        <s:iterator value="supervisorList">
                            <tr class="notFirst">
                                <td><s:radio name="supervisorId" list="#{id:''}"
                                             theme="simple"/></td>
                                <td><s:property value="firstName"/></td>
                                <td><s:property value="lastName"/></td>
                            </tr>
                        </s:iterator>
                    </table>

                </s:if>
                <s:submit key="button.addSupervisor" action="addSupervisor" cssClass="btn"/>
                <s:if test="supervisorList.size() > 0">
                    <s:submit key="button.deleteSelectedSupervisor" action="deleteSupervisor" cssClass="btn"/>
                </s:if>
            </div>
        </div>
        <s:submit key="button.saveCompany" action="saveCompany" cssClass="btn"/>
        <s:submit key="button.cancel" action="cancelCompany" cssClass="btn"/>
    </s:form>
</div>