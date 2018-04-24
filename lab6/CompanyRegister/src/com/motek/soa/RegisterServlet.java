package com.motek.soa;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendJMSMessage")
public class RegisterServlet extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
		String cName = request.getParameter("comanyName");
		String cSize = request.getParameter("companySize");
		String cDescription = request.getParameter("companyDescription");
		String cLocation = request.getParameter("comanyLocation");
		
		HashMap<String,String> map = new HashMap<>();
		map.put("name", cName);
		map.put("size", cSize);
		map.put("description", cDescription);
		map.put("location", cLocation);
		
		BussinesLookup bl = new BussinesLookup();
		JEEService service = bl.getService("JMS");
		
		try {
			service.init();
			service.sendMessage(map);
			service.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
			doPost(request,response);
	}

}
