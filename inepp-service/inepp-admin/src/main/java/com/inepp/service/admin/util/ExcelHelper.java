package com.inepp.service.admin.util;






import com.inepp.domain.entity.GrantPrivs;
import com.inepp.domain.entity.Privs;
import com.inepp.domain.entity.Role;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ExcelHelper
 * @Author
 * @Date 2022/4/3
 */

public class ExcelHelper<T> {
    private XSSFWorkbook excel;

    public ExcelHelper(InputStream in) {
        try {
            excel = new XSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @SneakyThrows
    public List<T> parse(String sheetName,Class<?> clazz){
        List<T> list = new ArrayList<>();
        XSSFSheet sheet = excel.getSheet(sheetName);//根据名称 拿到指定页面
        XSSFRow firstRow = sheet.getRow(0);//得到第一行
        List<String> names = new ArrayList<>();

        short lastCellNum = firstRow.getLastCellNum();//列数

        for (int i = 0 ; i < lastCellNum; i++){
            XSSFCell cell = firstRow.getCell(i);

            names.add(cell.getStringCellValue());//将第一行的名称存入
        }

        //将每一行封装成一个对象存入list集合
        System.out.println(sheet.getLastRowNum());
        for (int tr =1;tr<=sheet.getLastRowNum();tr++){
            XSSFRow row = sheet.getRow(tr);//拿到每一行的数据
            T obj = (T)clazz.newInstance();//拿到对象

            //拿到每一行的值 存入对象
            for (int td = 0;td<lastCellNum;td++){
                String fieldName = names.get(td);//根据列拿到列名

                Field field = clazz.getDeclaredField(fieldName);//根据列名拿到域对象
                field.setAccessible(true);
                XSSFCell cell = row.getCell(td);//拿到本列的数据

                switch (cell.getCellType()){
                    case STRING:  //字符串
                        String str = cell.getStringCellValue();
                        field.set(obj,str);
                        break;
                    case NUMERIC:
                        if(DateUtil.isCellDateFormatted(cell)){ //日期
                            field.set(obj,cell.getDateCellValue());
                        }else{//数字
                            field.set(obj,(int)cell.getNumericCellValue());
                        }
                        break;
                }


            }
            list.add(obj);
        }
        return list;
    }

    public static void main(String[] args)  {

        InputStream in = null;
        try  {
            in = new FileInputStream("D:\\idea-workspace\\inepp\\admin.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<GrantPrivs> lists= new ExcelHelper<GrantPrivs>(in).parse("gp", GrantPrivs.class);
       // List<Role> gps= new ExcelHelper<Role>(in).parse("role", Role.class);
        // System.out.println(list);
        System.out.println(lists);
    }

}
