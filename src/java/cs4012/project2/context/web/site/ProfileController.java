/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("profile")
public class ProfileController {

    private static final Logger log = LogManager.getLogger();

    @GetMapping
    public String get(HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        // TODO: Set up model

        return "profile";
    }

}
