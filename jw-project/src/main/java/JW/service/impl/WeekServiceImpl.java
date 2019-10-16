package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import JW.mapper.TWeekMapper;
import JW.pojo.TWeek;
import JW.pojo.TWeekExample;
import JW.service.WeekService;

import java.util.List;

/**
 * example
 */
@Service
public class WeekServiceImpl implements WeekService {
	
	@Autowired
	private TWeekMapper weekMapper;

	@Override
	public List<TWeek> findAll() {
		TWeekExample example = new TWeekExample();
		List<TWeek> list = weekMapper.selectByExample(example);
		return list;
	}

}
