package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import AlgSlopeOne.Usuario;
import AlgSlopeOne.SlopeOne;
import java.awt.HeadlessException;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"formatos.css\">\n");
      out.write("        <title>Pagina Teste</title>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function divShow() {\n");
      out.write("                var divResult = document.getElementById(\"result\");\n");
      out.write("                divResult.style.display = \"block\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            <div id=\"principal\">\n");
      out.write("                <div id=\"titulo\">\n");
      out.write("                    <h1>Avalie os itens abaixo</h1>\n");
      out.write("                </div>\n");
      out.write("                <form id=\"form\" action=\"servletSlopeOne\" method=\"post\" autocomplete=\"off\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h2>Rack</h2>\n");
      out.write("                                <img id=\"imagem\" src=\"Imagem 1.jpg\" />\n");
      out.write("                            </td>                                \n");
      out.write("                            <td>\n");
      out.write("                                <h2>Cadeira</h2>\n");
      out.write("                                <img id=\"imagem\" src=\"Imagem 2.jpg\" />\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <h2>Pia</h2>\n");
      out.write("                                <img id=\"imagem\" src=\"Imagem 3.jpg\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"campo\" size=\"40\" type=\"float\" name=\"input1\">\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"campo\" size=\"40\" type=\"float\" name=\"input2\">\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"campo\" size=\"40\" type=\"float\" name=\"input3\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>                            \n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h2>Estante</h2>\n");
      out.write("                                <img id=\"imagem\" src=\"Imagem 4.jpg\" />\n");
      out.write("                            </td>\n");
      out.write("                            <td>   \n");
      out.write("                                <h2>Cama</h2>\n");
      out.write("                                <img id=\"imagem\" src=\"Imagem 5.jpg\" />\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <h2>Armário</h2>  \n");
      out.write("                                <img id=\"imagem\" src=\"Imagem 6.jpg\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"campo\" size=\"40\" type=\"float\" name=\"input4\">\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"campo\" size=\"40\" type=\"float\" name=\"input5\">\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input id=\"campo\" size=\"40\" type=\"float\" name=\"input6\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <input id=\"method\" type=\"int\" name=\"method\" value=\"1\">\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <input id=\"botao\" name=\"enviar\" type=\"submit\" value=\"Enviar\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
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
