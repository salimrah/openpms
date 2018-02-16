package ma.cndh.openpms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.cndh.openpms.domain.Project;
import ma.cndh.openpms.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;

	@GetMapping("/")
	public List<Project> index() {
		return projectService.findAll();
	}

	@GetMapping("/show/{id}")
	public Project view(@PathVariable Integer id) {
		return projectService.findOne(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Project project) {
		LOGGER.info("creating new project .... {}", project.toString());
		projectService.create(project);
	}

	@PutMapping("/edit/{id}")
	public void edit(@RequestBody Project project ,@PathVariable Integer id) {
		projectService.update(id, project);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		projectService.delete(id);
	}
}
