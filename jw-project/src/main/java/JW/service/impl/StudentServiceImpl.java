package JW.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import JW.mapper.StudentRoleMapper;
import JW.mapper.TStudentMapper;
import JW.pojo.StudentRoleKey;
import JW.pojo.TStudent;
import JW.pojo.TStudentExample;
import JW.pojo.TStudentExample.Criteria;
import JW.service.StudentService;
import pojo.EasyUIDataGridResult;
import utils.E3Result;
import utils.FileUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * exampleget0
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private TStudentMapper studentMapper;
	@Autowired
	private StudentRoleMapper studentRoleMapper;

	@Override
	public void saveBatch(List<TStudent> student) {

	}

	@Override
	public List<TStudent> findAll() {
		return null;
	}

	/**
	 * 暂未使用
	 * findAllPageHelpPageInforesult
	 */
	@Override
	public TStudent findByUsername(String username) {
		TStudentExample studentExample = new TStudentExample();
		JW.pojo.TStudentExample.Criteria studentCriteria = studentExample.createCriteria();
		studentCriteria.andSidEqualTo(username);
		List<TStudent> student = studentMapper.selectByExample(studentExample);
		if (student.size() == 1) {
			return student.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 找到课程中的学生名单
	 */
	@Override
	public EasyUIDataGridResult findStudentByclass(String ids, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<TStudent> list = studentMapper.findAll(ids);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TStudent> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}
	
	/**
	 * 排序第一个非正常id
	 */
	@Override
	public EasyUIDataGridResult pageQuery(Integer page, Integer rows) {
		return null;
	}

	/**
	 * 添加缺勤学生名单
	 */
	@Override
	public E3Result addStudentAbenst(String[] studentIds) {
		for (int i = 0; i < studentIds.length; i++) {
			if (i == 0) {
				continue;
			}
			TStudent student = studentMapper.selectByPrimaryKey(studentIds[i]);
			Integer times = student.getAbsent();
			student.setAbsent(times + 1);
			studentMapper.updateByPrimaryKey(student);
		}
		return E3Result.ok("添加成功");
	}

	/**
	 * 模板化代码
	 * 导入学生信息表格
	 */
	@Override
	public String importXlsStudent(MultipartFile myFile, String cid, HttpServletResponse response) {
		String flag = "1";
		try {
			// 创建
			XSSFWorkbook workbook = new XSSFWorkbook(myFile.getInputStream());
			// 左下角单元
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				int rowNum = row.getRowNum();
				if (rowNum == 0) {
					continue;
				}
				XSSFCell cell = (XSSFCell) row.getCell(0);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				String sid = cell.getStringCellValue();
				String sname = row.getCell(1).getStringCellValue();
				/**
				 * 转换
				 */
				XSSFCell cell2 = (XSSFCell) row.getCell(2);
				cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
				String password = cell2.getStringCellValue();
				String sex = row.getCell(3).getStringCellValue();
				String scity = row.getCell(4).getStringCellValue();
				String roleId = "b762e0f84ec911e8bf5d34de1af4e65a";
				String qx = "学生";
				TStudent student = new TStudent();
				student.setSname(sname);
				student.setScity(scity);
				student.setAbsent(0);
				student.setClassesId(cid);
				student.setPassword(password);
				student.setQx(qx);
				student.setSid(sid);
				student.setSex(sex);
				student.setClassesId(cid);
				studentMapper.insert(student);
				StudentRoleKey record = new StudentRoleKey();
				record.setRoleId(roleId);
				record.setStudentId(sid);
				studentRoleMapper.insert(record);
			}
			return flag;
		} catch (Exception e) {
			flag = "0";
			return flag;
		}
	}
	/**
	 * 模板化代码
	 */
	@Override
	public void exportXlsStudent(HttpServletResponse response, HttpServletRequest request, String cid)
			throws Exception {
		List<TStudent> list = studentMapper.findAll(cid);
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = workbook.createSheet(list.get(0).getClasses().getClassname() + "学生信息");
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setWrapText(true);
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		// 第一行表头
		XSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("学号");
		headRow.createCell(1).setCellValue("姓名");
		headRow.createCell(2).setCellValue("密码");
		headRow.createCell(3).setCellValue("性别");
		headRow.createCell(4).setCellValue("户籍");
		headRow.createCell(5).setCellValue("班级");
		String classname = list.get(0).getClasses().getClassname();
		for (int i = 0; i < list.size(); i++) {
			XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(list.get(i).getSid());
			dataRow.createCell(1).setCellValue(list.get(i).getSname());
			dataRow.createCell(2).setCellValue(list.get(i).getPassword());
			dataRow.createCell(3).setCellValue(list.get(i).getSex());
			dataRow.createCell(4).setCellValue(list.get(i).getScity());
			dataRow.createCell(5).setCellValue(classname);
		}
		String filename = list.get(0).getClasses().getClassname() + "学生信息.xlsx";
		String agent = request.getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		// 一个流两个头
		ServletOutputStream out = response.getOutputStream();
		String contentType = request.getSession().getServletContext().getMimeType(filename);
		response.setContentType(contentType);
		response.setHeader("content-disposition", "attchment;filename=" + filename);
		workbook.write(out);
	}
}
