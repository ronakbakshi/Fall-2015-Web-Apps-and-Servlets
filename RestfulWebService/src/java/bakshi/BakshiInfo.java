/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakshi;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Ronak Bakshi
 */
@Path("bakshi")
public class BakshiInfo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BakshiInfo
     */
    public BakshiInfo() {
    }

    /**
     * Retrieves representation of an instance of bakshi.BakshiInfo
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html>\n"
                + " <head>\n"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"..\\Bakshi.css\">\n"
                + " <title>Details</title>\n"
                + " <meta charset=\"UTF-8\">\n"
                + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "</head>\n"
                + " <body>\n"
                + "  <div id=\"name\">  Ronak Bakshi\n"
                + " <img src=\"..\\Images\\RonakDP.jpeg\" alt=\"Ronak\" id=\"image\"/>\n"
                + "  </div>\n"
                + "<div id=\"place\"> Vizag, India </div>\n"
                + "<table>\n"
                + " <tr>\n"
                + "<th> Degree Obtained  </th>\n"
                + "<th> Name of the Institution  </th>\n"
                + "<th> Year Obtained </th>\n"
                + "</tr>\n"
                + " <tr>\n"
                + " <td>       MS     </td>\n"
                + " <td>   Northwest Missouri State University  </td>\n"
                + " <td>          2016(expecting)       </td>\n"
                + "</tr>"
                + " <tr>"
                + " <td>        B.Tech       </td>\n"
                + " <td>     GITAM Institute of Technology and Science        </td>\n"
                + " <td>                    2013                </td>\n"
                + "</tr>"
                + " <tr>\n"
                + "<td>    ICSE        </td>\n"
                + "<td>    Siva Sivani Public School        </td>\n"
                + "<td>    2009            </td>\n"
                + "</tr>\n"
                + "</table>\n"
                + "<div>\n"
                + "<p id=\"why\">\n"
                + " I choose Northwest Missouri State University because it offers a program called Applied Computer Science at a reasonable price. Currently, Northwest has about 6,800 students; with a student-to-faculty ratio of 22-to-1. The size of campus offers great opportunities for students to succeed academically and socially. Northwest offers more than 127 undergraduate majors and 73 minors.\n"
                + "</p>\n"
                + " </div>\n"
                + "<div>\n"
                + " <a href=\"https://www.irctc.co.in/eticketing/loginHome.jsf\">A poor website - IRCTC Web page</a>\n"
                + "</div>\n"
                + " </body>\n"
                + "</html>";

    }

    /**
     * PUT method for updating or creating an instance of BakshiInfo
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
