package servlet;

import dao.AnnonceDAO;
import modele.entite.AnnonceEntite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/annonce/add")
public class AnnonceAdd extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String adress = req.getParameter("adress");
        String mail = req.getParameter("mail");
        String date = LocalDate.now().toString();


        AnnonceEntite annonce = new AnnonceEntite(
                0,
                title,
                description,
                date,
                mail,
                adress
        );

        try {
            AnnonceDAO annonceDAO = new AnnonceDAO();
            annonceDAO.insert(annonce);
            res.sendRedirect(req.getContextPath() + "/annonce/liste");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("AnnonceList.jsp").forward(req, res);
    }
}
