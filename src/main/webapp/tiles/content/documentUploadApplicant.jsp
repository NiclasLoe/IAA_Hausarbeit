<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h3><s:text name="documentUpload.header"/></h3></div>
        <div class="panel-body">
            <s:form action="userDocumentApplicant" method="POST" enctype="multipart/form-data"
                    theme="bootstrap" cssClass="form-horizontal">
                <s:hidden name="applicant.id"/>
                <s:hidden name="applicantId" value="%{applicant.id}"/>
                <s:textfield name="selectedFileName" label="%{getText('documentUpload.fileName')}"/>
                <s:file name="file" label="%{getText('profilePicture.selectFile')}"/>

                <s:actionerror/>
                <div class="form-group">
                    <s:submit name="submit" key="button.uploadDocument" cssClass="btn"/>
                    <s:submit key="button.cancel" action="loadApplicant" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>
