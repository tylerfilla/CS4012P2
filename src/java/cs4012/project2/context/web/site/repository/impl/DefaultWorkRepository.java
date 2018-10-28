/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.Work;
import cs4012.project2.context.web.site.repository.WorkRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultWorkRepository implements WorkRepository {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private Connection mConnection;

    @Override
    public <S extends Work> S save(S work) {
        log.debug("Saving work: " + work.getId());

        if (existsById(work.getId())) {
            throw new RuntimeException("Not implemented!");
        } else {
            try (PreparedStatement st = mConnection.prepareStatement("INSERT INTO `work` (`user`, `company`, `title`, `years`) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                // Insert work data
                st.setLong(1, work.getUser());
                st.setString(2, work.getCompany());
                st.setString(3, work.getTitle());
                st.setLong(4, work.getYears());
                st.executeUpdate();

                // Fetch auto-generated ID
                ResultSet results = st.getGeneratedKeys();
                if (results.next()) {
                    work.setId(results.getInt(1));
                }

                return work;
            } catch (SQLException e) {
                log.error("Could not save new user", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public <S extends Work> Iterable<S> saveAll(Iterable<S> works) {
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
        try (PreparedStatement st = mConnection.prepareStatement("SELECT `id` FROM `edu` WHERE `id` = ?")) {
            st.setLong(1, id);
            return st.executeQuery().next();
        } catch (SQLException e) {
            log.error("Could not check for existence by ID", e);
            throw new RuntimeException(e);
        }
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
        try (PreparedStatement st = mConnection.prepareStatement("DELETE FROM `work` WHERE `id` = ?")) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error("Could not delete work by ID", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Work work) {
        throw new RuntimeException("Not implemented!");
    }

    @Override
    public void deleteAll(Iterable<? extends Work> works) {
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
