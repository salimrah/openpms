package ma.cndh.openpms.domain;

// default package
// Generated Feb 17, 2018 1:58:18 AM by Hibernate Tools 5.2.8.Final

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "prj_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrjStatus.findAll", query = "SELECT p FROM PrjStatus p")})
public class PrjStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "archived")
    private Character archived;
    @Column(name = "sortingKey")
    private Integer sortingKey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjStatusId")
    private List<PrjProject> prjProjectList;

    public PrjStatus() {
    }

    public PrjStatus(Integer id) {
        this.id = id;
    }

    public PrjStatus(Integer id, String description, Character archived) {
        this.id = id;
        this.description = description;
        this.archived = archived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getArchived() {
        return archived;
    }

    public void setArchived(Character archived) {
        this.archived = archived;
    }

    public Integer getSortingKey() {
        return sortingKey;
    }

    public void setSortingKey(Integer sortingKey) {
        this.sortingKey = sortingKey;
    }

    @XmlTransient
    public List<PrjProject> getPrjProjectList() {
        return prjProjectList;
    }

    public void setPrjProjectList(List<PrjProject> prjProjectList) {
        this.prjProjectList = prjProjectList;
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
        if (!(object instanceof PrjStatus)) {
            return false;
        }
        PrjStatus other = (PrjStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.PrjStatus[ id=" + id + " ]";
    }
    
}
