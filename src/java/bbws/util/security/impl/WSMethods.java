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

import rest.resources.course.CoursesResource;

//java
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WSMethods
{
    static private final List<Class> resources = Arrays.asList(new Class[]{CoursesResource.class});

    static public List<String> getWSMethods()
    {
        List<String> webMethodl = new ArrayList<String>();
        Iterator<Class> ri = resources.iterator();
        while(ri.hasNext())
        {
            Iterator<Method> mi = Arrays.asList(ri.next().getDeclaredMethods()).iterator();
            Iterator<Annotation> ai;
            Method m;
            String a;
            while(mi.hasNext())
            {
                m = mi.next();
                ai = Arrays.asList(m.getDeclaredAnnotations()).iterator();
                while(ai.hasNext())
                {
                    a = ai.next().toString();
                    if(a.equalsIgnoreCase("@javax.ws.rs.delete()") || a.equalsIgnoreCase("@javax.ws.rs.get()")
                        || a.equalsIgnoreCase("@javax.ws.rs.post()") || a.equalsIgnoreCase("@javax.ws.rs.put()"))
                    {
                        webMethodl.add(m.getName());
                    }
                }
            }
        }
        return webMethodl;
    }
}
