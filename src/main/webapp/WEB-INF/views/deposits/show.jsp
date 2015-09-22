<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<html>
<head>
<title>OZMIN: Deposits - ${deposit.name} (${deposit.id})</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<c:if test="${!empty deposit}">
		<table class="tg">
			<tr>
				<th width="80">Deposit&nbsp;ID</th>
				<th width="120">Deposit Name</th>
				<th width="40">Longitude</th>
				<th width="40">Latitude</th>
				<th width="40">Mineral Project</th>
				<th width="40">Operating Status</th>

			</tr>
			<tr>
				<td>${deposit.id}</td>
				<td>${deposit.name}</td>
				<td>${deposit.x}</td>
				<td>${deposit.y}</td>
				<td>${deposit.mineralProject.name}</td>
				<td>${deposit.operatingStatus}</td>
			</tr>
		</table>

	</c:if>
	<c:if test="${!empty mineralisedZones}">
		<c:forEach items="${mineralisedZones}" var="mineralisedZone">
			<h2>${mineralisedZone.name}</h2>
			<c:if test="${!empty mineralisedZone.mineralResources}">
				<c:forEach items="${mineralisedZone.mineralResources}"
					var="mineralResource">
					<h3><fmt:formatDate type="date" dateStyle="long"  value="${mineralResource.recordDate}"></fmt:formatDate></h3>
					<table class="tg">
						<tr>
							<td>Commodity</td>
							<td>Units</td>
							
							<td>PVR</td>
							<td>PBR</td>
							<td>PPR</td>
							<td>MRS</td>
							<td>IDR</td>
							<td>MID</td>
							<td>IFR</td>
							<td>OTHER</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>${mineralResource.oreUnit.code}</td>
							<td>${mineralResource.proven}</td>
							<td>${mineralResource.probable}</td>
							<td>${mineralResource.provenAndProbable}</td>
							<td>${mineralResource.measured}</td>
							<td>${mineralResource.indicated}</td>
							<td>${mineralResource.measuredAndIndicated}</td>
							<td>${mineralResource.inferred}</td>
							<td>${mineralResource.other}</td>
						</tr>
						<c:forEach items="#{mineralResource.resourceGrades}" var="resourceGrade">
						<tr>
						 <td>${resourceGrade.commodity.id}</td>
						  <td>${resourceGrade.gradeUnit.code}</td>
							<td>${resourceGrade.proven}</td>
							<td>${resourceGrade.probable}</td>
							<td>${resourceGrade.provenAndProbable}</td>
							<td>${resourceGrade.measured}</td>
							<td>${resourceGrade.indicated}</td>
							<td>${resourceGrade.measuredAndIndicated}</td>
							<td>${resourceGrade.inferred}</td>
							<td>${resourceGrade.other}</td>
							</tr>
						</c:forEach>
					</table>
				</c:forEach>
			</c:if>
		</c:forEach>
	</c:if>
</body>
</html>
