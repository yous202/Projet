package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<!--\n");
      out.write("Template Name: Educational\n");
      out.write("Author: <a href=\"http://www.os-templates.com/\">OS Templates</a>\n");
      out.write("Author URI: http://www.os-templates.com/\n");
      out.write("Licence: Free to use under our free template licence terms\n");
      out.write("Licence URI: http://www.os-templates.com/template-terms\n");
      out.write("-->\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<title>Accueil</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"layout/styles/layout.css\" type=\"text/css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"layout/scripts/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"layout/scripts/jquery.slidepanel.setup.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"layout/scripts/jquery.ui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"layout/scripts/jquery.tabs.setup.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"wrapper col0\">\n");
      out.write("  <div id=\"topbar\">\n");
      out.write("    <div id=\"slidepanel\">\n");
      out.write("      <div class=\"topbox\">\n");
      out.write("        <h2>Avant de commencer</h2>\n");
      out.write("        <p>Si vous avez déjà un compte, veuillez vous connecter ! Sinon, Inscrivez-vous.</p>\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("      <div class=\"topbox\">\n");
      out.write("        <h2>Inscription</h2>\n");
      out.write("        <form action=\"AjouterAdherent\" method=\"post\">\n");
      out.write("          <fieldset>\n");
      out.write("            <legend>Veuillez insérer vos données ici : </legend>\n");
      out.write("            <label for=\"nom\">Nom:\n");
      out.write("              <input type=\"text\" name=\"nom\" id=\"nom\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("            <label for=\"prenom\">Prénom:\n");
      out.write("              <input type=\"text\" name=\"prenom\" id=\"prenom\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("             <label for=\"addresse\">Addresse:\n");
      out.write("              <input type=\"text\" name=\"addresse\" id=\"addresse\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("             <label for=\"telephone\">Télephone:\n");
      out.write("              <input type=\"text\" name=\"telephone\" id=\"telephone\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("            <label for=\"cin\">CIN:\n");
      out.write("              <input type=\"text\" name=\"cin\" id=\"cin\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("            <label for=\"email\">Email:\n");
      out.write("              <input type=\"email\" name=\"email\" id=\"email\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("            <label for=\"motdepasse\">Mot-de-passe :\n");
      out.write("              <input type=\"password\" name=\"motdepasse\" id=\"motdepasse\" value=\"\" />\n");
      out.write("            </label>\n");
      out.write("            \n");
      out.write("            <p>\n");
      out.write("              <input type=\"submit\" name=\"operation\"  value=\"Envoyer\"/>\n");
      out.write("             \n");
      out.write("            </p>\n");
      out.write("          </fieldset>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"topbox last\">\n");
      out.write("        <h2>Connexion</h2>\n");
      out.write("        <form action=\"login.jsp\" method=\"post\">\n");
      out.write("          <fieldset>\n");
      out.write("            <legend>Se connecter</legend>\n");
      out.write("            <label for=\"email\">Adresse email <span class=\"requis\">*</span></label>\n");
      out.write("            <input type=\"email\" id=\"email\" name=\"email\"/>\n");
      out.write("               \n");
      out.write("                <br />\n");
      out.write("\n");
      out.write("                <label for=\"motdepasse\">Mot de passe <span class=\"requis\">*</span></label>\n");
      out.write("                <input type=\"password\" id=\"motdepasse\" name=\"motdepasse\" />\n");
      out.write("               \n");
      out.write("                <br><br />\n");
      out.write("          \n");
      out.write("            <p>\n");
      out.write("              <input type=\"submit\" name=\"seconnecter\"  value=\"Se connecter\" />\n");
      out.write("              \n");
      out.write("            </p>\n");
      out.write("                \n");
      out.write("          </fieldset>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <br class=\"clear\" />\n");
      out.write("    </div>\n");
      out.write("    <div id=\"loginpanel\">\n");
      out.write("      <ul>\n");
      out.write("        <li class=\"left\">par ici &raquo;</li>\n");
      out.write("        <li class=\"right\" id=\"toggle\"><a id=\"slideit\" href=\"#slidepanel\">Connexion</a><a id=\"closeit\" style=\"display: none;\" href=\"#slidepanel\">Fermer</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<!-- ####################################################################################################### -->\n");
      out.write("<div class=\"wrapper col1\">\n");
      out.write("  <div id=\"header\">\n");
      out.write("    <div id=\"logo\">\n");
      out.write("      <h1><a href=\"inscription.jsp\"><img src=\"images/demo/l1.png\" alt=\"\" /></a></h1>\n");
      out.write("     \n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<!-- ####################################################################################################### -->\n");
      out.write("<div class=\"wrapper col2\">\n");
      out.write("  <div id=\"topnav\">\n");
      out.write("    <ul>\n");
      out.write("      <li class=\"active\"><a href=\"inscription.jsp\">Accueil</a>\n");
      out.write("        <ul>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li class=\"last\"><a href=\"#\"></a></li>\n");
      out.write("        </ul>\n");
      out.write("      </li>\n");
      out.write("      <li><a href=\"information.jsp\">Information d'inscription</a>\n");
      out.write("        <ul>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li class=\"last\"><a href=\"#\"></a></li>\n");
      out.write("        </ul>\n");
      out.write("      </li>\n");
      out.write("    \n");
      out.write("        <ul>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li><a href=\"#\"></a></li>\n");
      out.write("          <li class=\"last\"><a href=\"#\"></a></li>\n");
      out.write("        </ul>\n");
      out.write("      </li>\n");
      out.write("    \n");
      out.write("      <li class=\"last\"><a href=\"#\"></a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("        \n");

    String email = request.getParameter("email");    
    String motdepasse = request.getParameter("motdepasse");
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Connection con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Statement st = con.createStatement();
    Statement st1 = con1.createStatement();
    Statement st2 = con2.createStatement();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    rs = st.executeQuery("select * from adherent where email='" + email + "' and motdepasse='" + motdepasse + "'");
    rs2 = st1.executeQuery("select * from bibliothecaire where email='" + email + "' and motdepasse='" + motdepasse + "'");
    rs3 = st2.executeQuery("select * from assisstant where email='" + email + "' and motdepasse='" + motdepasse + "'");
    
     if (rs2.next()) 
    {
        session.setAttribute("email", email);
        response.sendRedirect("profil1.jsp?email="+email); 
        
    }
    else 
     {
         if (rs3.next()) 
        {
            session.setAttribute("email",email);
            response.sendRedirect("profil2.jsp?email="+email); 
            
        }
         else 
        {
            if (rs.next()) 
            {
               session.setAttribute("email", email);
               response.sendRedirect("profil.jsp?email="+email);  
               
            }
            else 
            {
                out.println(" <center><h2><a href='inscription.jsp'>Invalid email or password Try Again</a></h2></center>");
            }
        }
     }
 

      out.write("\n");
      out.write("   <!-- ####################################################################################################### -->\n");
      out.write("\n");
      out.write("<!-- ####################################################################################################### -->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
