<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <table>
        <tr>
            <td class="tdQuantity">
                <s:text name="mainPage.applicantCount"/>
            </td>
            <td>
                <s:property value="quantityList[0]"/>
            </td>
        </tr>
        <tr>
            <td class="tdQuantity">
                <s:text name="mainPage.studentCount"/>
            </td>
            <td>
                <s:property value="quantityList[1]"/>
            </td>
        </tr>
        <tr>
            <td class="tdQuantity">
                <s:text name="mainPage.alumniCount"/>
            </td>
            <td>
                <s:property value="quantityList[2]"/>
            </td>
        </tr>
    </table>

    <p>
        <s:text name="mainPage.forMoreInformation"/>
    </p>

    <s:submit key="button.showApplicants" action="showApplicantList" cssClass="submitButton"/>
    <s:submit key="button.showStudents" action="showStudentList" cssClass="submitButton"/>
    <s:submit key="button.showAlumni" action="showAlumniList" cssClass="submitButton"/>
    <s:submit key="button.showAdministrationArea" action="showAdminArea" cssClass="submitButton"/>


</s:form>