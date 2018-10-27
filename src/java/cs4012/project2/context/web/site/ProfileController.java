/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
@RequestMapping("profile")
public class ProfileController {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private UserService mUserService;

    @GetMapping
    public String get(Model model, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        // Add user entity to model
        model.addAttribute("user", mUserService.getUser((long) session.getAttribute("user")));

        return "profile";
    }

    @PostMapping("/basicInfo")
    public String postBasic(@RequestParam String fname, @RequestParam String lname, @RequestParam String birthday, @RequestParam String timeZone, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        log.debug("Got basic info: " + fname + ", " + lname + ", " + birthday + ", " + timeZone);

        // Update basic info
        User user = mUserService.getUser((long) session.getAttribute("user"));
        user.setFname(fname);
        user.setLname(lname);
        user.setBirthday(Date.valueOf(birthday)); // TODO: Make this more user friendly
        user.setTimeZone(timeZone);
        mUserService.updateUser(user);

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/profileImage")
    public String postProfileImage(@RequestParam MultipartFile image) {
        log.debug("Got profile image: " + image.getOriginalFilename());

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/password")
    public String postPassword(@RequestParam String password) {
        log.debug("Got password of size " + password.length());

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/contactInfo")
    public String postContact(@RequestParam String addrBody, @RequestParam String addrCity, @RequestParam String addrState, @RequestParam String addrZip, @RequestParam String phoneHome, @RequestParam String phoneCell) {
        log.debug("Got contact info: " + addrBody + ", " + addrCity + ", " + addrState + ", " + addrZip + ", " + phoneHome + ", " + phoneCell);

        // Redirect to profile
        return "redirect:/profile";
    }

}
