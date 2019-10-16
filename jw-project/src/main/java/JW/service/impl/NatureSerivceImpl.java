package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import JW.mapper.TNatureMapper;
import JW.pojo.TNature;
import JW.pojo.TNatureExample;
import JW.service.NatureService;

import java.util.List;

/**
 * example
 */
@Service
public class NatureSerivceImpl implements NatureService {

	@Autowired
	private TNatureMapper natureMapper;

	@Override
	public List<TNature> findAll() {
		TNatureExample example = new TNatureExample();
		List<TNature> list = natureMapper.selectByExample(example);
		return list;
	}

}
