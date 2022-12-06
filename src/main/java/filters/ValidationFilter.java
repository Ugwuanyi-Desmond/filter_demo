package filters;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ValidationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String pan = request.getParameter("pan");
		System.out.println("Hi from filter");
		if (pan == null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")){
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style = 'color:red'> Invalid PAN No. </SPAN>");
		} else {
			request.setAttribute("pan", pan);
			chain.doFilter(request, response);
			System.out.println("Bye from filter");

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
