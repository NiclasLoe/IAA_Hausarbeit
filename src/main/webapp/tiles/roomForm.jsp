<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h2><s:text name="header.editRoom"/></h2>
<s:form>
    <s:hidden name="room.id"/>
	<s:textfield key="room.building" requiredLabel="true"/>
	<s:textfield key="room.roomNumber" requiredLabel="true"/>
	<s:textfield key="room.seats" requiredLabel="true"/>
	<s:checkbox key="room.beamerPresent"/>
	<s:submit key="button.save" action="saveRoom"/>
	<s:submit key="button.cancel" action="cancelRoom"/>
</s:form>