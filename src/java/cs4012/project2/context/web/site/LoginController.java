/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import cs4012.project2.context.web.site.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private AuthService mAuthService;

    @GetMapping
    public String get(@RequestParam(required = false) String logout, Model model, HttpSession session) {
        // If user wants to log out
        if (logout != null) {
            log.debug("Logging out user: " + session.getAttribute("user"));
            session.removeAttribute("user");
        }

        // If logged in, redirect to profile page
        if (session.getAttribute("user") != null) {
            log.debug("Logged in, redirect to profile page");
            return "redirect:/profile";
        }

        // Set up user attribute
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping
    public String post(@ModelAttribute User user, HttpSession session) {
        // Do the login
        if (doLogin(user, session)) {
            return "redirect:/";
        } else {
            return "redirect:/login?badcreds=1";
        }
    }

    /**
     * Carry out the login process.
     *
     * This is for demonstration purposes only (not for any secure use).
     *
     * @param user    The user details
     * @param session The HTTP session
     * @return Whether login succeeded
     */
    private boolean doLogin(User user, HttpSession session) {
        log.debug("Logging in user: " + user.getUsername());

        // Try to log the user in
        long id;
        if ((id = mAuthService.checkUser(user.getUsername(), user.getPassword())) >= 0) {
            log.debug("Login successful for user: " + user.getUsername());
            session.setAttribute("user", id);
            return true;
        } else {
            log.debug("Login failed for user: " + user.getUsername());
            session.removeAttribute("user");
            return false;
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static class User {

        private String mUsername;
        private String mPassword;

        public String getUsername() {
            return mUsername;
        }

        public void setUsername(String pUsername) {
            mUsername = pUsername;
        }

        public String getPassword() {
            return mPassword;
        }

        public void setPassword(String pPassword) {
            mPassword = pPassword;
        }

    }

}
