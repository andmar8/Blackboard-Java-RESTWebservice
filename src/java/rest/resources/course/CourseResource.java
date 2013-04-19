/*
    Blackboard REST WebService
    Copyright (C) 2009-2013 Andrew Martin, Newcastle University

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package rest.resources.course;

//bbws
import bbws.resource.course.BBCourse;

//javax
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

//jersey
import com.sun.jersey.api.NotFoundException;

@Path("courses/{course}")
@Produces("application/xml")
public class CourseResource
{
//    private User user; // <- Use Path param???

//    public UserResource(User user)
//    {
//        try
//        {
//            System.out.println("attempting to create resource for "+user.getId());
//            this.user = user;
//        }
//        catch(Exception e)
//        {
//            System.out.println("Could not generate Id for user: "+user);
//            this.user = null;
//        }
//    }

    @DELETE
    public void deleteCourse(@Context UriInfo uriInfo,@PathParam("course") String course)
    {
        System.out.println("DELETE USER "+course);
    }

    @GET
    public BBCourse getCourse(@Context UriInfo uriInfo,@PathParam("course") String course)
    {
        System.out.println("GET COURSE "+course);
//        if(new Provider(60,uriInfo.getAbsolutePath().toString()).validateOAuthDetailsFromQueryString("GET","",uriInfo.getQueryParameters()))
//        {
//            return this.user;
//        }
//        else
//        {
//            throw new javax.ws.rs.WebApplicationException(Response.Status.UNAUTHORIZED);
//        }
        return new BBCourse();
    }
}

