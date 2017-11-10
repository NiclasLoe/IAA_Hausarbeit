<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h2><s:text name="student.header"/></h2></div>
        <div class="panel-body">
            <s:form theme="bootstrap">
                <div class="form-group">
                    <s:submit key="button.newStudent" action="addStudent" cssClass="btn"/>
                    <s:submit key="button.filterList" action="filterStudent" cssClass="btn"/>
                    <s:submit key="button.clearFilter" action="showStudentList" cssClass="btn"/>
                </div>
                <table class="table datatable-design" id="studentTable">
                    <thead>
                        <tr>
                            <th class="no-sort"></th>
                            <th><s:text name="tableView.StudentId"/></th>
                            <th><s:text name="tableView.lastName"/></th>
                            <th><s:text name="tableView.firstName"/></th>
                            <th><s:text name="tableView.centuryName"/></th>
                            <th><s:text name="tableView.emailAddress"/></th>
                            <th><s:text name="tableView.status"/></th>
                        </tr>
                    </thead>
                    <s:iterator value="studentList">
                        <tr class="notFirst">
                            <td><s:radio name="studentId" list="#{id:''}" theme="simple"
                                         onclick="return enableControls(this, [ '#buttonSeeMore', '#buttonExmatriculateStudent', '#buttonEndActiveStudies' ]);"/></td>
                            <td class="tdApplicantView"><s:property value="studentId"/></td>
                            <td class="tdApplicantView"><s:property value="lastName"/></td>
                            <td class="tdApplicantView"><s:property value="firstName"/></td>
                            <td class="tdApplicantView"><s:property value="%{century.centuryName}"/></td>
                            <td class="tdApplicantView"><s:property value="emailAddress"/></td>
                            <td class="tdApplicantView"><s:property value="status"/></td>
                        </tr>
                    </s:iterator>
                </table>
                <s:actionerror/>

                <div class="form-group">
                    <s:submit id="buttonSeeMore" key="button.seeMore" disabled="true" action="loadStudent" cssClass="btn"/>
                    <s:hidden id="buttonYes" name="buttonYes" value="%{getText('button.yes')}"/>
                    <s:hidden id="buttonNo" name="buttonNo" value="%{getText('button.no')}"/>
                    <s:hidden id="modalTitle" name="modalTitle" value="%{getText('confirm.generic')}"/>
                    <s:submit id="buttonExmatriculateStudent" key="button.exmatriculateStudent" disabled="true" onclick="return confirmAction(this, 'exmatriculateStudent');" cssClass="btn"/>
                    <s:submit id="buttonEndActiveStudies" key="button.endActiveStudies" disabled="true" onclick="return confirmAction(this, 'endActiveStudies', '#dialog-confirm2');" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showMainPage" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>
<div id="dialog-confirm" class="hiddenModal">
    <s:text name="confirm.exmatriculateStudent"></s:text>
</div>
<div id="dialog-confirm2" class="hiddenModal">
    <s:text name="confirm.endActiveStudies"></s:text>
</div>