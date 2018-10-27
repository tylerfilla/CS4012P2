/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("profile")
public class ProfileController {

    private static final Logger log = LogManager.getLogger();

    @GetMapping
    public String get(Model model, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        return "profile";
    }

    @PostMapping("/basic")
    public String postBasic(@RequestParam String fname, @RequestParam String lname, @RequestParam String birthday, @RequestParam String timeZone) {
        log.debug("got a post: " + fname + ", " + lname + ", " + birthday + ", " + timeZone);

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/profileImage")
    public String postProfileImage(@RequestParam MultipartFile image) {
        log.debug("got a post: " + image.getOriginalFilename());

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/password")
    public String postPassword(@RequestParam String password) {
        log.debug("got a post: " + password);

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/contact")
    public String postContact(@RequestParam String addrBody, @RequestParam String addrCity, @RequestParam String addrState, @RequestParam String addrZip, @RequestParam String phoneHome, @RequestParam String phoneCell) {
        log.debug("got a post: " + addrBody + ", " + addrCity + ", " + addrState + ", " + addrZip + ", " + phoneHome + ", " + phoneCell);

        // Redirect to profile
        return "redirect:/profile";
    }

}
