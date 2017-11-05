<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap">
        <div class="panel panel-default">
            <div class="panel-heading"><h2><s:text name="adminArea.header"/></h2></div>
            <div class="panel-body">
                <p>
                    <s:text name="adminArea.pageText"/>
                </p>
                <div class="form-group">
                    <s:submit key="button.showCentury" action="showCenturyList" cssClass="btn"/>
                    <s:submit key="button.showCompanyList" action="showCompanyList" cssClass="btn"/>
                    <s:submit key="button.downloadResultList" action="chooseManiplePage" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showMainPage" cssClass="btn"/>
                </div>
            </div>
        </div>
    </s:form>
</div>