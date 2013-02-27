<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html lang="pl">
<head><meta charset="UTF-8"><title>QR</title></head>
<link rel="stylesheet" href="<c:url value="/resources/qr.css/" />"/>
<body>
<c:forEach var="qrurl" items="${qrModel.urls}" varStatus="row">
<div class="qrbox">
<p class="info">Zeskanuj kod QR</p>
<img src="${qrurl.qrUrl}" title="${qrurl.description}"/>
<p class="info">lub przejdź pod adres</p>
<p class="url">${qrurl.url}</p>
</div>
<c:if test="${row.count % 10 == 0}">
<div class="page-break"></div>
</c:if>
</c:forEach>
</body>
</html>
