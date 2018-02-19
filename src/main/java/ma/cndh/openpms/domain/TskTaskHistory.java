package ma.cndh.openpms.domain;

// default package
// Generated Feb 17, 2018 1:58:18 AM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "tsk_task_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TskTaskHistory.findAll", query = "SELECT t FROM TskTaskHistory t")})
public class TskTaskHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tsk_task_id")
    private int tskTaskId;
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
    @Column(name = "tsk_status_id")
    private int tskStatusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prj_project_id")
    private int prjProjectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assigned_to")
    private int assignedTo;
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

    public TskTaskHistory() {
    }

    public TskTaskHistory(Integer id) {
        this.id = id;
    }

    public TskTaskHistory(Integer id, int tskTaskId, String shortName, String description, int tskStatusId, int prjProjectId, int assignedTo, Date expectedStartDate, Date expectedEndDate, Date openDate) {
        this.id = id;
        this.tskTaskId = tskTaskId;
        this.shortName = shortName;
        this.description = description;
        this.tskStatusId = tskStatusId;
        this.prjProjectId = prjProjectId;
        this.assignedTo = assignedTo;
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

    public int getTskTaskId() {
        return tskTaskId;
    }

    public void setTskTaskId(int tskTaskId) {
        this.tskTaskId = tskTaskId;
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

    public int getTskStatusId() {
        return tskStatusId;
    }

    public void setTskStatusId(int tskStatusId) {
        this.tskStatusId = tskStatusId;
    }

    public int getPrjProjectId() {
        return prjProjectId;
    }

    public void setPrjProjectId(int prjProjectId) {
        this.prjProjectId = prjProjectId;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TskTaskHistory)) {
            return false;
        }
        TskTaskHistory other = (TskTaskHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.TskTaskHistory[ id=" + id + " ]";
    }
    
}
