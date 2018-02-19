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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "us_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsUsers.findAll", query = "SELECT u FROM UsUsers u")})
public class UsUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "user_name")
    private String userName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "family_name")
    private String familyName;
    @Size(max = 200)
    @Column(name = "adress")
    private String adress;
    @Size(max = 10)
    @Column(name = "tel")
    private String tel;
    @Size(max = 150)
    @Column(name = "url_picture")
    private String urlPicture;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedTo")
    private List<TskTask> tskTaskList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedTo")
    private List<PrjProject> prjProjectList;
    @JoinColumn(name = "us_status_id", referencedColumnName = "id")
    @ManyToOne
    private UsStatus usStatusId;

    public UsUsers() {
    }

    public UsUsers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    @XmlTransient
    public List<TskTask> getTskTaskList() {
        return tskTaskList;
    }

    public void setTskTaskList(List<TskTask> tskTaskList) {
        this.tskTaskList = tskTaskList;
    }

    @XmlTransient
    public List<PrjProject> getPrjProjectList() {
        return prjProjectList;
    }

    public void setPrjProjectList(List<PrjProject> prjProjectList) {
        this.prjProjectList = prjProjectList;
    }

    public UsStatus getUsStatusId() {
        return usStatusId;
    }

    public void setUsStatusId(UsStatus usStatusId) {
        this.usStatusId = usStatusId;
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
        if (!(object instanceof UsUsers)) {
            return false;
        }
        UsUsers other = (UsUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.UsUsers[ id=" + id + " ]";
    }
    
}
