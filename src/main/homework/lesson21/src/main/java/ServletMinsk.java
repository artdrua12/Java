
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletMinsk", urlPatterns = { "/minsk" })
public class ServletMinsk extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Date date = new Date();

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1> Minsk  " + date + "</h1>");
    }
}
