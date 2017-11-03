<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:submit key="button.addCompany" action="addCompany" cssClass="submitButton"/>
    <table>
        <tr>
            <td></td>
            <th><s:text name="company.companyName1"/></th>
            <th><s:text name="company.companyName2"/></th>
            <th><s:text name="company.shortName"/></th>
            <th><s:text name="company.contactPerson"/></th>
        </tr>
        <s:iterator value="companyList">
            <tr>

                <td><s:radio name="companyId" list="#{id:''}" theme="simple" onselect=""/></td>
                <td class="tdApplicantView"><s:property value="companyName1"/></td>
                <td class="tdApplicantView"><s:property value="companyName2"/></td>
                <td class="tdApplicantView"><s:property value="shortName"/></td>
                <td class="tdApplicantView"><s:property value="contactPerson"/></td>
            </tr>
        </s:iterator>
        <tr></tr>
    </table>
    <s:actionerror/>
    <s:submit key="button.seeMore" action="loadCompany" cssClass="submitButton"/>
    <s:submit key="button.downloadCompanyList" action="downloadCompanyList" cssClass="submitButton"/>
    <s:submit key="button.goBack" action="showAdminArea" cssClass="submitButton"/>

</s:form>