package ma.cndh.openpms.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ma.cndh.openpms.domain.PrjProject;
import ma.cndh.openpms.repository.ProjectRepository;
import ma.cndh.openpms.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository ;

	@Override
	public List<PrjProject> findAll() {
		return projectRepository.findAll();
	}

	

	@Override
	public PrjProject findOne(Integer id) {
		
		return projectRepository.findOne(id);
	}

	@Override
	public void create(PrjProject p) {
		projectRepository.save(p);
		
	}



	@Override
	public List<PrjProject> findall(int size) {
		List<PrjProject> listprj = new ArrayList<>();
		Iterator<PrjProject> it = projectRepository.findAll(new PageRequest(0, size)).iterator();
		while(it.hasNext()) {
			listprj.add(it.next());
		}
		return  listprj ;
		
	}
	
}
