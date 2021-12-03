package com.example.easypoidemo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.alibaba.fastjson.JSON;
import com.example.easypoidemo.controller.dto.ResponseBody;
import com.example.easypoidemo.exception.BizException;
import com.example.easypoidemo.pojo.Student;
import com.example.easypoidemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/10/22 14:38
 * @description：文件控制器
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/file")
public class ExcelProcessController {

    @RequestMapping("/upload-excel")
    public ResponseBody upload(@RequestParam("file") MultipartFile upload){
        try {
            ImportParams importParams = new ImportParams();
            //设置需要校验
            importParams.setNeedVerify(true);
            //从excel表格中提取数据
            List<Student> studentList = ExcelImportUtil.importExcel(upload.getInputStream(), Student.class, importParams);
            //处理业务逻辑，这儿用打印对象替代
            System.out.println(JSON.toJSON(studentList));
        }catch (Exception ex){
            return ResponseBody.build(500,null);
        }
        return ResponseBody.buildSuccess();
    }

    @RequestMapping("/download")
    public ResponseBody download(HttpServletResponse response) throws BizException {
        //构造数据
        List<Student> students=new ArrayList<>();
        students.add(Student.builder().name("张三").age(18).sex(false).school("PKU").studentNum(1).build());
        students.add(Student.builder().name("赵六").age(20).sex(true).school("THU").studentNum(2).build());

        //设置导出参数
        ExportParams params=new ExportParams();
        //设置excel类型，XSSF代表xlsx，HSSF代表xls
        params.setType(ExcelType.XSSF);
        Workbook workbook= ExcelExportUtil.exportExcel(params,Student.class,students);
        String fileName="student.xlsx";
        //将文件存入response对象中
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type","application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
            response.flushBuffer();
        }catch (IOException ex){
            //log
            //throw new BizException(ex.getMessage());
        }
        return ResponseBody.buildSuccess();
    }

}
