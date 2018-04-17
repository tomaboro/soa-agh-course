package com.motek.soa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Converter")
public class ConverterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
        double result = 0;
		double temp = Double.parseDouble(request.getParameter("temp"));
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		try{   
		    Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
	        InitialContext context = new InitialContext(props);
 
	        String appName = "";        	 
	        String moduleName = "TemperatureConverter";
	        String distinctName = "";        	 
	        String beanName = TempConverter.class.getSimpleName();        	 
	        String interfaceName = TempConverterRemote.class.getName();
	        String name = "ejb:" + appName + "/" + moduleName + "/" +  distinctName    + "/" + beanName + "!" + interfaceName;
	        
	        TempConverterRemote bean = (TempConverterRemote)context.lookup(name);
			
			if(request.getParameter("mode").equals("1")) {
	    	        result = bean.Cels2Fahr(temp); 	        
			}else {
				result = bean.Fahr2Cels(temp); 
			}
			
			out.print("<h1>" + result + "</h1>");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			out.close();
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
		doPost(request,response);
	}
}
