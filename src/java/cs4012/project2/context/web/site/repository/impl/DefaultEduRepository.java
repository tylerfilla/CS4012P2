/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.Edu;
import cs4012.project2.context.web.site.repository.EduRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultEduRepository implements EduRepository {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private Connection mConnection;

    @Override
    public <S extends Edu> S save(S edu) {
        log.debug("Saving edu: " + edu.getId());

        if (existsById(edu.getId())) {
            throw new RuntimeException("Not implemented!");
        } else {
            try (PreparedStatement st = mConnection.prepareStatement("INSERT INTO `edu` (`user`, `institution`, `degree_type`, `degree_discipline`, `year`) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                // Insert education data
                st.setLong(1, edu.getUser());
                st.setString(2, edu.getInstitution());
                st.setString(3, edu.getDegreeType());
                st.setString(4, edu.getDegreeDiscipline());
                st.setLong(5, edu.getYear());
                st.executeUpdate();

                // Fetch auto-generated ID
                ResultSet results = st.getGeneratedKeys();
                if (results.next()) {
                    edu.setId(results.getInt(1));
                }

                return edu;
            } catch (SQLException e) {
                log.error("Could not save new user", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public <S extends Edu> Iterable<S> saveAll(Iterable<S> edus) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Optional<Edu> findById(Long id) {
        try (PreparedStatement st = mConnection.prepareStatement("SELECT * FROM `edu` WHERE `id` = ?")) {
            st.setLong(1, id);

            if (st.execute()) {
                ResultSet results = st.getResultSet();

                if (results.next()) {
                    Edu edu = new Edu();
                    edu.setId(results.getLong("id"));
                    edu.setUser(results.getLong("user"));
                    edu.setInstitution(results.getString("institution"));
                    edu.setDegreeType(results.getString("degree_type"));
                    edu.setDegreeDiscipline(results.getString("degree_discipline"));
                    edu.setYear(results.getInt("year"));
                    return Optional.of(edu);
                }
            }
        } catch (SQLException e) {
            log.error("Could not find edu by ID", e);
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        try (PreparedStatement st = mConnection.prepareStatement("SELECT `id` FROM `edu` WHERE `id` = ?")) {
            st.setLong(1, id);
            return st.executeQuery().next();
        } catch (SQLException e) {
            log.error("Could not check for existence by ID", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Edu> findAll() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Iterable<Edu> findAllById(Iterable<Long> ids) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public long count() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteById(Long id) {
        try (PreparedStatement st = mConnection.prepareStatement("DELETE FROM `edu` WHERE `id` = ?")) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error("Could not delete edu by ID", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Edu entity) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll(Iterable<? extends Edu> edus) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public List<Long> findByUser(long userId) {
        List<Long> edus = new ArrayList<>();

        try (PreparedStatement st = mConnection.prepareStatement("SELECT `id` FROM `edu` WHERE `user` = ?")) {
            st.setLong(1, userId);

            ResultSet results = st.executeQuery();
            while (results.next()) {
                edus.add(results.getLong(1));
            }
        } catch (SQLException e) {
            log.error("Could not find edu by user ID", e);
            throw new RuntimeException(e);
        }

        return edus;
    }

}
