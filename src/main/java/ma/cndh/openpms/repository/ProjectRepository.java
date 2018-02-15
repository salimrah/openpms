package ma.cndh.openpms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.cndh.openpms.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
