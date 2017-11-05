<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="student.header">
    <s:set var="profilePic" value="%{student.profilePicture.imageString}"/>
    <s:set var="documentName" value="%{student.document.fileName + student.document.suffix}"/>
    <s:set var="centuryString"
           value="%{student.century.year + student.century.letterCode + student.century.fieldOfStudy}"/>
    <div class="panel panel-default">
        <div class="panel-heading"><s:text name="student.personalInformation"/></div>
        <div class="panel-body">
            <div class="row">
                <s:if test="student.profilePicture != null">
                <div class="col-sm-2">
                    <img class="img-thumbnail" width="150" height="150" src="<s:property value="%{profilePic}" />">
                </div>
                <div class="col-sm-10">
                    </s:if>
                    <s:else>
                    <div class="col-sm-12">
                        </s:else>
                        <s:select key="student.title"
                                  list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()" disabled="true"/>
                        <s:textfield key="student.firstName" disabled="true"/>
                        <s:textfield key="student.lastName" disabled="true"/>
                        <s:select key="student.gender"
                                  list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()" disabled="true"/>
                        <s:date name="student.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
                        <s:textfield key="student.dateOfBirth" type="date"
                                     value="%{dateOfBirthId}" disabled="true"/>
                        <s:textfield key="student.birthplace" disabled="true"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.contactInformation"/></div>
            <div class="panel-body">
                <s:textfield key="student.phoneNumber" disabled="true"/>
                <s:textfield key="student.emailAddress" disabled="true"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.addressInformation"/></div>
            <div class="panel-body">
                <s:textfield key="student.streetName" disabled="true"/>
                <s:textfield key="student.houseNumber" disabled="true"/>
                <s:textfield key="student.postalCode" disabled="true"/>
                <s:textfield key="student.city" disabled="true"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.NAKInformation"/></div>
            <div class="panel-body">
                <s:select name="companyId" list="%{companyList}" listKey="id" listValue="shortName"
                          value="student.company.id" key="student.company_id"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey="" disabled="true"/>
                <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                          listValue="centuryName" value="%{centuryString}"
                          key="student.centuryId" headerValue="%{getText('student.pleaseSelect')}"
                          headerKey="" disabled="true"/>

                <s:textfield key="studentForm.userMailAddress" value="%{student.userEmail}"
                             disabled="true"/>
                <s:textfield key="studentForm.userName" value="%{student.username}"
                             disabled="true"/>
                <s:textfield key="studentForm.studentId" value="%{student.studentId}"
                             disabled="true"/>
            </div>
        </div>
        <s:if test="student.document != null">
            <div class="panel panel-default">
                <div class="panel-heading"><s:text name="person.attachedDocument"/></div>
                <div class="panel-body">
                    <div>
                        <s:textfield key="person.fileName" value="%{documentName}" disabled="true"
                                     cssStyle="border: none; box-shadow: none; cursor: default; background: none;"/>
                    </div>
                </div>
            </div>
        </s:if>
        <s:if test="student.document != null">
            <s:submit key="button.downloadDocument" action="downloadStudentDocument" cssClass="btn"/>
        </s:if>
        <s:submit key="button.back" action="cancelAlumni" cssClass="btn"/>
        </s:form>
    </div>
</div>