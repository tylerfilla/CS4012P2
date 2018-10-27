/*
 * Tyler Filla
 * CS4012 - P2
 */

package cs4012.project2.context.web.site.entity;

import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Information about a user.
 */
public class User {

    /**
     * The unique ID.
     */
    private long mId;

    /**
     * The username.
     */
    private String mUsername;

    /**
     * The password.
     */
    private String mPassword;

    /**
     * The user first name.
     */
    private String mFname;

    /**
     * The user last name.
     */
    private String mLname;

    /**
     * The address body.
     */
    private String mAddrBody;

    /**
     * The address city.
     */
    private String mAddrCity;

    /**
     * The address state.
     */
    private String mAddrState;

    /**
     * The address ZIP.
     */
    private String mAddrZip;

    /**
     * The user birthday.
     */
    private Date mBirthday;

    /**
     * The user home phone number.
     */
    private String mPhoneHome;

    /**
     * The user cell phone number.
     */
    private String mPhoneCell;

    /**
     * The user time zone.
     */
    private String mTimeZone;

    /**
     * The user profile image.
     */
    private Blob mProfileImage;

    public User() {
        mId = -1;
        mUsername = "";
        mPassword = "";
        mFname = "";
        mLname = "";
        mAddrBody = "";
        mAddrCity = "";
        mAddrState = "";
        mAddrZip = "";
        mBirthday = Date.valueOf(LocalDate.now());
        mPhoneHome = "";
        mPhoneCell = "";
        mTimeZone = "";
        mProfileImage = new com.mysql.cj.jdbc.Blob(new byte[] {}, null);
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
     * @return The username
     */
    public String getUsername() {
        return mUsername;
    }

    /**
     * @param pUsername The username
     */
    public void setUsername(String pUsername) {
        mUsername = pUsername;
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return mPassword;
    }

    /**
     * @param pPassword The password
     */
    public void setPassword(String pPassword) {
        mPassword = pPassword;
    }

    /**
     * @return The user first name
     */
    public String getFname() {
        return mFname;
    }

    /**
     * @param pFname The user first name
     */
    public void setFname(String pFname) {
        mFname = pFname;
    }

    /**
     * @return The user last name
     */
    public String getLname() {
        return mLname;
    }

    /**
     * @param pLname The user last name
     */
    public void setLname(String pLname) {
        mLname = pLname;
    }

    /**
     * @return The address body
     */
    public String getAddrBody() {
        return mAddrBody;
    }

    /**
     * @param pAddrBody The address body
     */
    public void setAddrBody(String pAddrBody) {
        mAddrBody = pAddrBody;
    }

    /**
     * @return The address city
     */
    public String getAddrCity() {
        return mAddrCity;
    }

    /**
     * @param pAddrCity The address city
     */
    public void setAddrCity(String pAddrCity) {
        mAddrCity = pAddrCity;
    }

    /**
     * @return The address state
     */
    public String getAddrState() {
        return mAddrState;
    }

    /**
     * @param pAddrState The address state
     */
    public void setAddrState(String pAddrState) {
        mAddrState = pAddrState;
    }

    /**
     * @return The address ZIP
     */
    public String getAddrZip() {
        return mAddrZip;
    }

    /**
     * @param pAddrZip The address ZIP
     */
    public void setAddrZip(String pAddrZip) {
        mAddrZip = pAddrZip;
    }

    /**
     * @return The user birthday
     */
    public Date getBirthday() {
        return mBirthday;
    }

    /**
     * @param pBirthday The user birthday
     */
    public void setBirthday(Date pBirthday) {
        mBirthday = pBirthday;
    }

    /**
     * @return The user home phone number
     */
    public String getPhoneHome() {
        return mPhoneHome;
    }

    /**
     * @param pPhoneHome The user home phone number
     */
    public void setPhoneHome(String pPhoneHome) {
        mPhoneHome = pPhoneHome;
    }

    /**
     * @return The user cell phone number
     */
    public String getPhoneCell() {
        return mPhoneCell;
    }

    /**
     * @param pPhoneCell The user cell phone number
     */
    public void setPhoneCell(String pPhoneCell) {
        mPhoneCell = pPhoneCell;
    }

    /**
     * @return The user time zone
     */
    public String getTimeZone() {
        return mTimeZone;
    }

    /**
     * @param pTimeZone The user time zone
     */
    public void setTimeZone(String pTimeZone) {
        mTimeZone = pTimeZone;
    }

    /**
     * @return The user profile image
     */
    public Blob getProfileImage() {
        return mProfileImage;
    }

    /**
     * @param pProfileImage The user profile image
     */
    public void setProfileImage(Blob pProfileImage) {
        mProfileImage = pProfileImage;
    }

}
