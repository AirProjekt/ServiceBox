package hr.box.mobile.controller;

import hr.box.mobile.domain.Instanca;
import hr.box.mobile.domain.Objekt;
import hr.box.mobile.service.InstancaService;
import hr.box.mobile.service.ObjektService;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value="/instanca")
@Controller
public class InstancaController {
	
	@ModelAttribute("listaObjekt")
	public List<Objekt> getListaObjekt(){
		return objektService.findAll();
	}
	
	@Autowired
	private InstancaService instancaService;
	
	@Autowired
	private ObjektService objektService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listInstanca(Model model){
		return "instanca/list";
	}
	
	@RequestMapping(params="form",method=RequestMethod.GET)
	public String createForm(Model model){
		model.addAttribute("instanca", new Instanca());
		return "instanca/create";
	}
	
	@RequestMapping(params="form",method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute Instanca instanca, BindingResult results, Model model){
		if (results.hasErrors()) return "instanca/create";
		instancaService.save(instanca);
		model.addAttribute("instanca", new Instanca());
		model.addAttribute("uneseno", "Podaci su uspješno uneseni!");
		return "instanca/create";
	}
	
	@RequestMapping(value="/{id}",params="form",method=RequestMethod.GET)
	public String updateForm(@PathVariable int id, Model model){
		model.addAttribute("instanca", instancaService.findById(id));
		return "instanca/create";
	}
	
	@RequestMapping(value="/{id}",params="form",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Valid @ModelAttribute Instanca instanca, BindingResult results, Model model){
		if (results.hasErrors()) return "instanca/create";
		instancaService.save(instanca);
		model.addAttribute("instanca", instancaService.findById(id));
		model.addAttribute("uneseno", "Podaci su uspješno promijenjeni!");
		return "instanca/create";
	}
	
	@RequestMapping(params="delete",method=RequestMethod.POST)
	public String delete(@RequestParam int id,Model model){
		Instanca instanca = instancaService.findById(id);
		int idObjekt = instanca.getObjekt().getId();
		instancaService.delete(instanca);;
		model.addAttribute("listaInstanca", instancaService.findByObjektId(idObjekt));
		return "instanca/ajaxsource";
	}
	
	@RequestMapping(params="ajax",method=RequestMethod.POST)
	public String ajax(@RequestParam("id")int id,Model model){
		if(id == 0){
			model.addAttribute("listaInstanca", new ArrayList<Instanca>());
			return "instanca/ajaxsource";
		}
		model.addAttribute("listaInstanca", instancaService.findByObjektId(id));
		return "instanca/ajaxsource";
	}
}
