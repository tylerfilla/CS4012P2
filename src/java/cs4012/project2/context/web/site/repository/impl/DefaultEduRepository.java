/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.Edu;
import cs4012.project2.context.web.site.repository.EduRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.util.Optional;

@Repository
public class DefaultEduRepository implements EduRepository {

    @Inject
    private Connection mConnection;

    @Override
    public <S extends Edu> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Edu> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Edu> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<Edu> findAll() {
        return null;
    }

    @Override
    public Iterable<Edu> findAllById(Iterable<Long> ids) {
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
    public void delete(Edu entity) {
    }

    @Override
    public void deleteAll(Iterable<? extends Edu> entities) {
    }

    @Override
    public void deleteAll() {
    }

}
