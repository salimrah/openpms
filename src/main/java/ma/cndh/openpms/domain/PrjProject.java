package ma.cndh.openpms.domain;


import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "prj_project")
@NamedQueries({
    @NamedQuery(name = "PrjProject.findAll", query = "SELECT p FROM PrjProject p")})
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt","tskTaskList","assignedTo","prjStatusId"},allowGetters = true)
public class PrjProject {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "short_name")
    private String shortName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expected_start_date")
    @Temporal(TemporalType.DATE)
    private Date expectedStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expected_end_date")
    @Temporal(TemporalType.DATE)
    private Date expectedEndDate;
    @Column(name = "actual_start_date")
    @Temporal(TemporalType.DATE)
    private Date actualStartDate;
    @Column(name = "actual_end_date")
    @Temporal(TemporalType.DATE)
    private Date actualEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "open_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openDate;
    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "update_by")
    private Integer updateBy;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjProjectId")
    @JsonIgnore
    private List<TskTask> tskTaskList;
    @JoinColumn(name = "assigned_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private UsUsers assignedTo;
    @JoinColumn(name = "prj_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private PrjStatus prjStatusId;

    public PrjProject() {
    }

    public PrjProject(Integer id) {
        this.id = id;
    }

    public PrjProject(Integer id, String shortName, String description, Date expectedStartDate, Date expectedEndDate, Date openDate) {
        this.id = id;
        this.shortName = shortName;
        this.description = description;
        this.expectedStartDate = expectedStartDate;
        this.expectedEndDate = expectedEndDate;
        this.openDate = openDate;
    }

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

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @XmlTransient
    public List<TskTask> getTskTaskList() {
        return tskTaskList;
    }

    public void setTskTaskList(List<TskTask> tskTaskList) {
        this.tskTaskList = tskTaskList;
    }

    public UsUsers getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UsUsers assignedTo) {
        this.assignedTo = assignedTo;
    }

    public PrjStatus getPrjStatusId() {
        return prjStatusId;
    }

    public void setPrjStatusId(PrjStatus prjStatusId) {
        this.prjStatusId = prjStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrjProject)) {
            return false;
        }
        PrjProject other = (PrjProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.PrjProject[ id=" + id + " ]";
    }
    
}
