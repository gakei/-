package WHJ.service;

import WHJ.mapper.UserMapper;
import WHJ.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void insertOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser == null) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            dbUser.setGmtModified(user.getGmtCreate());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            userMapper.update(dbUser);
        }
    }
}
