package pl.soa.motek.Servlets;

import pl.soa.motek.Helpers.HTMLBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.stream.Stream;

@WebServlet("/ParamsSort")
public class ParametersSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HTMLBuilder.createBeginning(out,"Sort");
        Enumeration<String> paramsList = request.getParameterNames();
        ArrayList<Double> list = new ArrayList<Double>();

        try {
            while (paramsList.hasMoreElements()) {
                list.add(Double.parseDouble(request.getParameter(paramsList.nextElement())));
            }

            list.sort(Double::compareTo);

            for (Double num : list) {
                out.print("<p>" + num + "</p>");
            }

        }catch (NumberFormatException e){
            out.print("One of parameters is not a number");
            out.close();
        }finally {

            HTMLBuilder.createEnding(out);
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
