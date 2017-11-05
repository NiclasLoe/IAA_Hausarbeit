<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading"><h2><s:text name="manipleList.header"/></h2></div>
            <div class="panel-body">
                <s:select name="maniple" label="%{getText('tableView.maniple')}" list="%{manipleList}"/>
                <div class="form-group">
                    <s:submit key="button.downloadResultList" action="downloadResultList" cssClass="btn"/>
                    <s:submit key="button.cancel" action="showAdminArea" cssClass="btn"/>
                </div>
            </div>
        </div>
    </s:form>
</div>