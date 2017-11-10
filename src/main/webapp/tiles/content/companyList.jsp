<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container containerMarginTop">
    <div class="panel panel-default">
        <div class="panel-heading"><h2><s:text name="companyList.header"/></h2></div>
        <div class="panel-body">
            <s:form theme="bootstrap">
                <div class="form-group">
                    <s:submit key="button.addCompany" action="addCompany" cssClass="btn"/>
                </div>
                <table class="table datatable-design" id="companyTable">
                    <thead>
                        <tr>
                            <th class="no-sort"></th>
                            <th><s:text name="company.companyName1"/></th>
                            <th><s:text name="company.companyName2"/></th>
                            <th><s:text name="company.shortName"/></th>
                            <th><s:text name="company.contactPerson"/></th>
                        </tr>
                    </thead>
                    <s:iterator value="companyList">
                        <tr class="notFirst">
                            <td><s:radio name="companyId" list="#{id:''}" theme="simple"
                                         onclick="return enableControls(this, [ '#buttonSeeMore', '#buttonDownloadCompanyList' ]);"/></td>
                            <td class="tdApplicantView"><s:property value="companyName1"/></td>
                            <td class="tdApplicantView"><s:property value="companyName2"/></td>
                            <td class="tdApplicantView"><s:property value="shortName"/></td>
                            <td class="tdApplicantView"><s:property value="contactPerson"/></td>
                        </tr>
                    </s:iterator>
                </table>
                <s:actionerror/>
                <div class="form-group">
                    <s:submit id="buttonSeeMore" key="button.seeMore" disabled="true" action="loadCompany" cssClass="btn"/>
                    <s:submit id="buttonDownloadCompanyList" key="button.downloadCompanyList" disabled="true" action="downloadCompanyList" cssClass="btn"/>
                    <s:submit key="button.goBack" action="showAdminArea" cssClass="btn"/>
                </div>
            </s:form>
        </div>
    </div>
</div>