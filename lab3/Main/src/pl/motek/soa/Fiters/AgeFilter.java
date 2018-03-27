package pl.motek.soa.Fiters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AgeFilter", urlPatterns = {"/WybierzPiwo.do"})
public class AgeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (Integer.parseInt(req.getParameter("wiek")) < 18) {
            resp.getWriter().print("Nie jestes pelnoletni!");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
