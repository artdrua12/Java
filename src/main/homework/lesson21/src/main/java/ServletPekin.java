
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletPekin", urlPatterns = { "/beijing" })
public class ServletPekin  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromTimeZone = "GMT+8";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        format.setTimeZone(TimeZone.getTimeZone(fromTimeZone));
        String worldDate = format.format(date);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1> Pekin  " + worldDate + "</h1>");
    }
}
