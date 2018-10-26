/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.entity;

/**
 * An education history fragment.
 */
public class Edu {

    /**
     * The unique ID.
     */
    private long mId;

    /**
     * ID of the user.
     */
    private long mUser;

    /**
     * The degree type.
     */
    private String mDegreeType;

    /**
     * The degree discipline.
     */
    private String mDegreeDiscipline;

    /**
     * The year of achievement.
     */
    private int mYear;

    public Edu() {
        mId = -1;
        mUser = -1;
        mDegreeType = "";
        mDegreeDiscipline = "";
        mYear = 0;
    }

    /**
     * @return The unique ID
     */
    public long getId() {
        return mId;
    }

    /**
     * @param pId The unique ID
     */
    public void setId(long pId) {
        mId = pId;
    }

    /**
     * @return ID of the user
     */
    public long getUser() {
        return mUser;
    }

    /**
     * @param pUser ID of the user
     */
    public void setUser(long pUser) {
        mUser = pUser;
    }

    /**
     * @return The degree type
     */
    public String getDegreeType() {
        return mDegreeType;
    }

    /**
     * @param pDegreeType The degree type
     */
    public void setDegreeType(String pDegreeType) {
        mDegreeType = pDegreeType;
    }

    /**
     * @return The degree discipline
     */
    public String getDegreeDiscipline() {
        return mDegreeDiscipline;
    }

    /**
     * @param pDegreeDiscipline The degree discipline
     */
    public void setDegreeDiscipline(String pDegreeDiscipline) {
        mDegreeDiscipline = pDegreeDiscipline;
    }

    /**
     * @return Year of achievement
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @param pYear Year of achievement
     */
    public void setYear(int pYear) {
        mYear = pYear;
    }

}
