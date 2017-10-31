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
        <s:select name="selectedFieldOfStudy" label="filter.selectedFieldOfStudy"
                  list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"
                  headerValue="student.pleaseSelect" headerKey=""/>

        <tr/>
    </table>

    <s:submit key="button.applyFilter" action="applyFilterApplicant" cssClass="submitButton"/>
    <s:submit key="button.cancel" action="cancelApplicantFilter" cssClass="submitButton"/>
</s:form>
