package com.main.db.model;

public class WmSysSysid extends WmSysSysidKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_SYS_SYSID.SYS_NAME
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    private String sysName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_SYS_SYSID.SYS_PASSWORD
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    private String sysPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_SYS_SYSID.SYS_IP
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    private String sysIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_SYS_SYSID.REDIRECT_LOGIN_SUCCESS
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    private String redirectLoginSuccess;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_SYS_SYSID.SYS_NAME
     *
     * @return the value of WM_SYS_SYSID.SYS_NAME
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_SYS_SYSID.SYS_NAME
     *
     * @param sysName the value for WM_SYS_SYSID.SYS_NAME
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_SYS_SYSID.SYS_PASSWORD
     *
     * @return the value of WM_SYS_SYSID.SYS_PASSWORD
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public String getSysPassword() {
        return sysPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_SYS_SYSID.SYS_PASSWORD
     *
     * @param sysPassword the value for WM_SYS_SYSID.SYS_PASSWORD
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public void setSysPassword(String sysPassword) {
        this.sysPassword = sysPassword == null ? null : sysPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_SYS_SYSID.SYS_IP
     *
     * @return the value of WM_SYS_SYSID.SYS_IP
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public String getSysIp() {
        return sysIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_SYS_SYSID.SYS_IP
     *
     * @param sysIp the value for WM_SYS_SYSID.SYS_IP
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public void setSysIp(String sysIp) {
        this.sysIp = sysIp == null ? null : sysIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_SYS_SYSID.REDIRECT_LOGIN_SUCCESS
     *
     * @return the value of WM_SYS_SYSID.REDIRECT_LOGIN_SUCCESS
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public String getRedirectLoginSuccess() {
        return redirectLoginSuccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_SYS_SYSID.REDIRECT_LOGIN_SUCCESS
     *
     * @param redirectLoginSuccess the value for WM_SYS_SYSID.REDIRECT_LOGIN_SUCCESS
     *
     * @mbggenerated Mon Jun 06 14:48:35 CST 2016
     */
    public void setRedirectLoginSuccess(String redirectLoginSuccess) {
        this.redirectLoginSuccess = redirectLoginSuccess == null ? null : redirectLoginSuccess.trim();
    }
}