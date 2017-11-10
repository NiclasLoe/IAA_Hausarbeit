<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="filter.header">
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.personalInformation"/></div>
            <div class="panel-body">
                <s:textfield name="selectedFirstName" key="filter.selectedFirstName"/>
                <s:textfield name="selectedLastName" key="filter.selectedLastName"/>
                <s:select name="selectedFieldOfStudy" key="filter.selectedFieldOfStudy"
                          list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="filter.applyFilterOnList"/></div>
            <div class="panel-body">
                    <s:submit key="button.applyFilter" action="applyFilterApplicant" cssClass="btn"/>
                    <s:submit key="button.cancel" action="cancelApplicantFilter" cssClass="btn"/>
            </div>
        </div>
    </s:form>
</div>
