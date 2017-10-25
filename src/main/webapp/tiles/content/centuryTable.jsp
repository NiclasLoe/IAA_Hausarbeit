<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:submit name="button.addCentury" action="addCentury" cssClass="submitButton"/>
    <table>
        <tr>
            <th><s:text name="tableView.fieldOfStudy"/></th>
            <th><s:text name="tableView.year"/></th>
            <th><s:text name="tableView.letterCode"/></th>
            <th><s:text name="tableView.centuryName"/></th>
        </tr>
        <s:iterator value="centuryList">
            <tr>
                <td class="tdApplicantView"><s:property value="fieldOfStudy"/></td>
                <td class="tdApplicantView"><s:property value="year"/></td>
                <td class="tdApplicantView"><s:property value="letterCode"/></td>
                <td class="tdApplicantView"><s:property value="centuryName"/></td>
            </tr>
        </s:iterator>
        <tr></tr>
    </table>

</s:form>