package qdu.java.recruit.service;


import com.github.pagehelper.PageInfo;

import qdu.java.recruit.entity.UserEntity;
import qdu.java.recruit.pojo.PositionCompanyBO;
import qdu.java.recruit.pojo.UserdesireBO;

public interface UserService {

    UserEntity getUser(int userId);

    boolean updateUser(UserEntity userEntity);

    boolean registerUser(UserEntity userEntity);

    boolean loginUser(String mobile, String password);

    UserEntity getUserByMobile(String mobile);
    
    boolean updateHits(int userId);
    
    PageInfo<UserdesireBO> searchUser(String keyword, String orderBy, int page, int limit);
}
