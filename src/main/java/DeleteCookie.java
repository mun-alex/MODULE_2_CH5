import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCookie", value = "/delete-cookie")
public class DeleteCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie personName = new Cookie("Name", request.getParameter(""));
        Cookie personSurname = new Cookie("Surname", request.getParameter(""));
        Cookie personCountry = new Cookie("Country", request.getParameter(""));
        Cookie personPhone = new Cookie("Phone", request.getParameter(""));

        personName.setMaxAge(0);
        personSurname.setMaxAge(0);
        personCountry.setMaxAge(0);
        personPhone.setMaxAge(0);

        response.addCookie(personName);
        response.addCookie(personSurname);
        response.addCookie(personCountry);
        response.addCookie(personPhone);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
