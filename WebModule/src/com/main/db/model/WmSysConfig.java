package com.main.db.model;

public class WmSysConfig extends WmSysConfigKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_SYS_CONFIG.CONFIG_VALUE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String configValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WM_SYS_CONFIG.CONFIG_DESCRIPTION
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    private String configDescription;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_SYS_CONFIG.CONFIG_VALUE
     *
     * @return the value of WM_SYS_CONFIG.CONFIG_VALUE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_SYS_CONFIG.CONFIG_VALUE
     *
     * @param configValue the value for WM_SYS_CONFIG.CONFIG_VALUE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WM_SYS_CONFIG.CONFIG_DESCRIPTION
     *
     * @return the value of WM_SYS_CONFIG.CONFIG_DESCRIPTION
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public String getConfigDescription() {
        return configDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WM_SYS_CONFIG.CONFIG_DESCRIPTION
     *
     * @param configDescription the value for WM_SYS_CONFIG.CONFIG_DESCRIPTION
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    public void setConfigDescription(String configDescription) {
        this.configDescription = configDescription == null ? null : configDescription.trim();
    }
}