<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="container">
    <s:form key="title.generalHeader" theme="bootstrap" cssClass="form-horizontal" action="">
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="mainPage.databaseInformation"/></div>
            <div class="panel-body">

                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th><s:text name="mainPage.count"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><s:text name="mainPage.applicantCount"/></td>
                            <td><s:property value="quantityList[0]"/></td>
                        </tr>
                        <tr>
                            <td><s:text name="mainPage.studentCount"/></td>
                            <td><s:property value="quantityList[1]"/></td>
                        </tr>
                        <tr>
                            <td><s:text name="mainPage.alumniCount"/></td>
                            <td><s:property value="quantityList[2]"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><s:text name="mainPage.furtherInformation"/></div>
            <div class="panel-body">
                <p>
                    <s:text name="mainPage.forMoreInformation"/>
                </p>
                <div class="form-group">
                    <s:submit key="button.showApplicants" action="showApplicantList" cssClass="btn"/>
                    <s:submit key="button.showStudents" action="showStudentList" cssClass="btn"/>
                    <s:submit key="button.showAlumni" action="showAlumniList" cssClass="btn"/>
                    <s:submit key="button.showAdministrationArea" action="showAdminArea" cssClass="btn"/>
                </div>
            </div>
        </div>
    </s:form>
</div>