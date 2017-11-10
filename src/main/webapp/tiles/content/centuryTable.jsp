<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h2><s:text name="centuryList.header"/></h2></div>
        <div class="panel-body">
            <s:form theme="bootstrap">
                <div class="form-group">
                    <s:submit key="button.addCentury" action="addCentury" cssClass="btn"/>
                </div>
                <table class="table datatable-design" id="centuryTable">
                    <thead>
                        <tr>
                            <th class="no-sort"></th>
                            <th><s:text name="tableView.fieldOfStudy"/></th>
                            <th><s:text name="tableView.year"/></th>
                            <th><s:text name="tableView.letterCode"/></th>
                            <th><s:text name="tableView.centuryName"/></th>
                        </tr>
                    </thead>
                    <s:iterator value="centuryList">
                        <tr class="notFirst">
                            <td><s:radio name="centuryString" list="#{year+letterCode+fieldOfStudy:''}"
                                         theme="simple" onclick="return enableControls(this,
                                         [ '#buttonDownloadAttendanceList' ]);"/></td>
                            <td class="tdApplicantView"><s:property value="fieldOfStudy"/></td>
                            <td class="tdApplicantView"><s:property value="year"/></td>
                            <td class="tdApplicantView"><s:property value="letterCode"/></td>
                            <td class="tdApplicantView"><s:property value="centuryName"/></td>
                        </tr>
                    </s:iterator>
                </table>
                <s:actionerror/>
                <div class="form-group">
                    <s:submit id="buttonDownloadAttendanceList" key="button.downloadAttendanceList"
                              disabled="true" action="downloadAttendanceList" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showAdminArea" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>