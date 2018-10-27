/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service.impl;

import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.repository.UserRepository;
import cs4012.project2.context.web.site.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DefaultUserService implements UserService {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private UserRepository mUserRepository;

    @Override
    public User getUser(long userId) {
        return mUserRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return mUserRepository.save(user);
    }

}
