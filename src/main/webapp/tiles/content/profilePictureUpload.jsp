<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="uploadProfilePicture" namespace="/"
        method="POST" enctype="multipart/form-data">
    <s:hidden name="student.id"/>
    <s:file name="fileUpload" label="Select a File to upload" size="40"/>

    <s:submit value="submit" name="button.uploadProfilePic"/>


</s:form>
<s:submit key="button.cancel" action="cancelStudent" cssClass="submitButton"/>

