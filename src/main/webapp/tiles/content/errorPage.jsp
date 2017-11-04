<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<s:form>
    <s:text name="error.uploadErrorOccurred"/>
    <s:submit action="showStudentList" key="button.goBack" cssClass="submitButton"/>
</s:form>
