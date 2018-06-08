/**
 *
 * @author mithleshs
 * @version 1.0
 * @since Jun 7, 2018
 */
package dm.spring.mvc.dmspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dm.spring.mvc.dmspringmvc.model.DmEmployee;
import dm.spring.mvc.dmspringmvc.service.DmService;

@Controller
public class DmController {

	@Autowired
	DmService dmService;

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("message", "Hello");
		model.addObject("name", "DM");
		return model;
	}

	@RequestMapping(value = "/allUser")
	@ResponseBody
	public List<DmEmployee> getAllUsers() {

		return dmService.getAllUsers();
	}
}
