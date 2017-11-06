<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="newStudent.header">
        <s:hidden name="student.id"/>
        <s:hidden name="applicant.id"/>
        <div class="panel panel-default">
            <div class="panel-heading">
                <s:text name="student.personalInformation"/>
            </div>
            <div class="panel-body">
                <s:select key="student.title" value="%{applicant.title}"
                          list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()"/>
                <s:textfield key="student.firstName" value="%{applicant.firstName}"/>
                <s:textfield key="student.lastName" value="%{applicant.lastName}"/>
                <s:select key="student.gender" value="%{applicant.gender}"
                          list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()"/>
                <s:date name="applicant.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
                <s:textfield key="student.dateOfBirth" type="date"
                             value="%{dateOfBirthId}"/>
                <s:textfield key="student.birthplace" value="%{applicant.birthplace}"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <s:text name="student.contactInformation"/>
            </div>
            <div class="panel-body">
                <s:textfield key="student.phoneNumber" value="%{applicant.phoneNumber}"/>
                <s:textfield key="student.emailAddress" value="%{applicant.emailAddress}"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <s:text name="student.addressInformation"/>
            </div>
            <div class="panel-body">
                <s:textfield key="student.streetName" value="%{applicant.streetName}"/>
                <s:textfield key="student.houseNumber" value="%{applicant.houseNumber}"/>
                <s:textfield key="student.postalCode" value="%{applicant.postalCode}"/>
                <s:textfield key="student.city" value="%{applicant.city}"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <s:text name="student.NAKInformation"/>
            </div>
            <div class="panel-body">
                <s:select name="companyId" list="%{companyList}" listKey="id" listValue="shortName"
                          key="student.company_id" headerValue="%{getText('student.pleaseSelect')}"
                          headerKey=""/>
                <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                          listValue="centuryName" key="student.centuryId"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
            </div>
        </div>
        <s:submit key="button.save" action="saveApplicantToStudent" cssClass="btn"/>
        <s:submit key="button.cancel" action="cancelApplicant" cssClass="btn"/>
    </s:form>
</div>