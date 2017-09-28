package serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Rozmowa")
public class Rozmowa extends HttpServlet {
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
	   	 
		 String imie = request.getParameter("imie");
		 if (imie != null && ! imie.isEmpty()) {
			 out.println("Witaj " + imie);
		} else {
			 out.println("<p>Anonim</p>");
			 imie = "";
		}
		 
	   	 out.println("<form method='post'>");
	   	 out.println("Jak masz na imię?");
	   	 out.println("<input type='text' size='20' name='imie' value='"+imie+"'>");
	   	 out.println("<input type='submit' value='Wyślij'>");
	   	 out.println("</form>");
	   	 
	   	 out.println("</body></html>");
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
