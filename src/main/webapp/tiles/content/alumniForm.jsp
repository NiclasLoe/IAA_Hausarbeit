<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:hidden name="student.id"/>
    <s:hidden name="student.studentId"/>
    <s:hidden name="student.status"/>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.personalInformation"/>
            </td>
        </tr>
        <s:select key="student.title" list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()"
                  cssClass="textInput" disabled="true"/>
        <s:textfield key="student.firstName" cssClass="textInput" disabled="true"/>
        <s:textfield key="student.lastName" cssClass="textInput" disabled="true"/>
        <s:select key="student.gender" list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()" disabled="true"/>
        <s:date name="student.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
        <s:textfield key="student.dateOfBirth" type="date"
                     cssClass="textInput"
                     value="%{dateOfBirthId}" disabled="true"/>
        <s:textfield key="student.birthplace" cssClass="textInput" disabled="true"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.contactInformation"/>
            </td>
        </tr>
        <s:textfield key="student.phoneNumber" cssClass="textInput" disabled="true"/>
        <s:textfield key="student.emailAddress" cssClass="textInput" disabled="true"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.addressInformation"/>
            </td>
        </tr>
        <s:textfield key="student.streetName" cssClass="textInput" disabled="true"/>
        <s:textfield key="student.houseNumber" cssClass="textInput" disabled="true"/>
        <s:textfield key="student.postalCode" cssClass="textInput" disabled="true"/>
        <s:textfield key="student.city" cssClass="textInput" disabled="true"/>
        <tr/>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.NAKInformation"/>
            </td>
        </tr>
        <s:select name="companyId" list="%{companyList}" listKey="id" listValue="shortName"
                       cssClass="textInput" value="student.company.id" label="student.company_id" disabled="true"/>
        <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                  listValue="centuryName" value="%{student.century.year + student.century.letterCode + student.century.fieldOfStudy}"
                  cssClass="textInput" label="student.centuryId" disabled="true"/>

        <s:textfield key="studentForm.userMailAddress" value="%{student.userEmail}" cssClass="textInput" disabled="true"/>
        <s:textfield key="studentForm.userName" value="%{student.username}" cssClass="textInput" disabled="true"/>
        <s:textfield key="studentForm.studentId" value="%{student.studentId}" cssClass="textInput" disabled="true"/>
        <tr/>
    </table>
    <s:submit key="button.back" action="cancelAlumni" cssClass="submitButton"/>
</s:form>
