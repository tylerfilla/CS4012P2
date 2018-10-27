/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service;

import cs4012.project2.context.web.site.entity.User;

public interface UserService {

    User getUser(long userId);

    User updateUser(User user);

}
