package serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kalkulator2")
public class Kalkulator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	 response.setContentType("text/html");
      	 response.setCharacterEncoding("utf-8");
      	 PrintWriter out = response.getWriter();
      	 out.println("<!DOCTYPE html>");
      	 out.println("<html><head>");
      	 out.println("<title>Kalkulator serwletowy</title>");
      	 out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styl.css\">");
      	 out.println("</head><body>");
      	 out.println("<h1>Kalkulator serwletowy</h1>");
      	 out.println("<p>Teraz jest godzina: <strong>" + LocalTime.now()    + "</strong></p>");
      	 
      	 out.println("<hr>");
      	 
      	 String arg1 = request.getParameter("arg1");
      	 String arg2 = request.getParameter("arg2");
      	 String operacja = request.getParameter("operacja");

      	 out.println("<form method='post'>");
      	 out.println("Podaj dwie liczby i wybierz działanie");
      	 out.println("<input type='text' size='20' name='arg1' value='" + ne(arg1) + "'>&nbsp;");
      	 out.println("<select name='operacja'>");
      	 out.println("<option value='+'>+</value>");
      	 out.println("<option value='-'>-</value>");
      	 out.println("<option value='*'>*</value>");
      	 out.println("<option value='/'>/</value>");
      	 out.println("<option value='^'>^</value>");
      	 out.println("</select>");
      	 out.println("&nbsp;<input type='text' size='20' name='arg2' value='" + ne(arg2) + "'>");
      	 out.println("<button>Policz</button>");
      	 out.println("</form>");
      	 
      	 if(arg1 != null && arg2 != null && operacja != null) {
      		 try {
      			 double x = Double.parseDouble(arg1);
      			 double y = Double.parseDouble(arg2);
      			 double wynik = LogikaKalkulatora.oblicz(x, y, operacja);
      			 out.printf("<p class='sukces'>%f %s %f = %f</p>\n", x, operacja, y, wynik);
      			 
      		 } catch (NumberFormatException e) {
      			 out.println("<p class='error'>Niepoprawny format liczby</p>");
      		 }
      	 }
      	 
      	 out.println("</body></html>");
       }


       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	 doGet(request, response);
       }

       static String ne(String arg) {
      	 return arg == null ? "" : arg;
       }
   }


