package ma.cndh.openpms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.cndh.openpms.domain.PrjProject;


@Repository
public interface ProjectRepository extends JpaRepository<PrjProject, Integer>{

}
