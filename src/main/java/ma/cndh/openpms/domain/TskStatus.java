package ma.cndh.openpms.domain;

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
@Table(name = "tsk_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TskStatus.findAll", query = "SELECT t FROM TskStatus t")})
public class TskStatus implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tskStatusId")
    private List<TskTask> tskTaskList;

    public TskStatus() {
    }

    public TskStatus(Integer id) {
        this.id = id;
    }

    public TskStatus(Integer id, String description, Character archived) {
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
    public List<TskTask> getTskTaskList() {
        return tskTaskList;
    }

    public void setTskTaskList(List<TskTask> tskTaskList) {
        this.tskTaskList = tskTaskList;
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
        if (!(object instanceof TskStatus)) {
            return false;
        }
        TskStatus other = (TskStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.TskStatus[ id=" + id + " ]";
    }
    
}
