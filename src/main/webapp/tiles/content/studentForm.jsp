<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="student.header">
        <s:hidden name="student.id"/>
        <s:hidden name="student.status"/>
        <s:hidden name="student.studentId"/>
        <s:hidden name="student.userEmail"/>
        <s:hidden name="student.username"/>
        <s:set var="profilePic" value="%{student.profilePicture.imageString}"/>
        <s:set var="documentName" value="%{student.document.fileName}"/>
        <s:if test="student.profilePicture != null">
            <s:hidden name="student.profilePicture.id"/>
        </s:if>
        <s:if test="student.document != null">
            <s:hidden name="student.document.id"/>
        </s:if>
        <s:set var="centuryString"
               value="%{student.century.year + student.century.letterCode + student.century.fieldOfStudy}"/>
        <s:hidden name="student.company.id"/>
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
                </div>
            </div>
        </div>
        </div>
        <div class="panel panel-default">
        <div class="panel-heading"><s:text name="student.contactInformation"/></div>
            <div class="panel-body">
                <s:textfield key="student.phoneNumber" cssClass="textInput"/>
                <s:textfield key="student.emailAddress" cssClass="textInput"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.addressInformation"/></div>
            <div class="panel-body">
                <s:textfield key="student.streetName" cssClass="textInput"/>
                <s:textfield key="student.houseNumber" cssClass="textInput"/>
                <s:textfield key="student.postalCode" cssClass="textInput"/>
                <s:textfield key="student.city" cssClass="textInput"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.NAKInformation"/></div>
            <div class="panel-body">
                <s:select name="companyId" list="%{companyList}" listKey="id" listValue="shortName"
                          cssClass="textInput" value="student.company.id" label="student.company_id"
                          headerValue="student.pleaseSelect" headerKey=""/>
                <s:select name="centuryString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                          listValue="centuryName"
                          value="%{centuryString}"
                          cssClass="textInput" label="student.centuryId" headerValue="student.pleaseSelect" headerKey=""/>

                <s:textfield key="studentForm.userMailAddress" value="%{student.userEmail}"
                             cssClass="textInput" disabled="true"/>
                <s:textfield key="studentForm.userName" value="%{student.username}"
                             cssClass="textInput" disabled="true"/>
                <s:textfield key="studentForm.studentId" value="%{student.studentId}"
                             cssClass="textInput" disabled="true"/>
            </div>
        </div>
        <s:submit key="button.addPicture" action="uploadPicture" cssClass="btn"/>
        <s:if test="student.profilePicture != null">
            <s:submit key="button.deleteProfilePic" action="deletePicture" cssClass="btn"/>
        </s:if>
        <s:submit key="button.addDocument" action="uploadStudentDocument" cssClass="btn"/>
        <s:if test="student.document != null">
            <s:text name="person.attachedDocument" />
            <s:text name="%{documentName}" />
            <s:submit key="button.downloadDocument"  action="downloadStudentDocument" cssClass="btn"/>
            <s:submit key="button.deleteDocument" action="deleteStudentDocument" cssClass="btn"/>
        </s:if>
        <s:submit key="button.saveStudent" action="saveStudent" cssClass="btn"/>
        <s:submit key="button.back" action="cancelStudent" cssClass="btn"/>
    </s:form>
</div>
