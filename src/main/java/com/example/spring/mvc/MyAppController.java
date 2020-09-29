package com.example.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/myapp")
public class MyAppController {
	
	
	/**
	 * URL: http://localhost:8080/<<CONTEXT_PATH>>/myapp/get1
	 * @return
	 */
	@GetMapping("/get1")
	public String method1(Model model) {
		model.addAttribute("id", "100");
		return "welcomePage";
	}
	
	
	/**
	 * URL: http://localhost:8080/<<CONTEXT_PATH>>/myapp/get2
	 * @return
	 */
	@GetMapping("/get2")
	public ModelAndView method2() {
		ModelAndView mvw = new ModelAndView("welcomePage");
		mvw.addObject("id", "500");
		return mvw;
	}
	
	
	/**
	 * URL: http://localhost:8080/<<CONTEXT_PATH>>/myapp/get3/1234
	 * Fetch studentId from path-variable
	 * @param studentId
	 * @return
	 */
	@GetMapping("/get3/{studentId}")
	public ModelAndView method3(@PathVariable String studentId) {
		ModelAndView mvw = new ModelAndView("welcomePage");
		mvw.addObject("id", studentId);
		return mvw;
	}
	
	
	/**
	 * URL: http://localhost:8080/<<CONTEXT_PATH>>/myapp/get4?id=999
	 * Fetch studentId from query-parameter
	 * @param studentId
	 * @return
	 */
	@GetMapping("/get4")
	public ModelAndView method4(@RequestParam(name="id", required=false) String studentId) {
		ModelAndView mvw = new ModelAndView("welcomePage");
		mvw.addObject("id", studentId);
		return mvw;
	}
	
	
	/**
	 * URL: http://localhost:8080/<<CONTEXT_PATH>>/myapp/save
	 * Fetch studentId from request-body
	 * @param student
	 * @return
	 */
	@PostMapping("/save")
	public ModelAndView method5(@RequestBody Student student) {
		ModelAndView mvw = new ModelAndView("welcomePage");
		mvw.addObject("id", student.getId());
		return mvw;
	}
	
	
	/**
	 * If any unhandled exception is generated from this controller, it is handled by this ExceptionHandler
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public String handle(Exception ex) {
		return "errorPage";
	}
	
}
