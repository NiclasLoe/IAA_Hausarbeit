<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:hidden name="company.id"/>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="company.nameSection"/>
            </td>
        </tr>

        <s:textfield key="company.companyName1" cssClass="textInput"/>
        <s:textfield key="company.companyName2" cssClass="textInput"/>
        <s:textfield key="company.shortName" cssClass="textInput"/>
        <s:textfield key="company.contactPerson" cssClass="textInput"/>

        <tr class="trSubHeader">
            <td>
                <s:text name="company.contactInformation"/>
            </td>
        </tr>
        <s:textfield key="company.phoneNumber" cssClass="textInput"/>
        <s:textfield key="company.faxNumber" cssClass="textInput"/>
        <s:textfield key="company.mailAddress" cssClass="textInput"/>

        <tr class="trSubHeader">
            <td>
                <s:text name="company.addressInformation"/>
            </td>
        </tr>
        <s:textfield key="company.streetName" cssClass="textInput"/>
        <s:textfield key="company.houseNumber" cssClass="textInput"/>
        <s:textfield key="company.postalCode" cssClass="textInput"/>
        <s:textfield key="company.city" cssClass="textInput"/>

    </table>
    <s:submit key="button.saveCompany" action="saveCompany" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelCompany" cssClass="submitButton"/>
</s:form>
