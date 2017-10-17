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
    <table style="width:100%" cellspacing="0" cellpadding="0" border="0">
        <tr style="white-space:nowrap;">
            <td style="width: 200px; " align="left">
                <s:submit key="general.goBack" action="showMainPage"/>
            </td>
            <td style="width: 200px;" align="right">
                <s:submit key="general.downloadList" action="downloadCurrentList"/>
            </td>
        </tr>
    </table>
</s:form>




