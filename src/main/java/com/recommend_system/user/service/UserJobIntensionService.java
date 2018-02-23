package com.recommend_system.user.service;

import com.recommend_system.user.entity.User;
import com.recommend_system.user.entity.UserJobIntension;


/*
 *用户求职意愿信息Service接口
 */
public interface UserJobIntensionService {
    /**
     *修改用户求职意愿
     * @param userJobIntension:传入修改后的用户求职意愿bean
     * controller中获得session中的user，根据user的id修改对应userid的userJobIntension
     * 或者前端直接传相应的id过来
     */
    public void setIntension(UserJobIntension userJobIntension);
    /**
     *增加用户求职意愿
     * @param userJobIntension:传入用户增加的用户求职意愿bean
     * controller中获得session中的user，根据user的id新插入对应userid的userJobIntension
     * 或者前端传id过来
     */
    public void addIntension(UserJobIntension userJobIntension);
    /**
     * @param user 根据用户id获得对应用户工作意愿对象
     */
    public UserJobIntension getIntension(User user);
}