package pl.soa.motek.Servlets;

import pl.soa.motek.Helpers.CarChoiceHelper;
import pl.soa.motek.Helpers.HTMLBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CarChoice")
public class CarPickerServlet extends HttpServlet {
    private CarChoiceHelper helper = new CarChoiceHelper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HTMLBuilder.createBeginning(out,"Car Picker");

        Double maxPrice = Double.parseDouble(request.getParameter("MaxPrice"));
        String type = request.getParameter("CarType");

        out.print("<h1> Wprowadzone dane </h1>");
        out.print("<p> Typ: " + type + "</p>");
        out.print("<p> Próg cenowy: " + maxPrice + "</p>");

        out.print("<h1> Wybrany samochód </h1>");
        out.print("<p>" + helper.getBestCar(maxPrice,type) + "</p>");

        HTMLBuilder.createEnding(out);
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("GET nie jest obsługiwany");
        out.close();
    }
}
