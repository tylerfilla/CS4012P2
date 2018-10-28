/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service.impl;

import cs4012.project2.context.web.site.entity.Work;
import cs4012.project2.context.web.site.repository.WorkRepository;
import cs4012.project2.context.web.site.service.WorkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultWorkService implements WorkService {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private WorkRepository mWorkRepository;

    @Override
    public Work getWork(long workId) {
        log.debug("Get work: " + workId);
        return mWorkRepository.findById(workId).orElse(null);
    }

    @Override
    public Work updateWork(Work work) {
        log.debug("Update work: " + work.getId());
        return mWorkRepository.save(work);
    }

    @Override
    public void deleteWork(long workId) {
        log.debug("Delete work: " + workId);
        mWorkRepository.deleteById(workId);
    }

    @Override
    public List<Work> getUserWorks(long userId) {
        List<Work> works = new ArrayList<>();

        for (Long workId : mWorkRepository.findByUser(userId)) {
            works.add(mWorkRepository.findById(workId).orElse(null));
        }

        return works;
    }

}
