/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private static final Logger log = LogManager.getLogger();

    @GetMapping
    public String get() {
        return "redirect:/profile";
    }

}
