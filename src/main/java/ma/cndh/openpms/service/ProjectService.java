package ma.cndh.openpms.service;

import java.util.List;

import ma.cndh.openpms.domain.Project;


public interface ProjectService {
	public List<Project> findAll();
	public Project findOne(Integer id);
	public void create(Project p);
	public void update(Integer id , Project p);
	public void delete(Integer id);

}
