/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2;

import cs4012.project2.context.root.RootContextConfiguration;
import cs4012.project2.context.web.WebContextConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * The application bootstrap class. If Spring is on the classpath, it statically
 * tells the servlet container to call anything that implements the interface
 * WebApplicationInitializer. As such, this class boots the application.
 */
public class Bootstrap implements WebApplicationInitializer {

    private static final Logger log = LogManager.getLogger();

    @Override
    public void onStartup(ServletContext container) {
        log.info("Booting application...");

        // Set up root context
        setUpRootContext(container);

        // Set up servlets and their contexts
        setUpWebServlet(container);

        log.info("Application booted");
    }

    /**
     * Set up the root context.
     */
    private void setUpRootContext(ServletContext container) {
        log.debug("Setting up root context...");

        // Create root context and register to it its config class
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(RootContextConfiguration.class);

        // Connect a bootstrap listener to the container with a reference to the newly-created root context
        // This allows Spring to start up and shut down the root context in tandem with the servlet container
        container.addListener(new ContextLoaderListener(context));

        log.debug("Root context set up");
    }

    /**
     * Set up the frontend Web servlet.
     */
    private void setUpWebServlet(ServletContext container) {
        log.debug("Setting up frontend Web servlet...");

        // Create Web context and register to it its config class
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebContextConfiguration.class);

        // Create Web servlet with HTTP dispatch and register it with the container
        ServletRegistration.Dynamic registration = container.addServlet("web", new DispatcherServlet(context));

        // Map the Web servlet to /
        registration.addMapping("/");

        log.debug("Web servlet set up");
    }

}
