/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.jdbc.BlobFromLocator;
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

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Base64;

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

        // Get user entity
        User user = mUserService.getUser((long) session.getAttribute("user"));

        // Load profile image
        BufferedImage profileImage = null;
        try {
            profileImage = ImageIO.read(user.getProfileImage().getBinaryStream());
        } catch (IOException e) {
            log.error("Unable to read profile image (ImageIO)", e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            log.error("Unable to read profile image (Blob)", e);
            throw new RuntimeException(e);
        }

        // If a profile image exists
        if (profileImage != null) {
            // Re-encode original image to JPEG
            ByteArrayOutputStream outOrig = new ByteArrayOutputStream();
            BufferedImage profileImageOrig = new BufferedImage(profileImage.getWidth(), profileImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D gfxOrig = profileImageOrig.createGraphics();
            gfxOrig.drawImage(profileImage, 0, 0, profileImage.getWidth(), profileImage.getHeight(), null);
            try {
                ImageIO.write(profileImageOrig, "jpg", outOrig);
            } catch (IOException e) {
                log.error("Could not write re-encoded profile image", e);
                throw new RuntimeException(e);
            }
            byte[] bytesOrig = outOrig.toByteArray();

            log.debug("Re-encoded profile image to size " + bytesOrig.length);

            // Place Base64-encoded copy of profile image in model
            model.addAttribute("profileImageOrig", Base64.getEncoder().encodeToString(bytesOrig));

            // Create a scaled 256-width JPEG, too
            ByteArrayOutputStream outScaled = new ByteArrayOutputStream();
            int heightScaled = (int) (profileImage.getHeight() / (float) profileImage.getWidth() * 256);
            BufferedImage profileImage256w = new BufferedImage(256, heightScaled, BufferedImage.TYPE_INT_RGB);
            Graphics2D gfxScaled = profileImage256w.createGraphics();
            gfxScaled.drawImage(profileImage, 0, 0, 256, heightScaled, null);
            try {
                ImageIO.write(profileImage256w, "jpg", outScaled);
            } catch (IOException e) {
                log.error("Could not write scaled profile image", e);
                throw new RuntimeException(e);
            }
            byte[] bytesScaled = outScaled.toByteArray();

            log.debug("Scaled down profile image to size " + bytesScaled.length);

            // Place Base64-encoded copy of scaled profile image in model
            model.addAttribute("profileImageScaled", Base64.getEncoder().encodeToString(bytesScaled));
        }

        // Add user entity to model
        model.addAttribute("user", user);

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
        user.setBirthday(Date.valueOf(LocalDate.parse(birthday))); // TODO: Make this more user friendly
        user.setTimeZone(timeZone);
        mUserService.updateUser(user);

        // Redirect to profile
        return "redirect:/profile";
    }

    @PostMapping("/image")
    public String postImage(@RequestParam MultipartFile image, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        log.debug("Got image: " + image.getOriginalFilename());

        // Update image
        User user = mUserService.getUser((long) session.getAttribute("user"));
        try {
            user.setProfileImage(new Blob(image.getBytes(), null));
        } catch (IOException e) {
            log.error("Could not blob-ify uploaded profile image", e);
            throw new RuntimeException(e);
        }
        mUserService.updateUser(user);

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
