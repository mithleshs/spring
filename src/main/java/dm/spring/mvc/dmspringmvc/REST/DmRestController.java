/**
 * The DmController DmController.java.
 *
 * @author mithleshs
 * @version 1.0
 * @since Jun 7, 2018
 */
package dm.spring.mvc.dmspringmvc.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dm.spring.mvc.dmspringmvc.model.DmEmployee;
import dm.spring.mvc.dmspringmvc.service.DmService;

@RestController
@RequestMapping(value = "/api")
public class DmRestController {

	@Autowired
	DmService dmService;
	
	@CrossOrigin
	@GetMapping(value = "/allUser",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DmEmployee> getAllUsers() {

		return dmService.getAllUsers();
	}
}
