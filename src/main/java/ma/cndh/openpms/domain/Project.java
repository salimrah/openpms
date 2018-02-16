package ma.cndh.openpms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@Entity
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
@Table(name="projects")
public class Project {
	
	/*********
	 * `id` INT(11) NOT NULL AUTO_INCREMENT,
	`short_name` VARCHAR(5) NOT NULL,
	`description` TEXT NOT NULL,
	`prj_status_id` INT(11) NOT NULL,
	`expected_start_date` DATE NOT NULL,
	`expected_end_date` DATE NOT NULL,
	`actual_start_date` DATE,
	`actual_end_date` DATE,
	`open_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_date` DATE ,
	`created_by` INT(11),
	`update_by` INT(11),
	PRIMARY KEY (`id`)
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	
	@Column(nullable = false ,length=5)
	@NotBlank
	private String shortName ;
	
	@Type(type="text")
	@Column(nullable = false)
	@NotBlank
	private String description ;
	
	@Column(nullable = false)
    @Temporal(TemporalType.DATE)
	private Date expectedStartDate ;
	
	@Column(nullable = false)
    @Temporal(TemporalType.DATE)
	private Date expectedEndDate ;
	
	@Column(nullable = false)
    @Temporal(TemporalType.DATE)
	private Date actualStartDate ;
	
	@Column(nullable = false)
    @Temporal(TemporalType.DATE)
	private Date actualEndDate ;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false,columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpectedStartDate() {
		return expectedStartDate;
	}

	public void setExpectedStartDate(Date expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public Date getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", shortName=" + shortName + ", description=" + description
				+ ", expectedStartDate=" + expectedStartDate + ", expectedEndDate=" + expectedEndDate
				+ ", actualStartDate=" + actualStartDate + ", actualEndDate=" + actualEndDate + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
