/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service;

public interface AuthService {

    long checkUser(String username, String password);

    void register(String username, String password, String firstName, String lastName, String addrBody, String addrCity, String addrState, String addrZip);

}
