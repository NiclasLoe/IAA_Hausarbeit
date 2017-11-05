<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form theme="bootstrap" cssClass="form-horizontal" key="filter.header">
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.personalInformation"/></div>
            <div class="panel-body">

                <s:textfield name="selectedFirstName" key="filter.selectedFirstName"/>
                <s:textfield name="selectedLastName" key="filter.selectedFirstName"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="student.NAKInformation"/></div>
            <div class="panel-body">
                <s:select name="selectedFieldOfStudy" key="filter.selectedFieldOfStudy"
                          list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>
                <s:textfield name="selectedYear" key="filter.selectedYear"/>

                <s:select name="selectedCompanyId" list="%{companyList}" listKey="id" listValue="shortName"
                          key="filter.selectedCompany"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>

                <s:select name="selectedCenturyString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                          listValue="centuryName" key="student.centuryId"
                          headerValue="%{getText('student.pleaseSelect')}" headerKey=""/>

                <s:textfield name="selectedStudentId" key="filter.studentId"/>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="filter.applyFilterOnList"/></div>
            <div class="panel-body">
                <div class="form-group">
                    <s:submit key="button.applyFilter" action="applyFilterStudent" cssClass="btn"/>
                    <s:submit key="button.cancel" action="cancelStudentFilter" cssClass="btn"/>
                </div>
            </div>
        </div>
    </s:form>
</div>
