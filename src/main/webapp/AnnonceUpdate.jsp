<%@ page import="dao.AnnonceDAO, modeles.Annonce" %>
<html>
<head>
    <title>Modifier une Annonce</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Modifier une Annonce</h2>

<div class="container">
    <form action="AnnonceUpdate" method="post">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <label for="title">Titre :</label>
        <input type="text" id="title" name="title" required>

        <button type="submit">Modifier</button>
    </form>
</div>

</body>
</html>
