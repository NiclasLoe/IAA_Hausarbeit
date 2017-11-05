<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h3><s:text name="pictureUpload.header"/></h3></div>
        <div class="panel-body">
            <s:form theme="bootstrap" cssClass="form-horizontal"
                    action="userImage" method="POST" enctype="multipart/form-data">
                <s:hidden name="student.id"/>
                <s:hidden name="studentId" value="%{student.id}"/>
                <s:file name="file" label="%{getText('profilePicture.selectFile')}"/>

                <s:actionerror/>

                <div class="form-group">
                    <s:submit name="submit" key="button.uploadProfilePic" cssClass="btn"/>
                    <s:submit key="button.cancel" action="loadStudent" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>

