package hr.box.mobile.controller;

import javax.validation.Valid;

import hr.box.mobile.domain.Kategorija;
import hr.box.mobile.service.KategorijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/kategorija")
@Controller
public class KategorijaController {
	
	@Autowired
	private KategorijaService kategorijaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listKategorija(Model model){
		model.addAttribute("listaKategorija", kategorijaService.findAll());
		return "kategorija/list";
	}
	
	@RequestMapping(params="form",method=RequestMethod.GET)
	public String createForm(Model model){
		model.addAttribute("kategorija", new Kategorija());
		return "kategorija/create";
	}
	
	@RequestMapping(params="form",method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute Kategorija kategorija, BindingResult results, Model model){
		if (results.hasErrors()) return "kategorija/create";
		kategorijaService.save(kategorija);
		model.addAttribute("kategorija", new Kategorija());
		model.addAttribute("uneseno", "Podaci su uspješno uneseni!");
		return "kategorija/create";
	}
	
	@RequestMapping(value="/{id}",params="form",method=RequestMethod.GET)
	public String updateForm(@PathVariable int id, Model model){
		model.addAttribute("kategorija", kategorijaService.findById(id));
		return "kategorija/create";
	}
	
	@RequestMapping(value="/{id}",params="form",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Valid @ModelAttribute Kategorija kategorija, BindingResult results, Model model){
		if (results.hasErrors()) return "kategorija/create";
		kategorijaService.save(kategorija);
		model.addAttribute("kategorija", kategorijaService.findById(id));
		model.addAttribute("uneseno", "Podaci su uspješno promijenjeni!");
		return "kategorija/create";
	}
	
	@RequestMapping(value="/{id}",params="delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id,Model model){
		Kategorija kategorija = kategorijaService.findById(id);
		kategorijaService.delete(kategorija);
		model.addAttribute("listaKategorija", kategorijaService.findAll());
		return "kategorija/list";
	}
}
