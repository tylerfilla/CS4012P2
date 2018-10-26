/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository.impl;

import cs4012.project2.context.web.site.entity.User;
import cs4012.project2.context.web.site.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.util.Optional;

@Repository
public class DefaultUserRepository implements UserRepository {

    @Inject
    private Connection mConnection;

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
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
    public void delete(User entity) {
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
    }

    @Override
    public void deleteAll() {
    }

}
