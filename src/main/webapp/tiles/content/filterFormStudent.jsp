<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="student.personalInformation"/>
            </td>
        </tr>
        <s:textfield name="selectedFirstName" label="filter.selectedFirstName" cssClass="textInput"/>
        <s:textfield name="selectedLastName" label="filter.selectedFirstName" cssClass="textInput"/>

        <tr class="trSubHeader">
            <td>
                <s:text name="student.NAKInformation"/>
            </td>
        </tr>

        <s:select name="selectedFieldOfStudy" label="filter.selectedFieldOfStudy"
                  list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"
                  headerValue="student.pleaseSelect" headerKey=""/>
        <s:textfield name="selectedYear" label="filter.selectedYear" cssClass="textInput"/>

        <s:select name="selectedCompanyId" list="%{companyList}" listKey="id" listValue="shortName"
                  cssClass="textInput" label="filter.selectedCompany" headerValue="student.pleaseSelect" headerKey=""/>

        <s:select name="selectedCenturyString" list="%{centuryList}" listKey="year + letterCode + fieldOfStudy"
                  listValue="centuryName"
                  cssClass="textInput" label="student.centuryId" headerValue="student.pleaseSelect" headerKey=""/>

        <s:textfield name="selectedStudentId" label="filter.studentId" cssClass="textInput"/>
        <tr/>
    </table>

    <s:submit key="button.applyFilter" action="applyFilterStudent" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelStudentFilter" cssClass="submitButton"/>
</s:form>
