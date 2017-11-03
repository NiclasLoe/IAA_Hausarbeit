<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:hidden name="student.id"/>
    <s:hidden name="student.status"/>
    <s:hidden name="student.studentId"/>
    <s:hidden name="student.userEmail"/>
    <s:hidden name="student.username"/>
    <s:submit key="button.addPicture" action="uploadPicture" cssClass="submitButton"/>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.personalInformation"/>
            </td>
        </tr>
        <s:select key="student.title" list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()"
                  cssClass="textInput"/>
        <s:textfield key="student.firstName" cssClass="textInput"/>
        <s:textfield key="student.lastName" cssClass="textInput"/>
        <s:select key="student.gender" list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()"/>
        <s:date name="student.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
        <s:textfield key="student.dateOfBirth" type="date"
                     cssClass="textInput"
                     value="%{dateOfBirthId}"/>
        <s:textfield key="student.birthplace" cssClass="textInput"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.contactInformation"/>
            </td>
        </tr>
        <s:textfield key="student.phoneNumber" cssClass="textInput"/>
        <s:textfield key="student.emailAddress" cssClass="textInput"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.addressInformation"/>
            </td>
        </tr>
        <s:textfield key="student.streetName" cssClass="textInput"/>
        <s:textfield key="student.houseNumber" cssClass="textInput"/>
        <s:textfield key="student.postalCode" cssClass="textInput"/>
        <s:textfield key="student.city" cssClass="textInput"/>
        <tr/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.NAKInformation"/>
            </td>
        </tr>
        <s:select name="companyId" list="%{companyList}" listKey="id" listValue="shortName"
                  cssClass="textInput" value="student.company.id" label="student.company_id" headerValue="student.pleaseSelect" headerKey=""/>
        <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                  listValue="centuryName" value="%{student.century.year + student.century.letterCode + student.century.fieldOfStudy}"
                  cssClass="textInput" label="student.centuryId" headerValue="student.pleaseSelect" headerKey=""/>

        <s:textfield key="studentForm.userMailAddress" value="%{student.userEmail}" cssClass="textInput" disabled="true"/>
        <s:textfield key="studentForm.userName" value="%{student.username}" cssClass="textInput" disabled="true"/>
        <s:textfield key="studentForm.studentId" value="%{student.studentId}" cssClass="textInput" disabled="true"/>
        <tr/>
    </table>
    <s:submit key="button.saveStudent" action="saveStudent" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelStudent" cssClass="submitButton"/>
</s:form>
