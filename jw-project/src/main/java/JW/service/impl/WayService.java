package JW.service.impl;

import JW.mapper.TExamwayMapper;
import JW.pojo.TExamway;
import JW.pojo.TExamwayExample;
import JW.pojo.TTeam;
import JW.pojo.TTeamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zxw
 * @date 2019/10/18 8:51
 */
@Service
@Transactional
public class WayService {
    @Autowired
    private TExamwayMapper examwayMapper;

    public List<TExamway> listajax() {
        TExamwayExample example = new TExamwayExample();
        List<TExamway> tCstatuses = examwayMapper.selectByExample(example);
        return tCstatuses;
    }
}
