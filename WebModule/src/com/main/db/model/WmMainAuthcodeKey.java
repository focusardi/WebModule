package com.main.db.model;

public class WmMainAuthcodeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_MAIN_AUTHCODE.CODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String code;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_MAIN_AUTHCODE.CODE
     *
     * @return the value of WM_MAIN_AUTHCODE.CODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_MAIN_AUTHCODE.CODE
     *
     * @param code the value for WM_MAIN_AUTHCODE.CODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}