<%--suppress ELValidationInJSP --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h2><s:text name="header.listOfRooms"/></h2>
<s:form>
	<s:actionerror/>
	<table>
		<tr>
			<th></th>
			<th><s:text name="room.building"/></th>
			<th><s:text name="room.roomNumber"/></th>
			<th><s:text name="room.seats"/></th>
			<th><s:text name="room.beamerPresent"/></th>
		</tr>
		<s:iterator value="rooms">
			<tr>
                <%--suppress ELDeferredExpressionsInspection --%>
                <td><s:radio name="roomId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="building"/></td>
				<td><s:property value="roomNumber"/></td>
				<td><s:property value="seats"/></td>
				<td><s:property value="beamerPresent"/></td>
			</tr>
		</s:iterator>
	</table>
	<s:submit key="button.addRoom" action="addRoom"/>
	<s:submit key="button.editRoom" action="loadRoom"/>
	<s:submit key="button.deleteRoom" action="deleteRoom"/>
</s:form>