import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookies = request.getCookies();

        String personName = "";
        String personSurname = "";
        String personCountry = "";
        String personPhone = "";

        for (Cookie cookie : cookies) {

            switch (cookie.getName()) {
                case "Name":
                    personName = cookie.getValue();
                    break;
                case "Surname":
                    personSurname = cookie.getValue();
                    break;
                case "Country":
                    personCountry = cookie.getValue();
                    break;
                case "Phone":
                    personPhone = cookie.getValue();
                    break;
                default:
                    break;
            }

        }

        request.setAttribute("name", personName);
        request.setAttribute("surname", personSurname);
        request.setAttribute("country", personCountry);
        request.setAttribute("phone", personPhone);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie personName = new Cookie("Name", request.getParameter("personName"));
        Cookie personSurname = new Cookie("Surname", request.getParameter("personSurname"));
        Cookie personCountry = new Cookie("Country", request.getParameter("personCountry"));
        Cookie personPhone = new Cookie("Phone", request.getParameter("personPhone"));

        personName.setMaxAge(30 * 24 * 60 * 60);
        personSurname.setMaxAge(30 * 24 * 60 * 60);
        personCountry.setMaxAge(30 * 24 * 60 * 60);
        personPhone.setMaxAge(30 * 24 * 60 * 60);

        response.addCookie(personName);
        response.addCookie(personSurname);
        response.addCookie(personCountry);
        response.addCookie(personPhone);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        response.sendRedirect("/main");
    }
}
