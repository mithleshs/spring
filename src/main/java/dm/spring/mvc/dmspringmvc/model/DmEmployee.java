package dm.spring.mvc.dmspringmvc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the DM_EMPLOYEE database table.
 * 
 */
@Entity
@Table(name = "DM_EMPLOYEE")
@NamedQuery(name = "DmEmployee.findAll", query = "SELECT d FROM DmEmployee d")
public class DmEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String isactive;

	private String password;

	private String username;

	// bi-directional many-to-one association to DmRole
	@OneToMany(mappedBy = "dmEmployee")
	private List<DmRole> dmRoles;

	public DmEmployee() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<DmRole> getDmRoles() {
		return this.dmRoles;
	}

	public void setDmRoles(List<DmRole> dmRoles) {
		this.dmRoles = dmRoles;
	}

	public DmRole addDmRole(DmRole dmRole) {
		getDmRoles().add(dmRole);
		dmRole.setDmEmployee(this);

		return dmRole;
	}

	public DmRole removeDmRole(DmRole dmRole) {
		getDmRoles().remove(dmRole);
		dmRole.setDmEmployee(null);

		return dmRole;
	}

}