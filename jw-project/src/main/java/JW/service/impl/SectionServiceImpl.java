package JW.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import JW.mapper.TSectionMapper;
import JW.pojo.TSection;
import JW.pojo.TSectionExample;
import JW.service.SectionService;

import java.util.List;

/**
 * example
 */
@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private TSectionMapper sectionMapper;

	@Override
	public List<TSection> findAll() {
		TSectionExample example = new TSectionExample();
		List<TSection> list = sectionMapper.selectByExample(example);
		return list;
	}

}
