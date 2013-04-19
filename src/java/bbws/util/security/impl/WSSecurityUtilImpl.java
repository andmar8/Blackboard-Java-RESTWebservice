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

package bbws.util.security.impl;

//bbws
import bbws.util.security.DefaultWSSecurity;
import bbws.util.security.oauth.OAuth;
import bbws.util.security.properties.WebServiceProperties;

//java
import java.net.URI;
import java.util.Map;

//javax
//import javax.ws.rs.core.Response;
//import javax.ws.rs.WebApplicationException;

public class WSSecurityUtilImpl extends DefaultWSSecurity
{
    private WSSecurityUtilImpl(){}
    public WSSecurityUtilImpl(long timeout,String vendorId,String applicationHandle)
    {
        this.oauthRequestTimeout = timeout;
        this.wsp = new WebServiceProperties(vendorId,applicationHandle);
    }

    public void authnAndAuthzRequest(URI baseuri,String auth,String methodName,String requestMethod,String resource) throws Exception
    {
        String methodAccessGroup = "";
        if(auth!=null&&!auth.matches("")) //auth is either a magkey or oauth header string
        {
            Map<String,String> oAuthParams = ProviderImpl.getOAuthParams(auth);
            String consumer_key = "";
            String consumer_secret = "";
            try
            {
                consumer_key = oAuthParams.get(OAuth.consumer_key_url_key);
                consumer_secret = wsp.getMAGKeyForMAG(consumer_key);
            }
            catch(Exception e)
            {
                System.err.println("Access Denied: "+resource);
                throw new Exception("Access Denied");
            }
            authenticateRequest(new ProviderImpl(oauthRequestTimeout,baseuri.toString(),auth,consumer_secret),requestMethod,resource);
            methodAccessGroup = consumer_key;
        }
        else
        {
            throw new Exception("UNAUTHORISED");
        }
        authoriseMethodUse(usingSSL(baseuri),methodAccessGroup,methodName);
    }
}
