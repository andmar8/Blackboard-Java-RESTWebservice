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
import bbws.entity.enums.verbosity.BBCourseVerbosity;
import bbws.resource.course.BBCourse;
import bbws.resource.course.collection.BBCourses;
import bbws.util.helper.CourseHelper;
import bbws.util.security.impl.WSSecurityUtilImpl;
import bbws.util.Util;

//jax-rs
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

//rest
import rest.resources.BasicResource;

@Path("courses")
@Produces("application/xml")
public class CoursesResource extends BasicResource
{
    public CoursesResource()
    {
        this.resource = "courses";
    }

    @GET
    public BBCourses getCourses(@Context UriInfo uriInfo, @HeaderParam("Authorization") String authHeader,@QueryParam("search") String search) throws WebApplicationException
    {
        doSecurity(uriInfo.getBaseUri(),authHeader,Util.getMethodName(),"GET");
        return new BBCourses(CourseHelper.courseReadAll(BBCourseVerbosity.extended));
    }

//    @GET
//    @Path("courses/byX")
//    public BBCourses getCoursesByX()
//    {
//        return new BBCourses();
//    }

    @Path("{course}/")
    public CourseResource getCourse(@Context UriInfo uriInfo,/*@PathParam("user") String user,*/@HeaderParam("Authorization") String authHeader) throws WebApplicationException
    {
        return new CourseResource();
    }

    @POST
    public Response postCourse(@Context UriInfo uriInfo, @HeaderParam("Authorization") String authHeader,BBCourse course) throws WebApplicationException
    {
        doSecurity(uriInfo.getBaseUri(),authHeader,Util.getMethodName(),"POST");
        try{if(CourseHelper.courseCreate(course)){return Response.ok().build();}}catch(Exception e){e.printStackTrace();}
        return Response.serverError().build();
    }
}
