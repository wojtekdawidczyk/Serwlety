package serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kalkulator")
public class Kalkulator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		 out.println("<!DOCTYPE html>");
	   	 out.println("<html><head>");
	   	 out.println("<title>Serwlet HTML</title>");
	   	 out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styl.css\">");
	   	 out.println("</head><body>");
	   	 out.println("<h1>Serwlet produkujący HTML</h1>");
	   	 out.println("<p>Teraz jest godzina: <strong>" + LocalTime.now()
	   		 + "</strong></p>");
	   	
		 out.println("<hr>");
	   	 
		 Integer pierwszaLiczba = 0;
		 Integer drugaLiczba=0;
		 Integer suma = 0 ;
		 

			try {
				pierwszaLiczba = Integer.parseInt(request.getParameter("pierwszaLiczba"));
				drugaLiczba = Integer.parseInt(request.getParameter("drugaLiczba"));
				suma = pierwszaLiczba + drugaLiczba;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		 out.println("Suma wynosi : "+suma);

	   	 out.println("<form method='post'>");
	   	 out.println("Dodaj dwie liczby");
	   	 out.println("<input type='text' size='20' name='pierwszaLiczba' value='"+pierwszaLiczba+"'>");
	   	 out.println("<input type='text' size='20' name='drugaLiczba' value='"+drugaLiczba+"'>");
		   	
	   	 
	   	 out.println("<input type='submit' value='Wyślij'>");
	   	 
	   	 out.println("</form>");
	   	 
	   	 out.println("</body></html>");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
