<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:hidden name="student.id"/>
    <s:hidden name="student.studentId"/>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.personalInformation"/>
            </td>
        </tr>
        <s:select key="student.title" list="@de.nordakademie.iaa.studentadmin.model.Title@values()"
                  cssClass="textInput"/>
        <s:textfield key="student.firstName" cssClass="textInput"/>
        <s:textfield key="student.lastName" cssClass="textInput"/>
        <s:select key="student.gender" list="@de.nordakademie.iaa.studentadmin.model.Gender@values()"/>
        <s:date name="applicant.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
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
        <s:select key="student.company_id" list="%{companyList}" listValue="companyName1" cssClass="textInput"/>
        <s:select key="student.class_id" list="%{groupList}" listValue="className" cssClass="textInput"/>
        <tr/>
    </table>
    <s:submit key="button.addStudent" action="saveNewStudent" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelStudent" cssClass="submitButton"/>
</s:form>
