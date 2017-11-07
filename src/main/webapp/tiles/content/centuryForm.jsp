<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="century.header">
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="century.addNewCentury"/></div>
            <div class="panel-body">
                <s:select key="century.fieldOfStudy"
                          list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
                <s:textfield key="century.letterCode"/>
                <s:textfield key="century.year"/>
            </div>
        </div>
        <s:submit key="button.saveCentury" action="saveCentury" cssClass="btn"/>
        <s:submit key="button.goBack" action="cancelCentury" cssClass="btn"/>
    </s:form>
</div>