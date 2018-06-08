/**
 * The DmRoleRepository DmRoleRepository.java.
 *
 * @author mithleshs
 * @version 1.0
 * @since Jun 5, 2018
 */
package dm.spring.mvc.dmspringmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dm.spring.mvc.dmspringmvc.model.DmRole;

public interface DmRoleRepository extends JpaRepository<DmRole, Long> {

}
