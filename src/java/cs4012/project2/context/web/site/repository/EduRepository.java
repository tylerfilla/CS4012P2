/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.repository;

import cs4012.project2.context.web.site.entity.Edu;
import org.springframework.data.repository.CrudRepository;

public interface EduRepository extends CrudRepository<Edu, Long> {
}
