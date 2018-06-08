/**
 * The DmServiceImpl DmServiceImpl.java.
 *
 * @author mithleshs
 * @version 1.0
 * @since Jun 7, 2018
 */
package dm.spring.mvc.dmspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dm.spring.mvc.dmspringmvc.model.DmEmployee;
import dm.spring.mvc.dmspringmvc.repository.DmEmployeeRepository;

@Service
public class DmServiceImpl implements DmService {

	@Autowired
	DmEmployeeRepository dmEmployeeRepository;
	
	@Override
	public List<DmEmployee> getAllUsers() {
		return dmEmployeeRepository.findAll();
	}

}
