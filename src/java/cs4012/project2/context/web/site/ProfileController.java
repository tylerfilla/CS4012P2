/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site;

import com.mysql.cj.jdbc.Blob;
import cs4012.project2.context.web.site.entity.Edu;
import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.entity.Work;
import cs4012.project2.context.web.site.service.EduService;
import cs4012.project2.context.web.site.service.UserService;
import cs4012.project2.context.web.site.service.WorkService;
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
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("profile")
public class ProfileController {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private EduService mEduService;

    @Inject
    private UserService mUserService;

    @Inject
    private WorkService mWorkService;

    @GetMapping
    public String get(@RequestParam(required = false) Long eduToDelete, @RequestParam(required = false) Long workToDelete, Model model, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        // Get user entity
        User user = mUserService.getUser((long) session.getAttribute("user"));

        // If user wants to delete an education history line
        if (eduToDelete != null) {
            mEduService.deleteEdu(eduToDelete);
            return "redirect:/profile?updated=edu";
        }

        // If user wants to delete a work history line
        if (workToDelete != null) {
            mWorkService.deleteWork(workToDelete);
            return "redirect:/profile?updated=work";
        }

        // Load profile image
        BufferedImage profileImage;
        try {
            profileImage = ImageIO.read(user.getProfileImage().getBinaryStream());
        } catch (Exception e) {
            log.error("Unable to read profile image", e);
            throw new RuntimeException(e);
        }

        // If a profile image exists
        if (profileImage != null) {
            // Create a scaled 256-width JPEG of the profile image
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

        // Get education elements
        List<Edu> edus = mEduService.getUserEdus(user.getId());
        model.addAttribute("edus", edus);

        // Get work elements
        List<Work> works = mWorkService.getUserWorks(user.getId());
        model.addAttribute("works", works);

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
        user.setBirthday(Date.valueOf(LocalDate.parse(birthday)));
        user.setTimeZone(timeZone);
        mUserService.updateUser(user);

        // Redirect to profile
        return "redirect:/profile?updated=basic";
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
        return "redirect:/profile?updated=image";
    }

    @PostMapping("/password")
    public String postPassword(@RequestParam String password, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        log.debug("Got password of size " + password.length());

        // Update password
        User user = mUserService.getUser((long) session.getAttribute("user"));
        user.setPassword(password);
        mUserService.updateUser(user);

        // Redirect to profile
        return "redirect:/profile?updated=password";
    }

    @PostMapping("/contactInfo")
    public String postContact(@RequestParam String addrBody, @RequestParam String addrCity, @RequestParam String addrState, @RequestParam String addrZip, @RequestParam String phoneHome, @RequestParam String phoneCell, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        log.debug("Got contact info: " + addrBody + ", " + addrCity + ", " + addrState + ", " + addrZip + ", " + phoneHome + ", " + phoneCell);

        // Update contact info
        User user = mUserService.getUser((long) session.getAttribute("user"));
        user.setAddrBody(addrBody);
        user.setAddrCity(addrCity);
        user.setAddrState(addrState);
        user.setAddrZip(addrZip);
        user.setPhoneHome(phoneHome);
        user.setPhoneCell(phoneCell);
        mUserService.updateUser(user);

        // Redirect to profile
        return "redirect:/profile?updated=contact";
    }

    @PostMapping("/edu")
    public String postEdu(@RequestParam String institution, @RequestParam String degreeType, @RequestParam String degreeDiscipline, @RequestParam int year, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        // Add education
        Edu edu = new Edu();
        edu.setUser((long) session.getAttribute("user"));
        edu.setInstitution(institution);
        edu.setDegreeType(degreeType);
        edu.setDegreeDiscipline(degreeDiscipline);
        edu.setYear(year);
        mEduService.updateEdu(edu);

        // Redirect to profile
        return "redirect:/profile?updated=edu";
    }

    @PostMapping("/work")
    public String postWork(@RequestParam String company, @RequestParam String title, @RequestParam int years, HttpSession session) {
        // If not logged in, redirect to login page
        if (session.getAttribute("user") == null) {
            log.debug("Not logged in, redirect to login page");
            return "redirect:/login";
        }

        // Add work
        Work work = new Work();
        work.setUser((long) session.getAttribute("user"));
        work.setCompany(company);
        work.setTitle(title);
        work.setYears(years);
        mWorkService.updateWork(work);

        // Redirect to profile
        return "redirect:/profile?updated=work";
    }

}
