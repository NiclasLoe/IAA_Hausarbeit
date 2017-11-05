<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="applicantForm.header">
        <s:hidden name="applicant.id"/>
        <s:set var="documentName" value="%{applicant.document.fileName + applicant.document.suffix}"/>

        <s:if test="applicant.document != null">
            <s:hidden name="applicant.document.id"/>
        </s:if>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="applicant.personalInformation"/></div>
            <div class="panel-body">
                <s:select key="applicant.title" list="@de.nordakademie.iaa.studentadmin.utilities.Title@values()"/>
                <s:textfield key="applicant.firstName"/>
                <s:textfield key="applicant.lastName"/>
                <s:select key="applicant.gender" list="@de.nordakademie.iaa.studentadmin.utilities.Gender@values()"/>
                <s:date name="applicant.dateOfBirth" var="dateOfBirthId" format="yyyy-MM-dd"/>
                <s:textfield key="applicant.dateOfBirth" type="date"
                             value="%{dateOfBirthId}"/>
                <s:textfield key="applicant.birthplace"/>
            </div>
        </div>


        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="applicant.contactInformation"/></div>
            <div class="panel-body">
                <s:textfield key="applicant.phoneNumber"/>
                <s:textfield key="applicant.emailAddress"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="applicant.interestedIn"/></div>
            <div class="panel-body">
                <s:select key="applicant.fieldOfStudy"
                          list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="applicant.addressInformation"/></div>
            <div class="panel-body">
                <s:textfield key="applicant.streetName"/>
                <s:textfield key="applicant.houseNumber"/>
                <s:textfield key="applicant.postalCode"/>
                <s:textfield key="applicant.city"/>
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
        <s:if test="applicant.id != null">
            <s:submit key="button.addDocument" action="uploadApplicantDocument" cssClass="btn"/>
        </s:if>
        <s:if test="applicant.document != null">
            <s:submit key="button.downloadDocument" action="downloadApplicantDocument" cssClass="btn"/>
            <s:submit key="button.deleteDocument" action="deleteApplicantDocument" cssClass="btn"/>
        </s:if>

        <s:submit key="button.save" action="saveApplicant" cssClass="btn"/>
        <s:submit key="button.back" action="cancelApplicant" cssClass="btn"/>
    </s:form>
</div>