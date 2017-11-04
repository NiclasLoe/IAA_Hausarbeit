<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="userDocument" method="POST" enctype="multipart/form-data">
    <s:hidden name="student.id"/>
    <s:hidden name="studentId" value="%{student.id}"/>
    <s:textfield name="selectedFileName" label="%{getText('documentUpload.fileName')}" cssClass="textInput"/>
    <s:file name="file" label="%{getText('profilePicture.selectFile')}" size="40"/>

    <s:actionerror/>
    <s:submit name="submit" key="button.uploadStudentDocument" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="loadStudent" cssClass="submitButton"/>
</s:form>

