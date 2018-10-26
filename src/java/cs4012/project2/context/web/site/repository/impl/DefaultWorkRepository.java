/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.Work;
import cs4012.project2.context.web.site.repository.WorkRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.util.Optional;

@Repository
public class DefaultWorkRepository implements WorkRepository {

    @Inject
    private Connection mConnection;

    @Override
    public <S extends Work> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Work> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Work> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<Work> findAll() {
        return null;
    }

    @Override
    public Iterable<Work> findAllById(Iterable<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public void delete(Work entity) {
    }

    @Override
    public void deleteAll(Iterable<? extends Work> entities) {
    }

    @Override
    public void deleteAll() {
    }

}
