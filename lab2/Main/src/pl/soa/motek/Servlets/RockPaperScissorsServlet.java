package pl.soa.motek.Servlets;

import pl.soa.motek.Helpers.HTMLBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("RockPaperScissors")
public class RockPaperScissorsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p1 = request.getParameter("Player1");
        String p2 = request.getParameter("Player2");

        if(p1 != null){
            request.getSession().setAttribute("Player1",p1);
        }else if(p2 != null){
            request.getSession().setAttribute("Player2",p2);
        }
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HTMLBuilder.createBeginning(out,"RPS");
        String player1 = (String) request.getSession().getAttribute("Player1");
        String player2 = (String) request.getSession().getAttribute("Player2");

        if(player1 == null){
            out.print("<h1> Player1 </h1>");
            out.print("<form method=\"POST\" action=\"RockPaperScissors\">\n" +
                    "    Typ: <select name=\"Player1\">\n" +
                    "            <option value=\"Rock\">Kamien</option>\n" +
                    "            <option value=\"Paper\">Papier</option>\n" +
                    "            <option value=\"Scissors\">Nozyczki</option>\n" +
                    "         </select>\n" +
                    "    <input type=\"submit\" value=\"Submit\">\n" +
                    "</form>");
        }else if(player2 == null){
            out.print("<h1> Player1 </h1>");
            out.print("<form method=\"POST\" action=\"RockPaperScissors\">\n" +
                    "    Typ: <select name=\"Player2\">\n" +
                    "            <option value=\"Rock\">Kamień</option>\n" +
                    "            <option value=\"Paper\">Papier</option>\n" +
                    "            <option value=\"Scissors\">Nożyczki</option>\n" +
                    "         </select>\n" +
                    "    <input type=\"submit\" value=\"Submit\">\n" +
                    "</form>");
        }else{
            out.print("<h1> Result </h1>");
            out.print("<p>" + getWinner(player1,player2) + "</p>");
            out.print("<p> Refresh to play again </p>");
            request.getSession().invalidate();
        }

        HTMLBuilder.createEnding(out);
        out.close();
    }

    private String getWinner(String s1, String s2){
        if( s1.equals(s2) ) return "Draw!";
        else{
            if(s1.equals("Scissors") && s2.equals("Rock")){
                return "Player2 wins!";
            }else if(s1.equals("Scissors") && s2.equals("Paper")){
                return "Player1 wins!";
            }else if(s1.equals("Rock") && s2.equals("Paper")){
                return "Player2 wins!";
            }else if(s1.equals("Rock") && s2.equals("Scissors")){
                return "Player1 wins!";
            }else if(s1.equals("Paper") && s2.equals("Scissors")){
                return "Player2 wins!";
            }else if(s1.equals("Paper") && s2.equals("Rock")){
                return "Player1 wins!";
            }else{
                return "ERROR";
            }
        }
    }
}
