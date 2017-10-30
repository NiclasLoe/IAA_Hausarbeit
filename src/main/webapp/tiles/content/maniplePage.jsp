<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:select name="maniple" label="tableView.maniple" list="%{manipleList}"/>

    <s:submit key="button.downloadResultList" action="downloadResultList" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="showAdminArea" cssClass="submitButton"/>
</s:form>

