/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service.impl;

import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.repository.UserRepository;
import cs4012.project2.context.web.site.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class DefaultAuthService implements AuthService {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private UserRepository mUserRepository;

    @Override
    public long checkUser(String username, String password) {
        log.debug("Check user: " + username);

        // Try to get user by username
        Optional<User> user = mUserRepository.findByUsername(username);

        // If a user with this username was found and their passwords match
        // This is for demonstration purposes only (not for any secure use)
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get().getId();
        }

        return -1;
    }

    @Override
    public long register(String username, String password, String fname, String lname, String addrBody, String addrCity, String addrState, String addrZip) {
        log.debug("Register user: " + username);

        // If username is taken
        if (mUserRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Build user object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFname(fname);
        user.setLname(lname);
        user.setAddrBody(addrBody);
        user.setAddrCity(addrCity);
        user.setAddrState(addrState);
        user.setAddrZip(addrZip);

        // Save the user
        user = mUserRepository.save(user);

        return user.getId();
    }

}
