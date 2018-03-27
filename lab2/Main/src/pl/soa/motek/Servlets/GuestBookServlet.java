package pl.soa.motek.Servlets;

import pl.soa.motek.Entities.Comment;
import pl.soa.motek.Helpers.HTMLBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet("GuestBook")
public class GuestBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Vector<Comment> comments = (Vector<Comment>) context.getAttribute("Comments");
        if (comments == null) comments = new Vector<>();
        String name = request.getParameter("Name");
        String mail = request.getParameter("Mail");
        String comment = request.getParameter("Comment");

        if(name != null || mail != null || comment != null) {
            Comment nComment = new Comment(name,mail,comment);
            comments.add(nComment);
        }
        context.setAttribute("Comments",comments);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HTMLBuilder.createBeginning(out,"Guest Book");
        if(request.getSession().getAttribute("LoggedUser") == null){
            out.print("<p> You need to log in </p>");
        }else {
            ServletContext context = getServletContext();
            Vector<Comment> comments = (Vector<Comment>) context.getAttribute("Comments");
            if (comments == null) comments = new Vector<>();

            out.print("<h1> Please submit your feedback </h1>");
            printCommentForm(out);
            out.print("<hr>");
            out.print("<h1> Comments: </h1>");

            for (Comment comment : comments) {
                printComment(out, comment);
            }
        }

        HTMLBuilder.createEnding(out);
        out.close();
    }

    private void printCommentForm(PrintWriter out){
        out.print("<p>");
        out.print("<form method=\"POST\" action=\"http://localhost:8080/Main_war_exploded/GuestBook\">");
        out.print("Your name: <input type=\"text\" name=\"Name\"><br>");
        out.print("Your email: <input type=\"email\" name=\"Mail\"><br>");
        out.print("Your comment: <input type=\"text\" name=\"Comment\" size=\"70\"><br>");
        out.print("<input type=\"submit\" value=\"Send Feedback\">");
        out.print("</form>");
        out.print("</p>");
    }

    private void printComment(PrintWriter out, Comment comment){
        out.print("<p><b>" + comment.getName() + "</b>  (" + comment.getEmail() + ") says: <br>");
        out.print(comment.getComment() + "</p>");
    }
}
