<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <!-- Pull in JQuery -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="<s:url value="/css/style.css"/>" type="text/css">
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script language="JavaScript" src="<s:url value="/js/javascript.js"/>"/>
    <sb:head/>
</head>
<body>
<tiles:insertAttribute name="content"/>

</body>
</html>
