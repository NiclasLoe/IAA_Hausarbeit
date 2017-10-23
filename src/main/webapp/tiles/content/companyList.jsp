<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <table>
        <tr>
            <th><s:text name="tableView.companyName1"/></th>
            <th><s:text name="tableView.companyName2"/></th>
            <th><s:text name="tableView.shortName"/></th>
            <th><s:text name="tableView.nameOfContactPerson"/></th>
        </tr>
        <s:iterator value="companyList">
            <tr>
                <td class="tdApplicantView"><s:property value="companyName1"/></td>
                <td class="tdApplicantView"><s:property value="companyName2"/></td>
                <td class="tdApplicantView"><s:property value="shortName"/></td>
                <td class="tdApplicantView"><s:property value="nameOfContactPerson"/></td>
            </tr>
        </s:iterator>
        <tr></tr>
    </table>
</s:form>