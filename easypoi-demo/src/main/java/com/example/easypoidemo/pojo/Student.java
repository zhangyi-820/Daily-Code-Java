package com.example.easypoidemo.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import com.example.easypoidemo.pojo.validate.StudentNumCheck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/10/28 10:27
 * @description：学生实体类
 * @modified By：
 * @version:
 */
@Data
@Builder
public class Student implements IExcelDataModel, IExcelModel {
    @Excel(name = "姓名")
    //使用hibernate中的校验注解
    @NotNull
    private String name;

    @Excel(name = "性别",replace = {"男_false","女_true"})
    private Boolean sex;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "学号")
    //自定义校验
    @StudentNumCheck
    private Integer studentNum;

    @Excel(name = "学校")
    private String school;

    private Integer rowNum;

    //错误信息
    private String errorMsg;

    @Override
    public int getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(int i) {
        this.rowNum=i;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String s) {
        if(Objects.isNull(this.errorMsg)){
            this.errorMsg=s;
        }else{
            this.errorMsg=this.errorMsg+s;
        }
    }
}
