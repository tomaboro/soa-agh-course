package pl.soa.motek.Servlets;

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

@WebServlet("/ParamsAverage")
public class ParametersAverage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Enumeration<String> paramsList = request.getParameterNames();

        ArrayList<Double> list = new ArrayList<Double>();

        try {
            while (paramsList.hasMoreElements()) {
                list.add(Double.parseDouble(request.getParameter(paramsList.nextElement())));
            }

            out.print(countAverage(list));
        }catch (NumberFormatException e){
            out.print("One of parameters id not a number! :(");
        }finally {
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private Double countAverage(ArrayList<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum()/ (long) list.size();
    }
}
