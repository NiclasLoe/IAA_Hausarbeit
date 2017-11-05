<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading"><h2><s:text name="error.errorOccurred"/></h2></div>
            <div class="panel-body">
                <s:text name="error.uploadErrorOccurred"/>
                <s:submit action="showStudentList" key="button.goBack" cssClass="submitButton"/>
            </div>
        </div>
    </s:form>
</div>