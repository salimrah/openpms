package ma.cndh.openms.helper;

import java.io.Serializable;

import ma.cndh.openpms.domain.PrjProject;
import ma.cndh.openpms.domain.PrjStatus;

public class PrjProjectHelper implements Serializable {
	
	private PrjProject prjProject;
	private int id;
	private String description;
	private PrjStatus prjStatus;

	public PrjProject getPrjProject() {
		return prjProject;
	}

	public void setPrjProject(PrjProject prjProject) {
		this.prjProject = prjProject;
	}

	public PrjProjectHelper() {
		super();
	}

	public PrjProjectHelper(PrjProject prjProject) {
		super();
		this.prjProject = prjProject;
	}

	public PrjProjectHelper(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public PrjProjectHelper(int id, String description,PrjStatus prjStatus) {
		super();
		this.id = id;
		this.description = description;
		this.prjStatus=prjStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PrjStatus getPrjStatus() {
		return prjStatus;
	}

	public void setPrjStatus(PrjStatus prjStatus) {
		this.prjStatus = prjStatus;
	}
	
	
	

}
