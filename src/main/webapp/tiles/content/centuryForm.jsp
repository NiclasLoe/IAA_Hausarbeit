<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
    <table>
        <tr class="trSubHeader">
            <td>
                <s:text name="century.addNewCentury"/>
            </td>
        </tr>
        <s:select key="century.fieldOfStudy" list="@de.nordakademie.iaa.studentadmin.model.FieldOfStudy@values()"
                  cssClass="textInput"/>
        <s:textfield key="century.letterCode" cssClass="textInput"/>
        <s:textfield key="century.year" cssClass="textInput"/>
    </table>

    <s:submit key="button.save" action="saveCentury" cssClass="submitButton"/>
    <s:submit key="button.back" action="cancelCentury" cssClass="submitButton"/>
</s:form>
