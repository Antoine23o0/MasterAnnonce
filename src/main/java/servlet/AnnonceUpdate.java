package servlet;

import dao.AnnonceDAO;
import modeles.Annonce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            AnnonceDAO dao = new AnnonceDAO();
            Annonce annonce = dao.getById(id);

            if (annonce == null) {
                request.setAttribute("error", "Annonce non trouvée !");
                request.getRequestDispatcher("AnnonceList.jsp").forward(request, response);
                return;
            }

            request.setAttribute("annonce", annonce);
            request.getRequestDispatcher("AnnonceUpdate.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("AnnonceList.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String adress = request.getParameter("adress");
            String mail = request.getParameter("mail");

            AnnonceDAO dao = new AnnonceDAO();
            Annonce annonce = dao.getById(id);

            if (annonce != null) {
                annonce.setTitle(title);
                annonce.setDescription(description);
                annonce.setAdress(adress);
                annonce.setMail(mail);
                annonce.setDate(new Timestamp(System.currentTimeMillis()));

                dao.update(annonce); // Utilisation d'Hibernate
                response.sendRedirect("AnnonceList.jsp");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour !");
                request.getRequestDispatcher("AnnonceUpdate.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("AnnonceList.jsp");
        }
    }
}
