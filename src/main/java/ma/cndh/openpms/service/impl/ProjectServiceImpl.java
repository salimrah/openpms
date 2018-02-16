package ma.cndh.openpms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.cndh.openpms.domain.Project;
import ma.cndh.openpms.repository.ProjectRepository;
import ma.cndh.openpms.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository ;

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project findOne(Integer id) {
		return projectRepository.findOne(id);
	}

	@Override
	public void create(Project p) {
		projectRepository.save(p);
	}

	@Override
	public void update(Integer id , Project p) {
		projectRepository.save(p);
	}
	
	@Override
	public void delete(Integer id) {
		projectRepository.delete(id);
	}
	
	
}
