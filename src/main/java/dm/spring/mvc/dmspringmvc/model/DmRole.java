package dm.spring.mvc.dmspringmvc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the DM_ROLES database table.
 * 
 */
@Entity
@Table(name = "DM_ROLES")
@NamedQuery(name = "DmRole.findAll", query = "SELECT d FROM DmRole d")
public class DmRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name = "\"ROLE\"")
	private String role;

	// bi-directional many-to-one association to DmEmployee
	@ManyToOne
	@JoinColumn(name = "DM_EMPLOYEE_ID")
	private DmEmployee dmEmployee;

	public DmRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public DmEmployee getDmEmployee() {
		return this.dmEmployee;
	}

	public void setDmEmployee(DmEmployee dmEmployee) {
		this.dmEmployee = dmEmployee;
	}

}