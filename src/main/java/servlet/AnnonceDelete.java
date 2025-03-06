package servlet;

import dao.AnnonceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            AnnonceDAO dao = new AnnonceDAO();

            if (dao.delete(id)) {
                response.sendRedirect("AnnonceList.jsp");
            } else {
                request.setAttribute("error", "Erreur lors de la suppression !");
                request.getRequestDispatcher("AnnonceList.jsp").forward(request, response);
            }
        } catch (NumberFormatException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("AnnonceList.jsp");
        }
    }
}
