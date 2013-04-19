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
package rest.resources;

//bbws
import bbws.util.security.WSSecurityUtil;
import bbws.util.security.impl.WSSecurityUtilImpl;

//java
import java.net.URI;

//javax
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

public abstract class BasicResource
{
    protected String resource = "";

    protected void doSecurity(URI baseuri,String authHeader,String methodName,String requestMethod) throws WebApplicationException
    {
        try
        {
            WSSecurityUtil wsSecurity = new WSSecurityUtilImpl(60,"amnl","BBCourseRestWebService");
            wsSecurity.authnAndAuthzRequest(baseuri,authHeader,methodName,requestMethod,this.resource);
        }
        catch(Exception e)
        {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
