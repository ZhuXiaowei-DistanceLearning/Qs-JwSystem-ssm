package JW.service;

import java.util.List;

import JW.pojo.AuthFunction;
import pojo.EasyUIDataGridResult;

/**
 * Created by Administrator on 2017/6/11.
 */
public interface FunctionService {

    public List<AuthFunction> findMenu();

    public List<AuthFunction> findAll();

    public void save(AuthFunction model);

    public void update(String ids);

    public List<AuthFunction> findListByTeacherid(String tid);

    public List<AuthFunction> findListByStudentid(String sid);

    public EasyUIDataGridResult pageQuery(Integer page, Integer rows);

    List<Integer> queryFunctionByRole(String id);

}
