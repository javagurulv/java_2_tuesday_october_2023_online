package lv.javaguru.java2.lessoncode.book.app.web_ui.controllers;

import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.UpdateReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.UpdateReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateReaderController {

	@Autowired private UpdateReaderService updateReaderService;


	@GetMapping(value = "/updateReader")
	public String showUpdateReaderPage(ModelMap modelMap) {
		modelMap.addAttribute("request", new UpdateReaderRequest());
		return "updateReader";
	}

	@PostMapping("/updateReader")
	public String processUpdateReaderRequest(@ModelAttribute(value = "request") UpdateReaderRequest request, ModelMap modelMap) {
		UpdateReaderResponse response = updateReaderService.execute(request);
		if (response.containsErrors()) {
			modelMap.addAttribute("errors", response.getErrors());
			return "updateReader";
		} else {
			return "redirect:/";
		}
	}

}
