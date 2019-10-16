package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import JW.mapper.TUserMapper;
import JW.pojo.TUser;
import JW.pojo.TUserExample;
import JW.pojo.TUserExample.Criteria;
import JW.service.UserService;

import java.util.List;

import javax.annotation.Resource;

/**
 * example Equal to reutrn 0
 * return null
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserMapper userMapper;

	@Override
	public TUser login(TUser user) {
		return null;
	}

	@Override
	public void editPassword(String password, String id) {

	}

	@Override
	public void save(TUser model, String[] roleIds) {

	}

	@Override
	public TUser findByUsername(String username) {
		TUserExample userExample = new TUserExample();
		TUserExample.Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUsernameEqualTo(username);
		List<TUser> user = userMapper.selectByExample(userExample);
		if (user.size() == 1) {
			return user.get(0);
		} else {
			return null;
		}
	}
}
