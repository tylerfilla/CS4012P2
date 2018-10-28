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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultEduRepository implements EduRepository {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private Connection mConnection;

    @Override
    public <S extends Edu> S save(S entity) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public <S extends Edu> Iterable<S> saveAll(Iterable<S> entities) {
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
        throw new RuntimeException("Not implemented!");
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
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void delete(Edu entity) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll(Iterable<? extends Edu> entities) {
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
