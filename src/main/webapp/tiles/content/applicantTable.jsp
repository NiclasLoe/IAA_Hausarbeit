<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h2><s:text name="applicant.header"/></h2></div>
        <div class="panel-body">
            <s:form theme="bootstrap">
                <div class="form-group">
                    <s:submit key="button.newApplicant" action="addApplicant" cssClass="btn"/>
                    <s:submit key="button.filterList" action="filterApplicants" cssClass="btn"/>
                    <s:submit key="button.clearFilter" action="showApplicantList" cssClass="btn"/>
                </div>
                <table class="table table-hover">
                    <tr>
                        <th></th>
                        <th><s:text name="tableView.lastName"/></th>
                        <th><s:text name="tableView.firstName"/></th>
                        <th><s:text name="tableView.fieldOfStudy"/></th>
                        <th><s:text name="tableView.emailAddress"/></th>
                        <th><s:text name="tableView.phoneNumber"/></th>
                    </tr>
                    <s:iterator value="personList">
                        <tr>
                            <td><s:radio name="applicantId" list="#{id:''}" theme="simple" onselect=""/></td>
                            <td><s:property value="lastName"/></td>
                            <td><s:property value="firstName"/></td>
                            <td><s:property value="fieldOfStudy"/></td>
                            <td><s:property value="emailAddress"/></td>
                            <td><s:property value="phoneNumber"/></td>
                        </tr>
                    </s:iterator>
                    <tr></tr>
                </table>
                <s:actionerror/>
                <div class="form-group">
                    <s:submit key="button.seeMore" action="loadApplicant" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showMainPage" cssClass="btn"/>
                    <s:submit key="button.deleteApplicant" action="deleteApplicant" cssClass="btn"/>
                    <s:submit key="button.enrollApplicant" action="enrollApplicant" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>