/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebContextConfiguration {

    private static final Logger log = LogManager.getLogger();

    /**
     * The prefix for view resolution.
     */
    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/view/";

    /**
     * The suffix for view resolution.
     */
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    /**
     * The path for database connection.
     */
    private static final String DB_PATH = "jdbc:mysql://localhost:3306/enterprise";

    /**
     * The username for database connection.
     * TODO: Set to "root" before submit
     */
    private static final String DB_USERNAME = "mysql";

    /**
     * The password for database connection.
     * TODO: Set to "" before submit
     */
    private static final String DB_PASSWORD = "password";

    @Bean
    public ViewResolver viewResolver() {
        log.trace("viewResolver");

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix(VIEW_RESOLVER_PREFIX);
        resolver.setSuffix(VIEW_RESOLVER_SUFFIX);
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        log.trace("multipartResolver");

        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(4 * 1024 * 1024);
        return resolver;
    }

    @Bean
    public Connection dbConnection() {
        log.trace("dbConnection");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Unable to probe database driver", e);
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(DB_PATH, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            log.error("Unable to connect to database", e);
            throw new RuntimeException(e);
        }
    }

}
