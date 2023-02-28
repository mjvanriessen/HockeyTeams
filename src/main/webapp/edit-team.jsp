<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Team</title>
</head>
<body>
	<form action="editTeamServlet" method="post">
		Team: <input type="text" name="team" value="${teamToEdit.teamName}">
		City: <input type="text" name="city" value="${teamToEdit.teamCity}">
		Wins: <input type="text" name="wins" value="${teamToEdit.teamWins}">
		<input type="hidden" name="id" value="${teamToEdit.teamId}">
		<input type="submit" value="Save Edited Team">
	</form>
</body>
</html>