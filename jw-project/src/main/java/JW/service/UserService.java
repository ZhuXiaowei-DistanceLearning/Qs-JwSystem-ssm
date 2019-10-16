package JW.service;

import JW.pojo.TStudent;
import JW.pojo.TUser;

/**
 * Created by Administrator on 2017/6/16.
 */
public interface UserService {
    public TUser login(TUser user);

    public void editPassword(String password, String id);

    public void save(TUser model, String[] roleIds);
    
    public TUser findByUsername(String username);
}
