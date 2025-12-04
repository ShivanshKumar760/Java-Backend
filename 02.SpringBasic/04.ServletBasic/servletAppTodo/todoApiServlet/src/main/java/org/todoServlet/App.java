package org.todoServlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.todoServlet.controller.TodoServlet;
import org.todoServlet.service.TodoService;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println( "Welcome to servlet!" );
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8080);

        // Tomcat 11+ requires explicit connector creation
        tomcat.getConnector();
        Context context = tomcat.addContext("", null);

        Tomcat.addServlet(context, "Todo", new TodoServlet(new TodoService()));

        context.addServletMappingDecoded("/todo", "Todo");

        tomcat.start();
        tomcat.getServer().await();
    }


1008417
}
