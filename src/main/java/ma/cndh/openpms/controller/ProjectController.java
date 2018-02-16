package ma.cndh.openpms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.cndh.openpms.domain.Project;
import ma.cndh.openpms.service.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService ;
	
	@GetMapping({"/","/index"})
	@ResponseBody
	public List<Project> index() {
		return projectService.findAll() ;
	}
	
	@GetMapping("/{id}/view")
	@ResponseBody
	public Project findById(@PathVariable Integer id) {
		return projectService.findOne(id);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public void create(@RequestBody Project project) {
		LOGGER.debug("creating new project .... {}",project.toString());
		System.out.println("show values : "+project.toString());
		projectService.create(project);
	}
	
}
