package com.main.db.dao;

import com.main.db.model.WmMainAuthcode;
import com.main.db.model.WmMainAuthcodeExample;
import com.main.db.model.WmMainAuthcodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WmMainAuthcodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int countByExample(WmMainAuthcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int deleteByExample(WmMainAuthcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int deleteByPrimaryKey(WmMainAuthcodeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int insert(WmMainAuthcode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int insertSelective(WmMainAuthcode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    List<WmMainAuthcode> selectByExample(WmMainAuthcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    WmMainAuthcode selectByPrimaryKey(WmMainAuthcodeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int updateByExampleSelective(@Param("record") WmMainAuthcode record, @Param("example") WmMainAuthcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int updateByExample(@Param("record") WmMainAuthcode record, @Param("example") WmMainAuthcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int updateByPrimaryKeySelective(WmMainAuthcode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table WM_MAIN_AUTHCODE
     *
     * @mbggenerated Mon Jun 06 15:53:35 CST 2016
     */
    int updateByPrimaryKey(WmMainAuthcode record);
}