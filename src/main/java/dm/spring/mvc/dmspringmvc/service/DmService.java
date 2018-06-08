/**
 * The DmService DmService.java.
 *
 * @author mithleshs
 * @version 1.0
 * @since Jun 7, 2018
 */
package dm.spring.mvc.dmspringmvc.service;

import java.util.List;

import dm.spring.mvc.dmspringmvc.model.DmEmployee;

public interface DmService {

	List<DmEmployee> getAllUsers();
}
