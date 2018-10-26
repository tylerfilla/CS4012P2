/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository;

import cs4012.project2.context.web.site.entity.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface WorkRepository extends CrudRepository<Work, Long> {
}
