package cn.jinelei.live.service.impl;

import cn.jinelei.live.dao.UserMapper;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.data.UserExample;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.model.enumstatus.user.UserTreasure;
import cn.jinelei.live.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinelei on 17-4-7.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    private UserExample userExample;


    @Override
    public User register(Integer userId, String userName, String userNickname, Integer userSex, Integer userAge, String userPhone, Integer userHeight, Integer userWeight, Integer userArea, Integer userStatus, Integer userTreasure, String userPasswd, String userEmail) throws UserException {
        User user = new User();
        user.setUserName(userName);
        user.setUserNickname(userNickname);
        user.setUserSex(userSex);
        user.setUserAge(userAge);
        user.setUserPhone(userPhone);
        user.setUserHeight(userHeight);
        user.setUserWeight(userWeight);
        user.setUserArea(userArea);
        user.setUserStatus(userStatus);
        user.setUserTreasure(userTreasure);
        user.setUserPasswd(userPasswd);
        user.setUserEmail(userEmail);
        return register(user);
    }

    @Override
    public User register(String userName, String userNickname, Integer userSex, Integer userAge, String userPhone, Integer userHeight, Integer userWeight, Integer userArea, String userPasswd, String userEmail) throws UserException {
        User user = new User();
        user.setUserName(userName);
        user.setUserNickname(userNickname);
        user.setUserSex(userSex);
        user.setUserAge(userAge);
        user.setUserPhone(userPhone);
        user.setUserHeight(userHeight);
        user.setUserWeight(userWeight);
        user.setUserArea(userArea);
        user.setUserStatus(1);
        user.setUserTreasure(50000);
        user.setUserPasswd(userPasswd);
        user.setUserEmail(userEmail);
        return register(user);
    }

    @Override
    public User register(String userName, Integer userSex, Integer userAge, String userPasswd, String userPhone) throws UserException {
        User user = new User();
        user.setUserName(userName);
        user.setUserNickname(userName);
        user.setUserSex(userSex);
        user.setUserAge(userAge);
        user.setUserStatus(1);
        user.setUserTreasure(50000);
        user.setUserPasswd(userPasswd);
        user.setUserPhone(userPhone);
        return register(user);
    }

    @Override
    public User register(User user) throws UserException {
        try {
            getUserInfo(user.getUserName());
            throw new UserException(UserException.USER_WAS_EXIST);
        } catch (UserException e) {
            if (UserException.USER_NOT_EXIST.equals(e.getMessage())) {
                if (user.getUserStatus() == null)
                    user.setUserStatus(Integer.valueOf(UserStatus.ENABLE.toString()));
                if (user.getUserTreasure() == null)
                    user.setUserTreasure(Integer.valueOf(UserTreasure.DEFAULT.toString()));
                userMapper.insertSelective(user);
            }
            if (UserException.USER_WAS_EXIST.equals(e.getMessage())) {
//                throw new UserException(UserException.USER_WAS_EXIST);
                throw e;
            }
        }
        return getUserInfo(user.getUserName());
    }

    @Override
    public boolean verifyUser(String username, String passwd) {
        boolean res = false;
        try {
            User user = getUserInfo(username);
            if (passwd != null && passwd.equals(user.getUserPasswd()))
                res = true;
        } catch (UserException e) {
        } finally {
            return res;
        }
    }

    @Override
    public boolean verifyUser(User user) {
        return verifyUser(user.getUserName(), user.getUserPasswd());
    }

    @Override
    public User getUserInfo(User user) throws UserException {
        return getUserInfo(user.getUserId());
    }

    @Override
    public User getUserInfo(int userId) throws UserException {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null)
            throw new UserException(UserException.USER_NOT_EXIST);
        return user;
    }

    @Override
    public User getUserInfo(String userName) throws UserException {
        userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 1)
            throw new UserException(UserException.USER_NOT_UNIQUE);
        else if (userList.size() == 0) {
            throw new UserException(UserException.USER_NOT_EXIST);
        } else
            return getUserInfo(userList.get(0));
    }

    @Override
    public boolean updateUser(User user) throws UserException {
        boolean ret = false;
        User user1 = getUserInfo(user.getUserName());
        if (user.getUserNickname() != null && !"".equals(user.getUserNickname()) && !user.getUserNickname().equals(user1.getUserNickname()))
            user1.setUserNickname(user.getUserNickname());
        if (user.getUserPhone() != null && !"".equals(user.getUserPhone()) && !user.getUserPhone().equals(user1.getUserNickname()))
            user1.setUserPhone(user.getUserPhone());
        if (user.getUserPasswd() != null && !"".equals(user.getUserPasswd()) && !user.getUserPasswd().equals(user1.getUserPasswd()))
            user1.setUserPasswd(user.getUserPasswd());
        if (user.getUserEmail() != null && !"".equals(user.getUserEmail()) && !user.getUserEmail().equals(user1.getUserEmail()))
            user1.setUserEmail(user.getUserEmail());
        if (user.getUserSex() != null && user.getUserSex() != user1.getUserSex())
            user1.setUserSex(user.getUserSex());
        if (user.getUserAge() != null && user.getUserAge() != user1.getUserAge())
            user1.setUserAge(user.getUserAge());
        if (user.getUserHeight() != null && user.getUserHeight() != user1.getUserHeight())
            user1.setUserHeight(user.getUserHeight());
        if (user.getUserWeight() != null && user.getUserWeight() != user1.getUserWeight())
            user1.setUserWeight(user.getUserWeight());
        if (user.getUserArea() != null && user.getUserArea() != user1.getUserArea())
            user1.setUserArea(user.getUserArea());
        if (user.getUserStatus() != null && user.getUserStatus() != user1.getUserStatus())
            user1.setUserStatus(user.getUserStatus());
        if (user.getUserTreasure() != null && user.getUserTreasure() != user1.getUserTreasure())
            user1.setUserTreasure(user.getUserTreasure());
        int res = userMapper.updateByPrimaryKey(user1);
        if (res == 1)
            ret = true;
        return ret;
    }

    @Override
    public boolean deleteUser(User user) throws UserException {
        return deleteUser(user.getUserId());
    }

    @Override
    public boolean deleteUser(Integer userID) throws UserException {
        User user = userMapper.selectByPrimaryKey(userID);
        user.setUserStatus(user.getUserStatus() &(Integer.MAX_VALUE ^ Integer.valueOf(UserStatus.ENABLE.toString())));
        return updateUser(user);
    }


    @Override
    public List<User> getAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<User> getAllUser(Integer offset, Integer limit) {
        PageInfo<User> pageInfo = PageHelper.offsetPage(offset, limit).doSelectPageInfo(() -> {
            userMapper.selectByExample(new UserExample());
        });
        return pageInfo.getList();
    }

    @Override
    public PageInfo<User> getAllUserPageInfo() {
        UserExample example = new UserExample();
        return new PageInfo<User>(userMapper.selectByExample(example));
    }


    @Override
    public List<User> getAllUserAlive() {
        List<User> users = getAllUser().stream().filter(user -> ((user.getUserStatus() & Integer.valueOf(UserStatus.ENABLE.toString())) != 0) ? true : false)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> getAllUserDelete() {
        List<User> users = getAllUser().stream().filter(user -> ((user.getUserStatus() & Integer.valueOf(UserStatus.ENABLE.toString())) == 0) ? true : false)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> getAllUserOnline() {
        List<User> users = getAllUser().stream().filter(user -> ((user.getUserStatus() & Integer.valueOf(UserStatus.ONLINE.toString())) != 0) ? true : false)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> getAllUserOffline() {
        List<User> users = getAllUser().stream().filter(user -> ((user.getUserStatus() & Integer.valueOf(UserStatus.ONLINE.toString())) == 0) ? true : false)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> getAllUserActive() {
        List<User> users = getAllUser().stream().filter(user -> ((user.getUserStatus() & Integer.valueOf(UserStatus.ACTIVE.toString())) != 0) ? true : false)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> getAllUserInactive() {
        List<User> users = getAllUser().stream().filter(user -> ((user.getUserStatus() & Integer.valueOf(UserStatus.ACTIVE.toString())) == 0) ? true : false)
                .collect(Collectors.toList());
        return users;
    }

}
