<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:form>
    <s:submit cssClass="submitButton" key="applicant.newApplicant" action="addNewApplicant"/>
    <table>
        <tr>
            <td>
                <s:text name="Bewerberübersicht"/>
            </td>
            <td>
                <s:text name="Bewerber"/>
            </td>
        </tr>
    </table>
    <br>
    <s:submit key="button.goBack" action="showMainPage"/>
    <s:submit key="button.downloadList" action="downloadCurrentList"/>
</s:form>