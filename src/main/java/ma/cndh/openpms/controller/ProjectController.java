package ma.cndh.openpms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	@GetMapping("/list")
	public String index(Model model,@RequestParam(required=false,defaultValue="MESSAGE DOESNT EXIST") String msg) {
		model.addAttribute("msg",msg);
		LOGGER.info("List of projects executed Queary param {}",msg);
		return "main" ;
	}
	
}
