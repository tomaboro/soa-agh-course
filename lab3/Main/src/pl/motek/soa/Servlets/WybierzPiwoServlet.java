package pl.motek.soa.Servlets;

import pl.motek.soa.Model.EkspertPiwny;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("WybierzPiwo.do")
public class WybierzPiwoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Porada piwna<br/>");
        String c = request.getParameter("kolor");
        out.println("<br/>Wybor kolor piwa: "+c);

        ArrayList<String> wybor = EkspertPiwny.wybierzPiwo(c);

        /*for(String piwo: wybor){
            out.println("<br/> " + piwo);
        }*/

        request.setAttribute("wybor", wybor);
        RequestDispatcher view = request.getRequestDispatcher("wyniki.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
