package pl.soa.motek.Servlets;

import pl.soa.motek.Helpers.HTMLBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkGenderAndAge")
public class NameCheckerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HTMLBuilder.createBeginning(out,"Name Checker");

        String name = request.getParameter("Name");
        Integer age = Integer.parseInt(request.getParameter("Age"));
        Boolean isFemale = name.endsWith("a");
        Boolean isAdult = age >= 18;

        out.print("<p>isFemale: " + isFemale.toString() + "</p>");
        out.print("<p>isAdult: " + isAdult.toString() + "</p>" );

        HTMLBuilder.createEnding(out);
        out.close();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request,response);
    }
}
