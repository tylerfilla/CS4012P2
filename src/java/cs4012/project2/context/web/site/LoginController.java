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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    private static final Logger log = LogManager.getLogger();

    @GetMapping
    public String get(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String post(@ModelAttribute User user, HttpSession session) {
        // TODO: Check username and password

        // TODO: Place user ID in session scope
        session.setAttribute("user", 0);

        return "redirect:/";
    }

    /**
     * A user object.
     */
    public static class User {

        /**
         * The user username.
         */
        private String mUsername;

        /**
         * The user password.
         */
        private String mPassword;

        public User() {
            mUsername = "";
            mPassword = "";
        }

        /**
         * @return The user username
         */
        public String getUsername() {
            return mUsername;
        }

        /**
         * @param pUsername The user username
         */
        public void setUsername(String pUsername) {
            mUsername = pUsername;
        }

        /**
         * @return The user password
         */
        public String getPassword() {
            return mPassword;
        }

        /**
         * @param pPassword The user password
         */
        public void setPassword(String pPassword) {
            mPassword = pPassword;
        }

    }

}
