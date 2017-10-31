<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:submit key="button.newStudent" action="addStudent" cssClass="submitButton" />
    <s:submit key="button.filterList" action="filterStudent" cssClass="submitButton" />
    <s:submit key="button.clearFilter" action="showStudentList" cssClass="submitButton" />

    <table>
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
    <s:submit key="button.seeMore" action="loadStudent" cssClass="submitButton"/>
    <s:submit key="button.goBack" action="showMainPage" cssClass="submitButton"/>
    <s:submit key="button.exmatriculateStudent" action="exmatriculateStudent" cssClass="submitButton"/>
    <s:submit key="button.endActiveStudies" action="endActiveStudies" cssClass="submitButton"/>
</s:form>