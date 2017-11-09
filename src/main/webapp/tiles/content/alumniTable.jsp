<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h2><s:text name="alumni.header"/></h2></div>
        <div class="panel-body">
            <s:form theme="bootstrap">
                <div class="form-group">
                    <s:submit key="button.filterList" action="filterAlumni" cssClass="btn"/>
                    <s:submit key="button.clearFilter" action="showAlumniList" cssClass="btn"/>
                </div>
                <div class="form-group">
                    <s:textfield key="searchfield.title" onkeyup="filterTable(this, '#alumniTable')"/>
                </div>
                <table class="table" id="alumniTable">
                    <thead>
                        <tr >
                            <th></th>
                            <th><s:text name="tableView.StudentId"/></th>
                            <th><s:text name="tableView.lastName"/></th>
                            <th><s:text name="tableView.firstName"/></th>
                            <th><s:text name="tableView.centuryName"/></th>
                            <th><s:text name="tableView.emailAddress"/></th>
                            <th><s:text name="tableView.status"/></th>
                        </tr>
                    </thead>
                    <s:iterator value="studentList">
                        <tr class="notFirst">
                            <td><s:radio name="studentId" list="#{id:''}" theme="simple" onselect=""/></td>
                            <td class="tdApplicantView"><s:property value="studentId"/></td>
                            <td class="tdApplicantView"><s:property value="lastName"/></td>
                            <td class="tdApplicantView"><s:property value="firstName"/></td>
                            <td class="tdApplicantView"><s:property value="%{century.centuryName}"/></td>
                            <td class="tdApplicantView"><s:property value="emailAddress"/></td>
                            <td class="tdApplicantView"><s:property value="status"/></td>
                        </tr>
                    </s:iterator>
                    <tr></tr>
                </table>
                <s:actionerror/>
                <div class="form-group">
                    <s:submit key="button.seeMore" action="loadAlumni" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showMainPage" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>