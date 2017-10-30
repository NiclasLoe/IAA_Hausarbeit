<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:submit key="button.addCentury" action="addCentury" cssClass="submitButton"/>
    <table>
        <tr>
            <td></td>
            <th><s:text name="tableView.fieldOfStudy"/></th>
            <th><s:text name="tableView.year"/></th>
            <th><s:text name="tableView.letterCode"/></th>
            <th><s:text name="tableView.centuryName"/></th>
        </tr>
        <s:iterator value="centuryList">
            <tr>

                <td><s:radio name="centuryString" list="#{year+letterCode+fieldOfStudy:''}" theme="simple" onselect=""/></td>
                <td class="tdApplicantView"><s:property value="fieldOfStudy"/></td>
                <td class="tdApplicantView"><s:property value="year"/></td>
                <td class="tdApplicantView"><s:property value="letterCode"/></td>
                <td class="tdApplicantView"><s:property value="centuryName"/></td>
            </tr>
        </s:iterator>
        <tr></tr>
    </table>
    <s:actionerror/>
    <s:submit key="button.downloadAttendanceList" action="downloadAttendanceList" cssClass="submitButton"/>
    <s:submit key="button.goBack" action="showAdminArea" cssClass="submitButton"/>

</s:form>