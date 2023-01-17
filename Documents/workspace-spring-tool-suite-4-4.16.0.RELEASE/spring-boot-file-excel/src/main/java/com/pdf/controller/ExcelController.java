package com.pdf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.entity.Users;
import com.pdf.excel.ExcelExport;
import com.pdf.excel.ExcelImport;
import com.pdf.excelrepository.ExcelRepository;



@RestController
public class ExcelController {
	
@Autowired
private ExcelRepository excelRepository;

@GetMapping("/getExcel")
public String exportExcel(HttpServletResponse response)throws IOException{
	response.setContentType("application/octet-stream");
	String headerKey="Content-Disposition";
	String headerValue="attachment;filename=Employee.xlsx";
	response.setHeader(headerKey, headerValue);
	List<Users> employees=excelRepository.findAll();
	ExcelExport Exp=new ExcelExport(employees);
	Exp.export(response);
	return "coverted successfuly";
}

@PostMapping("/addExcel")
public String importExcel() {
	ExcelImport importE =new ExcelImport();
	List<Users> employee=importE.ExcelImport();
	excelRepository.saveAll(employee);
	return "done";
	
}
@PostMapping("adddata")
public String adddata(@RequestBody Users users)
{
 excelRepository.save(users);
	
	return"Added Succesfully";
}


}
