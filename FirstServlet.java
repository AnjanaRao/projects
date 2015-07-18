helloWorld


import javax.servlet.*;
Hello World
public class FirstServlet extends GenericServlet
{
	public void service(ServletRequest sreq, ServletResponse sres)
	{
		try
		{
			ServletOutputStream sos = sres.getOutputStream();
			//response.setContentType("text/html");
		
		//PrintWriter pw = response.getWriter();
			sos.println("<html><body bgcolor =pink>");
		sos.println("<h1>WELCOME TO SERVLETS<h1>");
		//pw.println("<h1>Anjan how are you</br></h1>");
		sos.println("<h>Anjan Rao<h>");
			sos.println("</body></html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
