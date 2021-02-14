<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" action="/addDevoir" modelAttribute="devoir">
             <table>
                <tr>
                    <td><form:label path="texte">texte</form:label></td>
                    <td><form:input path="texte"/></td>
                </tr>
                <tr>
                    <td><form:label path="date">date</form:label></td>
                    <td><form:input path="date"/></td>
                </tr>
                 <tr>
                    <td><form:label path="url">url</form:label></td>
                    <td><form:input path="url"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>