<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:hidden name="student.id"/>
    <s:hidden name="applicant.id"/>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.personalInformation"/>
            </td>
        </tr>
        <s:select key="student.title" value="%{applicant.title}"
                  list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()" cssClass="textInput"/>
        <s:textfield key="student.firstName" value="%{applicant.firstName}" cssClass="textInput"/>
        <s:textfield key="student.lastName" value="%{applicant.lastName}" cssClass="textInput"/>
        <s:select key="student.gender" value="%{applicant.gender}"
                  list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()"/>
        <s:date name="applicant.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
        <s:textfield key="student.dateOfBirth" type="date"
                     cssClass="textInput"
                     value="%{dateOfBirthId}"/>
        <s:textfield key="student.birthplace" value="%{applicant.birthplace}" cssClass="textInput"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.contactInformation"/>
            </td>
        </tr>
        <s:textfield key="student.phoneNumber" value="%{applicant.phoneNumber}" cssClass="textInput"/>
        <s:textfield key="student.emailAddress" value="%{applicant.emailAddress}" cssClass="textInput"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.addressInformation"/>
            </td>
        </tr>
        <s:textfield key="student.streetName" value="%{applicant.streetName}" cssClass="textInput"/>
        <s:textfield key="student.houseNumber" value="%{applicant.houseNumber}" cssClass="textInput"/>
        <s:textfield key="student.postalCode" value="%{applicant.postalCode}" cssClass="textInput"/>
        <s:textfield key="student.city" value="%{applicant.city}" cssClass="textInput"/>
        <tr/>

        <tr class="trSubHeader">
            <td>
                <s:text name="student.NAKInformation"/>
            </td>

        </tr>

        <s:select name="companyId" list="%{companyList}" listKey="id" listValue="shortName"
                  cssClass="textInput" label="student.company_id" headerValue="student.pleaseSelect" headerKey=""/>
        <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                  listValue="centuryName"
                  cssClass="textInput" label="student.centuryId" headerValue="student.pleaseSelect" headerKey=""/>
        <tr/>

    </table>
    <s:submit key="button.save" action="saveApplicantToStudent" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelApplicant" cssClass="submitButton"/>
</s:form>

