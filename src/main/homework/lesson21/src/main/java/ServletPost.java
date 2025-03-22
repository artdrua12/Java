import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");
        response.setContentType("text/html;charset=UTF-8");
        String checkAge = (Integer.valueOf(age) > 17) ? "Совершеннолетний" : "Не совершеннолетний";
        response.getWriter().println("<h1> " + age + " - " + checkAge + "</h1>");
    }
}
