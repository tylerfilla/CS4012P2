/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.*;
import java.util.Optional;

@Repository
public class DefaultUserRepository implements UserRepository {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private Connection mConnection;

    @Override
    public <S extends User> S save(S user) {
        log.debug("Saving user: " + user.getUsername());

        if (existsById(user.getId())) {
            try {
                PreparedStatement st = mConnection.prepareStatement("UPDATE `user` SET `username` = ?, `password` = ?, `fname` = ?, `lname` = ?, `addr_body` = ?, `addr_city` = ?, `addr_state` = ?, `addr_zip` = ?, `birthday` = ?, `phone_home` = ?, `phone_cell` = ?, `time_zone` = ?, `profile_image` = ? WHERE `id` = ?");
                st.setString(1, user.getUsername());
                st.setString(2, user.getPassword());
                st.setString(3, user.getFname());
                st.setString(4, user.getLname());
                st.setString(5, user.getAddrBody());
                st.setString(6, user.getAddrCity());
                st.setString(7, user.getAddrState());
                st.setString(8, user.getAddrZip());
                st.setDate(9, user.getBirthday());
                st.setString(10, user.getPhoneHome());
                st.setString(11, user.getPhoneCell());
                st.setString(12, user.getTimeZone());
                st.setBlob(13, user.getProfileImage());
                st.setLong(14, user.getId());
                st.executeUpdate();

                return user;
            } catch (SQLException e) {
                log.error("Could not save existing user", e);
                throw new RuntimeException(e);
            }
        } else {
            try {
                // Insert user data
                PreparedStatement st = mConnection.prepareStatement("INSERT INTO `user` (username, password, fname, lname, addr_body, addr_city, addr_state, addr_zip, birthday, phone_home, phone_cell, time_zone, profile_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                st.setString(1, user.getUsername());
                st.setString(2, user.getPassword());
                st.setString(3, user.getFname());
                st.setString(4, user.getLname());
                st.setString(5, user.getAddrBody());
                st.setString(6, user.getAddrCity());
                st.setString(7, user.getAddrState());
                st.setString(8, user.getAddrZip());
                st.setDate(9, user.getBirthday());
                st.setString(10, user.getPhoneHome());
                st.setString(11, user.getPhoneCell());
                st.setString(12, user.getTimeZone());
                st.setBlob(13, user.getProfileImage());
                st.executeUpdate();

                // Fetch auto-generated ID
                ResultSet results = st.getGeneratedKeys();
                if (results.next()) {
                    user.setId(results.getInt(1));
                }

                return user;
            } catch (SQLException e) {
                log.error("Could not save new user", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> users) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Optional<User> findById(Long id) {
        log.debug("Find user by ID: " + id);

        try {
            PreparedStatement st = mConnection.prepareStatement("SELECT id, username, password, fname, lname, addr_body, addr_city, addr_state, addr_zip, birthday, phone_home, phone_cell, time_zone, profile_image FROM `user` WHERE `id` = ?");
            st.setLong(1, id);
            return Optional.ofNullable(fetchUser(st.executeQuery()));
        } catch (SQLException e) {
            log.error("Could not find ID", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Long id) {
        try {
            PreparedStatement st = mConnection.prepareStatement("SELECT `id` FROM `user` WHERE `id` = ?");
            st.setLong(1, id);
            return st.executeQuery().next();
        } catch (SQLException e) {
            log.error("Could not check for existence by ID", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<User> findAll() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public long count() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteById(Long id) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void delete(User entity) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll(Iterable<? extends User> users) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.debug("Find user by username: " + username);

        try {
            PreparedStatement st = mConnection.prepareStatement("SELECT id, username, password, fname, lname, addr_body, addr_city, addr_state, addr_zip, birthday, phone_home, phone_cell, time_zone, profile_image FROM `user` WHERE `username` = ?");
            st.setString(1, username);
            return Optional.ofNullable(fetchUser(st.executeQuery()));
        } catch (SQLException e) {
            log.error("Could not find username", e);
            throw new RuntimeException(e);
        }
    }

    private User fetchUser(ResultSet results) throws SQLException {
        // If results exist
        if (results.next()) {
            // Build user object
            User user = new User();
            user.setId(results.getLong(1));
            user.setUsername(results.getString(2));
            user.setPassword(results.getString(3));
            user.setFname(results.getString(4));
            user.setLname(results.getString(5));
            user.setAddrBody(results.getString(6));
            user.setAddrCity(results.getString(7));
            user.setAddrState(results.getString(8));
            user.setAddrZip(results.getString(9));
            user.setBirthday(results.getDate(10));
            user.setPhoneHome(results.getString(11));
            user.setPhoneCell(results.getString(12));
            user.setTimeZone(results.getString(13));
            user.setProfileImage(results.getBlob(14));

            return user;
        }

        return null;
    }

}
