/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.service;

import cs4012.project2.context.web.site.entity.Edu;

import java.util.List;

public interface EduService {

    Edu getEdu(long eduId);

    Edu updateEdu(Edu edu);

    void deleteEdu(long eduId);

    List<Edu> getUserEdus(long userId);

}
