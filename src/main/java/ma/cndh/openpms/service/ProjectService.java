package ma.cndh.openpms.service;

import java.util.List;

import ma.cndh.openpms.domain.PrjProject;



public interface ProjectService {
	public List<PrjProject> findAll();
	public PrjProject findOne(Integer id);
	public void create(PrjProject p);
	public List<PrjProject> findall(int size);

}
