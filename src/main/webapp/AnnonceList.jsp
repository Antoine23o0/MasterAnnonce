<%@ page import="dao.AnnonceDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="modele.entite.AnnonceEntite" %>
%@ page import="java.util.List, modeles.Annonce, dao.AnnonceDAO" %>
<html>
<head>
    <title>Liste des Annonces</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container mt-4">
    <h2 class="text-center text-primary">Liste des Annonces</h2>
    <a href="AnnonceAdd.jsp" class="btn btn-success mb-3"> Ajouter une Annonce</a>
    <table class="table table-striped table-hover">
        <thead class="table-primary">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Description</th>
            <th>Adresse</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            try {
                AnnonceDAO dao = new AnnonceDAO();
                List<AnnonceEntite> annonces = dao.getAll();
                for (AnnonceEntite annonce : annonces) {
        %>
        <tr>
            <td><%= annonce.getId() %></td>
            <td><%= annonce.getTitle() %></td>
            <td><%= annonce.getDescription() %></td>
            <td><%= annonce.getAdresse() %></td>
            <td><%= annonce.getMail() %></td>
            <td>
                <a href="AnnonceUpdate.jsp?id=<%= annonce.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
                <a href="AnnonceDelete?id=<%= annonce.getId() %>" class="btn btn-danger btn-sm"
                   onclick="return confirm('⚠ Supprimer cette annonce ?');"> Supprimer</a>
            </td>
        </tr>
        <%
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="6" class="text-danger">⚠ Erreur lors du chargement des annonces</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>