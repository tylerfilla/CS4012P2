/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.entity;

/**
 * A work history fragment.
 */
public class Work {

    /**
     * The unique ID.
     */
    private long mId;

    /**
     * ID of the user.
     */
    private long mUser;

    /**
     * The company name.
     */
    private String mCompany;

    /**
     * The title held.
     */
    private String mTitle;

    /**
     * Years of service.
     */
    private int mYears;

    public Work() {
        mId = -1;
        mUser = -1;
        mCompany = "";
        mTitle = "";
        mYears = 0;
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
     * @return The company name
     */
    public String getCompany() {
        return mCompany;
    }

    /**
     * @param pCompany The company name
     */
    public void setCompany(String pCompany) {
        mCompany = pCompany;
    }

    /**
     * @return The title held
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * @param pTitle The title held
     */
    public void setTitle(String pTitle) {
        mTitle = pTitle;
    }

    /**
     * @return Years of service
     */
    public int getYears() {
        return mYears;
    }

    /**
     * @param pYears Years of service
     */
    public void setYears(int pYears) {
        mYears = pYears;
    }

}
