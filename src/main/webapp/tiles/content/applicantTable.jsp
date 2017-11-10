<%@ page contentType="text/html;charset=UTF-8"%>
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
                <table class="table datatable-design" id="applicantTable">
                    <thead>
                        <tr>
                            <th class="no-sort"></th>
                            <th><s:text name="tableView.lastName"/></th>
                            <th><s:text name="tableView.firstName"/></th>
                            <th><s:text name="tableView.fieldOfStudy"/></th>
                            <th><s:text name="tableView.emailAddress"/></th>
                            <th><s:text name="tableView.phoneNumber"/></th>
                        </tr>
                    </thead>
                    <s:iterator value="personList">
                        <tr class="notFirst">
                            <td><s:radio name="applicantId" list="#{id:''}" theme="simple"
                                         onclick="return enableControls(this, [ '#buttonSeeMore', '#buttonEnrollApplicant', '#buttonDeleteApplicant' ]);"/></td>
                            <td><s:property value="lastName"/></td>
                            <td><s:property value="firstName"/></td>
                            <td><s:property value="fieldOfStudy"/></td>
                            <td><s:property value="emailAddress"/></td>
                            <td><s:property value="phoneNumber"/></td>
                        </tr>
                    </s:iterator>
                </table>
                <s:actionerror/>
                <div class="form-group">
                    <s:submit id="buttonSeeMore" key="button.seeMore" disabled="true" action="loadApplicant" cssClass="btn"/>
                    <s:hidden id="buttonYes" name="buttonYes" value="%{getText('button.yes')}"/>
                    <s:hidden id="buttonNo" name="buttonNo" value="%{getText('button.no')}"/>
                    <s:hidden id="modalTitle" name="modalTitle" value="%{getText('confirm.generic')}"/>
                    <s:submit id="buttonEnrollApplicant" key="button.enrollApplicant" disabled="true" action="enrollApplicant" cssClass="btn"/>
                    <s:submit id="buttonDeleteApplicant" key="button.deleteApplicant" disabled="true" onclick="return confirmAction(this, 'deleteApplicant');" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showMainPage" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>
<div id="dialog-confirm" class="hiddenModal" title="Dialog">
    <s:text name="confirm.deleteApplicant"></s:text>
</div>