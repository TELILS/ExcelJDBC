package com.langsin.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.langsin.service.ExcelService;



@Controller
public class ExcelCon {
	
	@Autowired
	ExcelService service;
	/**
	 * 初始界面
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/exceltrans.action") //url
	public ModelAndView exceltrans(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model  model) {
		ModelAndView modelAndView = new ModelAndView();  //视图对象
		modelAndView.setViewName("exceltrans");  //展示页面
		return modelAndView;
	}
	/**
	 * 上传Excel文件
	 * @param file
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/uploadexcel.action") //url
	public ModelAndView uploadexcel(MultipartFile file,HttpServletRequest request, HttpServletResponse response, HttpSession session, Model  model) {
		ModelAndView modelAndView = new ModelAndView();   //视图对象
		Boolean flag = false;    //结果判断标记
		String fileName = file.getOriginalFilename();  //获取Excel文件名
		try {
			flag = service.batchImport(fileName, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag==false) {  //判断上传结果
			modelAndView.addObject("message","上传失败，请重试");
		}else {
			modelAndView.addObject("message","上传成功");
		}
		modelAndView.setViewName("exceltrans"); //视图名称
		return modelAndView;
	}
}
