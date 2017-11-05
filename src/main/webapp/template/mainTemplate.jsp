<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="stylesheet" href="<s:url value="/css/style.css"/>" type="text/css">
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <sb:head/>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="content"/>
</body>
</html>
