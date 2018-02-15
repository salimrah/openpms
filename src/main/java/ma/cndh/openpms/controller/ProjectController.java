package ma.cndh.openpms.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.cndh.openpms.domain.Project;
import ma.cndh.openpms.service.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService ;
	
	@GetMapping("/list")
	public String index(Model model,@RequestParam(required=false,defaultValue="MESSAGE DOESNT EXIST") String msg) {
		model.addAttribute("msg",msg);
		LOGGER.info("List of projects executed Queary param {}",msg);
		return "main" ;
	}
	
	@GetMapping("/listprj")
	@ResponseBody
	public List<Project> listProjects(){
		return  projectService.findAll();
	}
	
	@GetMapping("/test")
	@ResponseBody
	public List<String> test(){
		List<String> mylist = new ArrayList<>();
		mylist.add("String");
		mylist.add("hello");
		mylist.add("Test");
		return  mylist;
	}
	
	
	
}
