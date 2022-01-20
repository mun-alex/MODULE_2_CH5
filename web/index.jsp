<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 20.01.2022
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<%
    String name = (String) request.getAttribute("name");
    String surname = (String) request.getAttribute("surname");
    String country = (String) request.getAttribute("country");
    String phone = (String) request.getAttribute("phone");

%>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 m-auto">
                <form action="/main" method="post" class="mt-5">
                    <div class="mb-3">
                        <label for="personName" class="form-label">Name</label>
                        <input type="text" value="<%=name != null?name:""%>" class="form-control" id="personName" name="personName" placeholder="insert name">
                    </div>
                    <div class="mb-3">
                        <label for="personSurname" class="form-label">Surname</label>
                        <input type="text" value="<%=surname != null?surname:""%>" class="form-control" id="personSurname" name="personSurname" placeholder="insert surname">
                    </div>
                    <div class="mb-3">
                        <label for="personCountry" class="form-label">Country</label>
                        <select name="personCountry" class="form-control" id="personCountry">
                            <option value="<%=country != null?country:""%>"><%=request.getAttribute("country")%></option>
                            <option value="usa">USA</option>
                            <option value="can">Canada</option>
                            <option value="kz">Kazakhstan</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="personPhone" class="form-label">Phone</label>
                        <input type="text" value="<%=phone != null?phone:""%>" class="form-control" id="personPhone" name="personPhone">
                    </div>

                    <button type="submit" class="btn btn-primary">Draft</button>
                    <a href="/delete-cookie" class="btn btn-danger">Delete Cookie</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
