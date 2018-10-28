package cs4012.project2.context.web.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("error")
public class ErrorController {

    @GetMapping
    public String get(Model model, HttpServletRequest request) {
        // Get error code
        int code = (Integer) request.getAttribute("javax.servlet.error.status_code");

        // Store error code in model
        model.addAttribute("code", code);

        return "error";
    }

}
