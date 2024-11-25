import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/softwareCalculation")
public class servletcalc extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the user input from the form
        String systemSoftwareStr = request.getParameter("systemSoftware");
        String applicationSoftwareStr = request.getParameter("applicationSoftware");
        String utilitySoftwareStr = request.getParameter("utilitySoftware");

        // Convert the input to integers
        int systemSoftware = Integer.parseInt(systemSoftwareStr);
        int applicationSoftware = Integer.parseInt(applicationSoftwareStr);
        int utilitySoftware = Integer.parseInt(utilitySoftwareStr);

        // Calculate total software installed
        int totalSoftware = systemSoftware + applicationSoftware + utilitySoftware;

        // Calculate percentage of each type
        double systemPercentage = ((double) systemSoftware / totalSoftware) * 100;
        double applicationPercentage = ((double) applicationSoftware / totalSoftware) * 100;
        double utilityPercentage = ((double) utilitySoftware / totalSoftware) * 100;

        // Set the content type of the response
        response.setContentType("text/html");

        // Get the PrintWriter object to write the response
        PrintWriter out = response.getWriter();

        // Write the response as HTML
        out.println("<html>");
        out.println("<head><title>Software Calculation Results</title></head>");
        out.println("<body>");
        out.println("<h1>Software Calculation Results</h1>");
        out.println("<p>Total Software Installed: " + totalSoftware + "</p>");
        out.println("<p>System Software: " + systemSoftware + " (" + String.format("%.2f", systemPercentage) + "%)</p>");
        out.println("<p>Application Software: " + applicationSoftware + " (" + String.format("%.2f", applicationPercentage) + "%)</p>");
        out.println("<p>Utility Software: " + utilitySoftware + " (" + String.format("%.2f", utilityPercentage) + "%)</p>");
        out.println("<a href=\"index.html\">Go back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
