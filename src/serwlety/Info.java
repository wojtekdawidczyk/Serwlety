package serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Info")
public class Info extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 response.setContentType("text/plain");
   	 response.setCharacterEncoding("UTF-8");

   	 PrintWriter out = response.getWriter();
   	 out.println("ContextPath: " + request.getContextPath());
   	 out.println("RequestURI: " + request.getRequestURI());
   	 out.println("QueryString: " + request.getQueryString());

   	 out.println();
   	 out.println("LocalName: " + request.getLocalName());
   	 out.println("LocalAddr: " + request.getLocalAddr());
   	 out.println("LocalPort: " + request.getLocalPort());
   	 out.println();
   	 out.println("RemoteHost: " + request.getRemoteHost());
   	 out.println("RemoteAddr: " + request.getRemoteAddr());
   	 // itd.

   	 out.println();
   	 out.println("parametr x: " + request.getParameter("x"));
   	 out.println("parametr y: " + request.getParameter("y"));
   	 out.println("Wszystkie parametry:");
   	 for (Map.Entry e : request.getParameterMap().entrySet()) {
   		 String[] v = (String[]) e.getValue();
   		 out.println(" * " + e.getKey() + " : " + Arrays.toString(v));
   	 }
   	 out.println();

   	 out.println("nagłówek Accept: " + request.getHeader("Accept"));
   	 out.println("nagłówek User-Agent: " + request.getHeader("User-Agent"));
   	 out.println("Wszystkie nagłówki:");
   	 Enumeration<String> headerNames = request.getHeaderNames();
   	 while(headerNames.hasMoreElements()) {
   		 String nm = headerNames.nextElement();
   		 out.println(nm + ": " + request.getHeader(nm));
   	 }
   	 out.println();    }

}



