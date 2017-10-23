<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>

    <table>
        <tr>
            <th></th>
            <th><s:text name="tableView.StudentId"/></th>
            <th><s:text name="tableView.lastName"/></th>
            <th><s:text name="tableView.firstName"/></th>
            <th><s:text name="tableView.fieldOfStudy"/></th>
            <th><s:text name="tableView.emailAddress"/></th>
        </tr>
        <s:iterator value="alumniList">
            <tr>
                <td><s:radio name="personId" list="#{id:''}" theme="simple" onselect=""/></td>
                <td class="tdApplicantView"><s:property value="studentId"/></td>
                <td class="tdApplicantView"><s:property value="lastName"/></td>
                <td class="tdApplicantView"><s:property value="firstName"/></td>
                <td class="tdApplicantView"><s:property value="group"/></td>
                <td class="tdApplicantView"><s:property value="emailAddress"/></td>
            </tr>
        </s:iterator>
        <tr></tr>
    </table>
    <s:actionerror/>
    <s:submit key="button.seeMore" action="loadAlumni" cssClass="submitButton"/>
    <s:submit key="button.goBack" action="showMainPage" cssClass="submitButton"/>
    <s:submit key="button.downloadList" action="downloadCurrentList" cssClass="submitButton"/>
</s:form>