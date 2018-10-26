/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import cs4012.project2.context.web.site.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private AuthService mAuthService;

    @GetMapping
    public String get(Model model, HttpSession session) {
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
        doLogin(user, session);

        // Redirect to index
        return "redirect:/";
    }

    /**
     * Carry out the login process.
     *
     * @param user    The user details
     * @param session The HTTP session
     */
    private void doLogin(User user, HttpSession session) {
        log.debug("Logging in user: " + user.getUsername());

        // TODO: Perform login
        mAuthService.logInUser();
        session.setAttribute("user", "asdf");
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
