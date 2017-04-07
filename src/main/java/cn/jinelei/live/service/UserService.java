package cn.jinelei.live.service;

import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.User;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface UserService {

    User register(Integer userId, String userName, String userNickname, Integer userSex, Integer userAge, String userPhone, Integer userHeight, Integer userWeight, Integer userArea, Integer userStatus, Integer userTreasure, String userPasswd, String userEmail) throws UserException;

    User register(String userName, String userNickname, Integer userSex, Integer userAge, String userPhone, Integer userHeight, Integer userWeight, Integer userArea, String userPasswd, String userEmail) throws UserException;

    User register(String userName, Integer userSex, Integer userAge, String userPasswd) throws UserException;

    User register(User user) throws UserException;

    boolean verifyUser(String username, String passwd);

    boolean verifyUser(User user);

    User getUserInfo(User user) throws UserException;

    User getUserInfo(int userId) throws UserException;

    User getUserInfo(String userName) throws UserException;

    boolean updateUser(User user) throws UserException;

    boolean deleteUser(User user) throws UserException;

    boolean deleteUser(Integer userID) throws UserException;

    List<User> getAllUser();

    List<User> getAllUser(Integer offset, Integer limit);

    List<User> getAllUserAlive();

    List<User> getAllUserOnline();

    List<User> getAllUserOffline();

    List<User> getAllUserActive();

    List<User> getAllUserInactive();

    List<User> getAllUserDelete();
}
