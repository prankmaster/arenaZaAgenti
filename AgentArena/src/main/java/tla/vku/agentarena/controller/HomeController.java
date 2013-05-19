package tla.vku.agentarena.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tla.vku.agentarena.models.SubmitCodeModel;
import tla.vku.agentarena.services.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	public void initModel() {
		
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String sendCode(Locale locale, SubmitCodeModel pageModel) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String compileResult = homeService.compileCode(pageModel.getCode());

		logger.info(compileResult);
		return "home";
	}

}
