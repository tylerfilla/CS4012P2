/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.Edu;
import cs4012.project2.context.web.site.entity.Work;
import cs4012.project2.context.web.site.repository.WorkRepository;
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
public class DefaultWorkRepository implements WorkRepository {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private Connection mConnection;

    @Override
    public <S extends Work> S save(S entity) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public <S extends Work> Iterable<S> saveAll(Iterable<S> entities) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Optional<Work> findById(Long id) {
        try (PreparedStatement st = mConnection.prepareStatement("SELECT * FROM `work` WHERE `id` = ?")) {
            st.setLong(1, id);

            if (st.execute()) {
                ResultSet results = st.getResultSet();

                if (results.next()) {
                    Work work = new Work();
                    work.setId(results.getLong("id"));
                    work.setUser(results.getLong("user"));
                    work.setCompany(results.getString("company"));
                    work.setTitle(results.getString("title"));
                    work.setYears(results.getInt("years"));
                    return Optional.of(work);
                }
            }
        } catch (SQLException e) {
            log.error("Could not find work by ID", e);
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Iterable<Work> findAll() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public Iterable<Work> findAllById(Iterable<Long> ids) {
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
    public void delete(Work entity) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll(Iterable<? extends Work> entities) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public List<Long> findByUser(long userId) {
        List<Long> works = new ArrayList<>();

        try (PreparedStatement st = mConnection.prepareStatement("SELECT `id` FROM `work` WHERE `user` = ?")) {
            st.setLong(1, userId);

            ResultSet results = st.executeQuery();
            while (results.next()) {
                works.add(results.getLong(1));
            }
        } catch (SQLException e) {
            log.error("Could not find work by user ID", e);
            throw new RuntimeException(e);
        }

        return works;
    }

}
