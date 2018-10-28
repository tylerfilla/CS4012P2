/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service.impl;

import cs4012.project2.context.web.site.entity.Edu;
import cs4012.project2.context.web.site.repository.EduRepository;
import cs4012.project2.context.web.site.service.EduService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultEduService implements EduService {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private EduRepository mEduRepository;

    @Override
    public Edu getEdu(long eduId) {
        log.debug("Get edu: " + eduId);
        return mEduRepository.findById(eduId).orElse(null);
    }

    @Override
    public Edu updateEdu(Edu edu) {
        log.debug("Update edu: " + edu.getId());
        return mEduRepository.save(edu);
    }

    @Override
    public List<Edu> getUserEdus(long userId) {
        List<Edu> edus = new ArrayList<>();

        for (Long eduId : mEduRepository.findByUser(userId)) {
            edus.add(mEduRepository.findById(eduId).orElse(null));
        }

        return edus;
    }

}
