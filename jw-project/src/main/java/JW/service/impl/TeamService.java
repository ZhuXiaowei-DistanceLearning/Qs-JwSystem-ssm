package JW.service.impl;

import JW.mapper.TTeamMapper;
import JW.pojo.TCstatus;
import JW.pojo.TCstatusExample;
import JW.pojo.TTeam;
import JW.pojo.TTeamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zxw
 * @date 2019/10/18 8:50
 */
@Service
@Transactional
public class TeamService {
    @Autowired
    private TTeamMapper teamMapper;

    public List<TTeam> listajax() {
        TTeamExample example = new TTeamExample();
        List<TTeam> tCstatuses = teamMapper.selectByExample(example);
        return tCstatuses;
    }
}
