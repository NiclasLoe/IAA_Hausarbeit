<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="userImage" method="POST" enctype="multipart/form-data">
    <s:hidden name="student.id"/>
    <s:file name="userImage" label="%{getText('profilePicture.selectFile')}" size="40"/>

    <s:actionerror/>
    <s:submit name="submit" key="button.uploadProfilePic" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="showStudentList" cssClass="submitButton"/>
</s:form>

