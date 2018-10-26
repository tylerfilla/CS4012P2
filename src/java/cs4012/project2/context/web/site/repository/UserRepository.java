/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository;

import cs4012.project2.context.web.site.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
