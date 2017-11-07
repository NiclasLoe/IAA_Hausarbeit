<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="newStudent.header">
        <s:hidden name="student.id"/>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.personalInformation"/></div>
            <div class="panel-body">
                <s:select key="student.title" list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()"
                          cssClass="textInput" headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
                <s:textfield key="student.firstName" cssClass="textInput"/>
                <s:textfield key="student.lastName" cssClass="textInput"/>
                <s:select key="student.gender"
                          list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
                <s:textfield key="student.dateOfBirth" type="date"
                             cssClass="textInput"
                             value="%{dateOfBirthId}"/>
                <s:textfield key="student.birthplace" cssClass="textInput"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.contactInformation"/></div>
            <div class="panel-body">
                <s:textfield key="student.phoneNumber"/>
                <s:textfield key="student.emailAddress"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.addressInformation"/></div>
            <div class="panel-body">
                <s:textfield key="student.streetName"/>
                <s:textfield key="student.houseNumber"/>
                <s:textfield key="student.postalCode"/>
                <s:textfield key="student.city"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.NAKInformation"/></div>
            <div class="panel-body">
                <s:select key="student.company_id" list="%{companyList}" listValue="companyName1"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
                <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                          listValue="centuryName"
                          key="student.centuryId" headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
            </div>
        </div>
        <s:submit key="button.addStudent" action="saveNewStudent" cssClass="btn"/>
        <s:submit key="button.cancel" action="cancelStudent" cssClass="btn"/>
    </s:form>
</div>


