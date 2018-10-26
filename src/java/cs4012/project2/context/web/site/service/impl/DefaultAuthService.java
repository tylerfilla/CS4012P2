/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service.impl;

import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.repository.UserRepository;
import cs4012.project2.context.web.site.service.AuthService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Service
public class DefaultAuthService implements AuthService {

    @Inject
    @Named("defaultUserRepository")
    private UserRepository mUserRepository;

    @Override
    public long checkUser(String username, String password) {
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
    public void register(String username, String password, String firstName, String lastName, String addrBody, String addrCity, String addrState, String addrZip) {
    }

}
