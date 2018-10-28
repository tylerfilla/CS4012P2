package cs4012.project2.context.web.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("error")
public class ErrorController {

    private static final Logger log = LogManager.getLogger();

    @RequestMapping
    public String request(Model model, HttpServletRequest request) {
        // Get error throwable
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        log.error("Serving error page", throwable);

        // Prepare model
        model.addAttribute("code", request.getAttribute("javax.servlet.error.status_code"));
        model.addAttribute("throwable", throwable);

        return "error";
    }

}
