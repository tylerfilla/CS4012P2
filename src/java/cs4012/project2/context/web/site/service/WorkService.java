/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service;

import cs4012.project2.context.web.site.entity.Work;

import java.util.List;

public interface WorkService {

    Work getWork(long workId);

    Work updateWork(Work work);

    List<Work> getUserWorks(long userId);

}
