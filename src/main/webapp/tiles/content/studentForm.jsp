<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>

<s:form>
    <s:hidden name="applicant.id"/>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="applicant.personalInformation"/>
            </td>
        </tr>
        <s:select key="applicant.title" list="@de.nordakademie.iaa.studentadmin.model.Title@values()"
                  cssClass="textInput"/>
        <s:textfield key="applicant.firstName" cssClass="textInput"/>
        <s:textfield key="applicant.lastName" cssClass="textInput"/>
        <s:select key="applicant.gender" list="@de.nordakademie.iaa.studentadmin.model.Gender@values()"/>
        <s:date name="applicant.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
        <s:textfield key="applicant.dateOfBirth" type="date"
                     cssClass="textInput"
                     value="%{dateOfBirthId}"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="applicant.contactInformation"/>
            </td>
        </tr>
        <s:textfield key="applicant.phoneNumber" cssClass="textInput"/>
        <s:textfield key="applicant.emailAddress" cssClass="textInput"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="applicant.interestedIn"/>
            </td>
        </tr>
        <s:select key="applicant.fieldOfStudy" list="@de.nordakademie.iaa.studentadmin.model.FieldOfStudy@values()"/>
        <tr class="trSubHeader">
            <td>
                <s:text name="applicant.addressInformation"/>
            </td>
        </tr>
        <s:textfield key="applicant.streetName" cssClass="textInput"/>
        <s:textfield key="applicant.houseNumber" cssClass="textInput"/>
        <s:textfield key="applicant.postalCode" cssClass="textInput"/>
        <s:textfield key="applicant.city" cssClass="textInput"/>
        <tr/>
    </table>
    <s:submit key="button.save" action="saveRoom" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelApplicant" cssClass="submitButton"/>
</s:form>