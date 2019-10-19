package JW.service.impl;

import JW.mapper.TCstatusMapper;
import JW.pojo.TCstatus;
import JW.pojo.TCstatusExample;
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
public class CStatusService {
    @Autowired
    private TCstatusMapper cstatusMapper;

    public List<TCstatus> listajax() {
        TCstatusExample example = new TCstatusExample();
        List<TCstatus> tCstatuses = cstatusMapper.selectByExample(example);
        return tCstatuses;
    }
}
