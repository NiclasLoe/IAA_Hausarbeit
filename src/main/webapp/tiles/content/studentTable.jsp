<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <table class="table table-hover">
                    <tr>
                        <th></th>
                        <th><s:text name="tableView.StudentId"/></th>
                        <th><s:text name="tableView.lastName"/></th>
                        <th><s:text name="tableView.firstName"/></th>
                        <th><s:text name="tableView.centuryName"/></th>
                        <th><s:text name="tableView.emailAddress"/></th>
                        <th><s:text name="tableView.status"/></th>
                    </tr>
                    <s:iterator value="studentList">
                        <tr>
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
                    <s:submit key="button.seeMore" action="loadStudent" cssClass="btn"/>
                    <s:submit key="button.exmatriculateStudent" action="exmatriculateStudent" cssClass="btn"/>
                    <s:submit key="button.endActiveStudies" action="endActiveStudies" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showMainPage" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>