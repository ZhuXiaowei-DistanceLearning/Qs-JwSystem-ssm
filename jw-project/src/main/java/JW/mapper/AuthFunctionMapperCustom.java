package JW.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import JW.pojo.AuthFunction;
import JW.pojo.AuthFunctionExample;

public interface AuthFunctionMapperCustom {
	List<AuthFunction> findAll();

	List<AuthFunction> findListByTeacherid(String userid);

	List<AuthFunction> findListByStudentid(String userid);

	List<AuthFunction> findListByUserid(String userid);

	List<AuthFunction> findAllMenu();

	List<AuthFunction> findMenuByTeacherid(String id);

	List<AuthFunction> findMenuByStudentid(String id);

	List<AuthFunction> findMenuByUserid(String id);

}