 package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private FoodService service;

	@RequestMapping("/")
	public String homePage(Model model, @Param("keyword") String keyword) {
		List<Menu> listmenu = service.listall(keyword);
		model.addAttribute("listmenu", listmenu);
		model.addAttribute("keyword", keyword);
		return "index";
	}

	@RequestMapping("/Todays_Special")
	public String special(Model model) {
		Menu menu = new Menu();
		model.addAttribute("menu", menu);
		return "Todays_Special";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)

	public String save(@ModelAttribute("menu") Menu menu) {
		service.save(menu);
		return "redirect:/";

	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editMenu(@PathVariable(name = "id") Long id) {
		ModelAndView mv = new ModelAndView("Edit_Menu");
		Menu menu = service.get(id);
		mv.addObject("menu", menu);
		return mv;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}

	@GetMapping("/Search")
	public String search(@RequestParam Optional<String> keyword) {
		return "Search";

		
	}
}
