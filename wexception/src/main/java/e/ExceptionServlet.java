package e;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                                          HttpServletResponse response) {
        throw new IllegalStateException("Random exception");
    }
}
