<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h2><s:text name="droppedOut.header"/></h2></div>
        <div class="panel-body">
            <s:form theme="bootstrap">
                <div class="form-group">
                    <s:submit key="button.filterList" action="filterDroppedOut" cssClass="btn"/>
                    <s:submit key="button.clearFilter" action="showDroppedOutStudent" cssClass="btn"/>
                </div>
                <table class="table">
                    <tr >
                        <th></th>
                        <th><s:text name="tableView.StudentId"/></th>
                        <th><s:text name="tableView.lastName"/></th>
                        <th><s:text name="tableView.firstName"/></th>
                        <th><s:text name="tableView.centuryName"/></th>
                        <th><s:text name="tableView.emailAddress"/></th>
                        <th><s:text name="tableView.status"/></th>
                    </tr>
                    <s:iterator value="studentList">
                        <tr class="notFirst">
                            <td><s:radio name="studentId" list="#{id:''}" theme="simple" onselect=""/></td>
                            <td class="tdApplicantView"><s:property value="studentId"/></td>
                            <td class="tdApplicantView"><s:property value="lastName"/></td>
                            <td class="tdApplicantView"><s:property value="firstName"/></td>
                            <td class="tdApplicantView"><s:property value="%{century.centuryName}"/></td>
                            <td class="tdApplicantView"><s:property value="emailAddress"/></td>
                            <td class="tdApplicantView"><s:property value="status"/></td>
                        </tr>
                    </s:iterator>
                    <tr></tr>
                </table>
                <s:actionerror/>
                <div class="form-group">
                    <s:submit key="button.seeMore" action="loadDroppedOut" cssClass="btn"/>
                    <s:hidden id="buttonYes" name="buttonYes" value="%{getText('button.yes')}"/>
                    <s:hidden id="buttonNo" name="buttonNo" value="%{getText('button.no')}"/>
                    <s:submit key="button.reenrollDroppedOut" onclick="return confirmAction(this, 'reEnrollStudent');" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showAdminArea" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>
<div id="dialog-confirm" class="hiddenModal" title="Dialog">
    <s:text name="confirm.reEnrollStudent"></s:text>
</div>