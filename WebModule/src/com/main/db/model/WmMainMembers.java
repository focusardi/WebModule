package com.main.db.model;

public class WmMainMembers extends WmMainMembersKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_MAIN_MEMBERS.NAME
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_MAIN_MEMBERS.SEX
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_MAIN_MEMBERS.PASSWORD
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_MAIN_MEMBERS.LAST_LOGIN_TIME
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String lastLoginTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_MAIN_MEMBERS.NAME
     *
     * @return the value of WM_MAIN_MEMBERS.NAME
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_MAIN_MEMBERS.NAME
     *
     * @param name the value for WM_MAIN_MEMBERS.NAME
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_MAIN_MEMBERS.SEX
     *
     * @return the value of WM_MAIN_MEMBERS.SEX
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_MAIN_MEMBERS.SEX
     *
     * @param sex the value for WM_MAIN_MEMBERS.SEX
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_MAIN_MEMBERS.PASSWORD
     *
     * @return the value of WM_MAIN_MEMBERS.PASSWORD
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_MAIN_MEMBERS.PASSWORD
     *
     * @param password the value for WM_MAIN_MEMBERS.PASSWORD
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_MAIN_MEMBERS.LAST_LOGIN_TIME
     *
     * @return the value of WM_MAIN_MEMBERS.LAST_LOGIN_TIME
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_MAIN_MEMBERS.LAST_LOGIN_TIME
     *
     * @param lastLoginTime the value for WM_MAIN_MEMBERS.LAST_LOGIN_TIME
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }
}