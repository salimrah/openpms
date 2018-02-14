package ma.cndh.openpms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@GetMapping("/list")
	@ResponseBody
	public String index() {
		return "<h1>Project's List :</h1>" ;
	}
	
}
