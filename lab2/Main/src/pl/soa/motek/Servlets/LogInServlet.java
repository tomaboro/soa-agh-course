package pl.soa.motek.Servlets;

import pl.soa.motek.Entities.PeronalData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet("/LogIn")
public class LogInServlet extends HttpServlet {
    Vector<PeronalData> repository = new Vector<>();

    @Override
    public void init() throws ServletException {
        super.init();
        repository.add(new PeronalData("motek","admin123"));
        repository.add(new PeronalData("iza1721","izaiza"));
        repository.add(new PeronalData("jangaps","12345678"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("Login");
        String pass = request.getParameter("Password");

        if(login.isEmpty()){
            out.print("Nie wpisano loginu");
        }else if(pass.isEmpty()){
            out.print("Nie wpisanio hasła");
        }else{
            PeronalData user = new PeronalData(request.getParameter("Login"),request.getParameter("Password"));
            if(!isUserValid(user)){
                out.print("Nie poprawne dane");
            }
            else{
                request.getSession().setAttribute("LoggedUser",user);
                request.getRequestDispatcher("GuestBook").forward(request,response);
                //response.sendRedirect("http://localhost:8080/Main_war_exploded/GuestBook");
            }
        }

        out.close();
    }

    private Boolean isUserValid(PeronalData user){
        for(PeronalData oUser: repository){
            if (user.getLogin().equals(oUser.getLogin()) && user.getPassword().equals(oUser.getPassword()))
                return true;
        }
        return false;
    }
}
