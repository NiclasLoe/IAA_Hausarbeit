<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>

    <s:submit key="button.newApplicant" action="addApplicant" cssClass="submitButton"/>
    <table>
        <tr>
            <th></th>
            <th><s:text name="tableView.lastName"/></th>
            <th><s:text name="tableView.firstName"/></th>
            <th><s:text name="tableView.fieldOfStudy"/></th>
            <th><s:text name="tableView.emailAddress"/></th>
        </tr>
        <s:iterator value="personList">
            <tr>
                <td><s:radio name="applicantId" list="#{id:''}" theme="simple" onselect=""/></td>
                <td class="tdApplicantView"><s:property value="lastName"/></td>
                <td class="tdApplicantView"><s:property value="firstName"/></td>
                <td class="tdApplicantView"><s:property value="fieldOfStudy"/></td>
                <td class="tdApplicantView"><s:property value="emailAddress"/></td>
            </tr>
        </s:iterator>
        <tr></tr>
    </table>
    <s:actionerror/>
    <s:submit key="button.seeMore" action="loadApplicant" cssClass="submitButton"/>
    <s:submit key="button.goBack" action="showMainPage" cssClass="submitButton"/>
    <s:submit key="button.deleteApplicant" action="deleteApplicant" cssClass="submitButton"/>
    <s:submit key="button.enrollApplicant" action="enrollApplicant" cssClass="submitButton"/>
</s:form>