<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:hidden name="applicant.id"/>
    <s:textfield key="applicant.firstName"/>
    <s:textfield key="applicant.lastName"/>
    <s:textfield key="applicant.gender"/>
    <s:textfield key="applicant.birthday"/>

    <s:submit key="button.save" action="saveRoom"/>
    <s:submit key="button.cancel" action="cancelApplicant"/>
</s:form>