<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="century.addNewCentury"/>
            </td>
        </tr>
        <s:select key="century.fieldOfStudy" list="@de.nordakademie.iaa.studentadmin.utilities.FieldOfStudy@values()"
                  cssClass="textInput" headerValue="student.pleaseSelect" headerKey=""/>
        <s:textfield key="century.letterCode" cssClass="textInput"/>
        <s:textfield key="century.year" cssClass="textInput"/>
    </table>

    <s:submit key="button.saveCentury" action="saveCentury" cssClass="submitButton"/>
    <s:submit key="button.goBack" action="cancelCentury" cssClass="submitButton"/>
</s:form>