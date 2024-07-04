/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class update extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             Cookie c[] = request.getCookies();
            if(c==null){
                out.println("<div Style='background-color: #248d00; padding: 10px;'><h3 style='margin-left:50px; color:red;'> You're Not Logged in!</div>");
                
            request.getRequestDispatcher("login.html").include(request, response);
            }
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" +
"\n" +
"  <title>VOMS - HOME</title>\n" +
"  <meta content=\"\" name=\"description\">\n" +
"  <meta content=\"\" name=\"keywords\">\n" +
"\n" +
"  <!-- Favicons -->\n" +
"  <link href=\"assets/img/favicon2.png\" rel=\"icon\">\n" +
"  <link href=\"assets/img/favicon3.png\" rel=\"apple-touch-icon\">\n" +
"\n" +
"  <!-- Google Fonts -->\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\n" +
"\n" +
"  <!-- Vendor CSS Files -->\n" +
"  <link rel=\"stylesheet\" href=\"assets/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css\">\n" +
"		\n" +
"  <!-- STYLE CSS -->\n" +
"  <link rel=\"stylesheet\" href=\"assets/css/style1.css\">\n" +
"  <link href=\"https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css\" rel=\"stylesheet\">\n" +
"\n" +
"  <link href=\"assets/vendor/aos/aos.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\n" +
"\n" +
"  <!-- Template Main CSS File -->\n" +
"  <link href=\"assets/css/style.css\" rel=\"stylesheet\">\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"\n" +
"  <!-- ======= Header ======= -->\n" +
"  <header id=\"header\" class=\"fixed-top \">\n" +
"    <div class=\"container d-flex align-items-center justify-content-lg-between\">\n" +
"\n" +
"      <h1 class=\"logo me-auto me-lg-0\"><a href=\"index.html\">VOMS<span>.</span></a></h1>\n" +
"      <!-- Uncomment below if you prefer to use an image logo -->\n" +
"      <!-- <a href=\"index.html\" class=\"logo me-auto me-lg-0\"><img src=\"assets/img/logo.png\" alt=\"\" class=\"img-fluid\"></a>-->\n" +
"\n" +
"      <nav id=\"navbar\" class=\"navbar order-last order-lg-0\">\n" +
"        <ul>\n" +
"          <li><a class=\"nav-link scrollto active\" href=\"admin_index.html\">Home</a></li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"#about\">About</a></li>\n" +
"          <li class=\"dropdown\"><a href=\"#\"><span>Services</span> <i class=\"bi bi-chevron-down\"></i></a>\n" +
"            <ul>\n" +
"              <li><a href=\"addgvw.html\">Add GVW</a></li>\n" +
"              <li><a href=\"update\">Update GVW</a></li>\n" +
"              <li><a href=\"ocheck\">OverLoading Check</a></li>\n" +
"              <li><a href=\"addworker.html\">Add Worker</a></li>\n" +
"            </ul>\n" +
"          </li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"#contact\">Contact</a></li>\n" +
"        </ul>\n" +
"        <i class=\"bi bi-list mobile-nav-toggle\"></i>\n" +
"      </nav><!-- .navbar -->\n" +
"\n" +
"      <a href=\"../logout\" class=\"get-started-btn scrollto\">Log out</a>\n" +
"\n" +
"    </div>\n" +
"  </header><!-- End Header -->\n" +
"\n" +
"  <!-- ======= Hero Section ======= -->\n" +
"  <section id=\"hero\" class=\"d-flex align-items-center justify-content-center\">\n" +
"    <div class=\"container\" data-aos=\"fade-up\">\n" +
"\n" +
"\n" +
"      <div class=\"row justify-content-center\" data-aos=\"fade-up\" data-aos-delay=\"150\">\n" +
"        <div class=\"col-xl-6 col-lg-8\">\n" +
"          <h1 id=\"vo\">Vehicle Overloading Monitoring System<span>.</span></h1>\n" +
"          <h2> \"Load it up, but don't overload!\".</h2>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"    </div>\n" +
"  </section><!-- End Hero -->\n" +
"\n" +
"  <main id=\"main\">\n" +
"\n" +
"    <!-- ======= About Section ======= -->\n" +
"      <div class=\"col-xl-6 col-lg-8\">\n" +
"             <h1 id=\"voh\">Welcome to update Vehicle GVW Portal<span>.</span></h1>\n" +
"             </div>\n" +
"             <div class=\"inner\">\n" +
"              <div class=\"image-holder\">\n" +
"                <img src=\"assets/img/update3.jpg\" alt=\"\">\n" +
"              </div>\n" +
"              <form action=\"update2\">\n" +
"                <h3 style=\"color: #70873c;\">Update Vehicle GVW Here</h3>\n" +
"               \n" +
"                <div class=\"form-wrapper\">\n" +
"                  <label for=\"v0\">Choose Vehicle: </label>");
            out.println("<select name='vehicle' id='v0' style='margin-bottom:70px;'>");
             try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/div1","root","");
                Statement stmnt = con.createStatement();
                 ResultSet rs;
                rs = stmnt.executeQuery("SELECT `vehicle` FROM `vehicle_data`");
                while(rs.next()){
                 out.print("<option value='"+rs.getString(1)+"'>'"+rs.getString(1)+"'");
             }
                out.println("</select>");
                   con.close();
            }catch(Exception e){
           e.printStackTrace();
           out.println(e.getStackTrace());
            }
           out.println("</div>\n" +
"                <div class=\"form-wrapper\">\n" +
"                  <label for=\"v\">Vehicle Updated Weight : </label>\n" +
"                  <input type=\"number\" placeholder=\"KG\" class=\"form-control\" name=\"updateweight\">\n" +
"                </div>\n" +
"                <button>ADD\n" +
"                  <i class=\"zmdi zmdi-arrow-right\"></i>\n" +
"                </button>\n" +
"              </form>\n" +
"            </div>\n" +
"\n" +
"    <!-- ======= Services Section ======= -->\n" +
"    <section id=\"services\" class=\"services\">\n" +
"      <div class=\"container\" data-aos=\"fade-up\">\n" +
"\n" +
"        <div class=\"section-title\">\n" +
"          <h2>Services</h2>\n" +
"          <p>Check our Services</p>\n" +
"        </div>\n" +
"\n" +
"        <div class=\"row\">\n" +
"          <div id=\"add\" class=\"col-lg-4 col-md-6 d-flex align-items-stretch\" data-aos=\"zoom-in\" data-aos-delay=\"100\">\n" +
"            <div class=\"icon-box\">\n" +
"              <div class=\"icon\"><i class=\"bi bi-journal-plus\"></i></div>\n" +
"              <h4><a  href=\"addgvw.html\">Add Vehicle GVW</a></h4>\n" +
"              <p>Add New Vehicle GVW ( Gross Vehicle Weight )</p>\n" +
"           \n" +
"              </div>\n" +
"          </div>\n" +
"\n" +
"          <div id=\"help\" class=\"col-lg-4 col-md-6 d-flex align-items-stretch mt-4 mt-lg-0\" data-aos=\"zoom-in\" data-aos-delay=\"300\">\n" +
"            <div class=\"icon-box\">\n" +
"              <div class=\"icon\"><i class=\"bi bi-person-raised-hand\"></i></div>\n" +
"              <h4><a  href=\"addworker.html\">Add Worker</a></h4>\n" +
"              <p>Here You Can Add Newly Appointed Workers .</p>\n" +
"               </div>\n" +
"          </div>\n" +
"\n" +
"          <div id=\"update\" class=\"col-lg-4 col-md-6 d-flex align-items-stretch mt-4\" data-aos=\"zoom-in\" data-aos-delay=\"100\">\n" +
"            <div class=\"icon-box\">\n" +
"              <div class=\"icon\"><i class=\"bi bi-journal-richtext\"></i></div>\n" +
"              <h4><a href=\"update\">Update Vehicle GVW</a></h4>\n" +
"              <p>Update Existing Vehicle GVW ( Gross Vehicle Weight )</p>\n" +
"            </div>\n" +
"          </div>\n" +
"\n" +
"          <div id=\"overloading\" class=\"col-lg-4 col-md-6 d-flex align-items-stretch mt-4\" data-aos=\"zoom-in\" data-aos-delay=\"300\">\n" +
"            <div class=\"icon-box\">\n" +
"              <div class=\"icon\"><i class=\"bi bi-truck\"></i></div>\n" +
"              <h4><a href=\"ocheck\">Overloading Check</a></h4>\n" +
"              <p>Check Whether the Vehicle data provided to him is Overloaded or not.</p>\n" +
"            </div>\n" +
"          </div>\n" +
"\n" +
"        </div>\n" +
"\n" +
"      </div>\n" +
"    </section>\n" +
"    <!-- End Services Section -->\n" +
"\n" +
"    <!-- ======= Contact Section ======= -->\n" +
"    <section id=\"contact\" class=\"contact\">\n" +
"      <div class=\"container\" data-aos=\"fade-up\">\n" +
"\n" +
"        <div class=\"section-title\">\n" +
"          <h2>Contact</h2>\n" +
"          <p>Contact Us</p>\n" +
"        </div>\n" +
"\n" +
"        <div>\n" +
"          <iframe style=\"border:0; width: 100%; height: 270px;\" src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3443.3561108088566!2d77.9543886!3d30.3408277!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3908d5612204efb7%3A0x5eef311e57b07271!2sUttaranchal%20University!5e0!3m2!1sen!2sin!4v1698868020932!5m2!1sen!2sin\"frameborder=\"0\" allowfullscreen></iframe>\n" +
"        </div>\n" +
"        <div class=\"row mt-5\">\n" +
"\n" +
"          <div class=\"col-lg-4\">\n" +
"            <div class=\"info\">\n" +
"              <div class=\"address\">\n" +
"                <i class=\"bi bi-geo-alt\"></i>\n" +
"                <h4>Location:</h4>\n" +
"                <p>Prem Nagar, Dehradun</p>\n" +
"              </div>\n" +
"\n" +
"              <div class=\"email\">\n" +
"                <i class=\"bi bi-envelope\"></i>\n" +
"                <h4>Email:</h4>\n" +
"                <p>divyanshu@gmail.com</p>\n" +
"              </div>\n" +
"\n" +
"              <div class=\"phone\">\n" +
"                <i class=\"bi bi-phone\"></i>\n" +
"                <h4>Call:</h4>\n" +
"                <p>+91 99999 99999</p>\n" +
"              </div>\n" +
"\n" +
"            </div>\n" +
"\n" +
"          </div>\n" +
"\n" +
"          <div class=\"col-lg-8 mt-5 mt-lg-0\">\n" +
"\n" +
"            <form action=\"forms/contact.php\" method=\"post\" role=\"form\" class=\"php-email-form\">\n" +
"              <div class=\"row\">\n" +
"                <div class=\"col-md-6 form-group\">\n" +
"                  <input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Your Name\" required>\n" +
"                </div>\n" +
"                <div class=\"col-md-6 form-group mt-3 mt-md-0\">\n" +
"                  <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Your Email\" required>\n" +
"                </div>\n" +
"              </div>\n" +
"              <div class=\"form-group mt-3\">\n" +
"                <input type=\"text\" class=\"form-control\" name=\"subject\" id=\"subject\" placeholder=\"Subject\" required>\n" +
"              </div>\n" +
"              <div class=\"form-group mt-3\">\n" +
"                <textarea class=\"form-control\" name=\"message\" rows=\"5\" placeholder=\"Message\" required></textarea>\n" +
"              </div>\n" +
"              <div class=\"my-3\">\n" +
"                <div class=\"loading\">Loading</div>\n" +
"                <div class=\"error-message\"></div>\n" +
"                <div class=\"sent-message\">Your message has been sent. Thank you!</div>\n" +
"              </div>\n" +
"              <div class=\"text-center\"><button type=\"submit\">Send Message</button></div>\n" +
"            </form>\n" +
"\n" +
"          </div>\n" +
"\n" +
"        </div>\n" +
"\n" +
"      </div>\n" +
"    </section><!-- End Contact Section -->\n" +
"\n" +
"  </main><!-- End #main -->\n" +
"\n" +
"  <!-- ======= Footer ======= -->\n" +
"  <footer id=\"footer\">\n" +
"    <div class=\"footer-top\">\n" +
"      <div class=\"container\">\n" +
"        <div class=\"row\">\n" +
"\n" +
"          <div class=\"col-lg-3 col-md-6\">\n" +
"            <div class=\"footer-info\">\n" +
"              <h3>VOCS<span>.</span></h3>\n" +
"              <p>\n" +
"                Prem Nagar, <br>\n" +
"                Dehradun<br><br>\n" +
"                <strong>Phone:</strong> +91 99999 99999<br>\n" +
"                <strong>Email:</strong> divyanshu@gamil.com<br>\n" +
"              </p>\n" +
"              <div class=\"social-links mt-3\">\n" +
"                <a href=\"#\" class=\"twitter\"><i class=\"bx bxl-twitter\"></i></a>\n" +
"                <a href=\"#\" class=\"facebook\"><i class=\"bx bxl-facebook\"></i></a>\n" +
"                <a href=\"#\" class=\"instagram\"><i class=\"bx bxl-instagram\"></i></a>\n" +
"                <a href=\"#\" class=\"google-plus\"><i class=\"bx bxl-skype\"></i></a>\n" +
"                <a href=\"#\" class=\"linkedin\"><i class=\"bx bxl-linkedin\"></i></a>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>\n" +
"\n" +
"          <div class=\"col-lg-2 col-md-6 footer-links\">\n" +
"            <h4>Useful Links</h4>\n" +
"            <ul>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Home</a></li>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">About us</a></li>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Services</a></li>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Terms of service</a></li>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Privacy policy</a></li>\n" +
"            </ul>\n" +
"          </div>\n" +
"\n" +
"          <div class=\"col-lg-3 col-md-6 footer-links\">\n" +
"            <h4>Our Services</h4>\n" +
"            <ul>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Manual Overloading Check</a></li>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">View Vehicle GVW</a></li>\n" +
"              <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Enlighten Us</a></li>\n" +
"            </ul>\n" +
"          </div>\n" +
"\n" +
"          <div class=\"col-lg-4 col-md-6 footer-newsletter\">\n" +
"            <h4>Our Newsletter</h4>\n" +
"            <form action=\"\" method=\"post\">\n" +
"              <input type=\"email\" name=\"email\"><input type=\"submit\" value=\"Subscribe\">\n" +
"            </form>\n" +
"\n" +
"          </div>\n" +
"\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>\n" +
"\n" +
"    <div class=\"container\">\n" +
"      <div class=\"copyright\">\n" +
"        &copy; Copyright <strong><span>VOCS</span></strong>. All Rights Reserved\n" +
"      </div>\n" +
"      <div class=\"credits\">\n" +
"        <!-- All the links in the footer should remain intact. -->\n" +
"        <!-- You can delete the links only if you purchased the pro version. -->\n" +
"        <!-- Licensing information: https://bootstrapmade.com/license/ -->\n" +
"        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/gp-free-multipurpose-html-bootstrap-template/ -->\n" +
"        Designed by <a href=\"https://bootstrapmade.com/\">Divyanshu Kapoor</a>\n" +
"      </div>\n" +
"    </div>\n" +
"  </footer><!-- End Footer -->\n" +
"\n" +
"  <div id=\"preloader\"></div>\n" +
"  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\n" +
"\n" +
"  <!-- Vendor JS Files -->\n" +
"  <script src=\"assets/vendor/purecounter/purecounter_vanilla.js\"></script>\n" +
"  <script src=\"assets/vendor/aos/aos.js\"></script>\n" +
"  <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n" +
"  <script src=\"assets/vendor/glightbox/js/glightbox.min.js\"></script>\n" +
"  <script src=\"assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\n" +
"  <script src=\"assets/vendor/swiper/swiper-bundle.min.js\"></script>\n" +
"  <script src=\"assets/vendor/php-email-form/validate.js\"></script>\n" +
"\n" +
"  <!-- Template Main JS File -->\n" +
"  <script src=\"assets/js/main.js\"></script>\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
