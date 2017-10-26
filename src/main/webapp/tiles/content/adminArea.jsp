<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <s:text name="mainPage.applicantCount"/>


    <s:submit key="button.showCentury" action="showCenturyList" cssClass="submitButton"/>
    <s:submit key="button.showCompanyList" action="showCompanyList" cssClass="submitButton"/>
    <s:submit key="button.downloadResultList" action="chooseManiplePage" cssClass="submitButton"/>



    <s:submit key="button.goBack" action="showMainPage" cssClass="submitButton"/>
</s:form>