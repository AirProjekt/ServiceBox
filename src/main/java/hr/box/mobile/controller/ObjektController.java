package hr.box.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import hr.box.mobile.domain.Kategorija;
import hr.box.mobile.domain.Objekt;
import hr.box.mobile.service.KategorijaService;
import hr.box.mobile.service.ObjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(value="/objekt")
@Controller
public class ObjektController {
	
	@ModelAttribute("listaKategorija")
	public List<Kategorija> getListaKategorija(){
		return kategorijaService.findAll();
	}
	
	@Autowired
	private ObjektService objektService;
	
	@Autowired
	private KategorijaService kategorijaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listObjekt(Model model){
		return "objekt/list";
	}
	
	@RequestMapping(params="form",method=RequestMethod.GET)
	public String createForm(Model model){
		model.addAttribute("objekt", new Objekt());
		return "objekt/create";
	}
	
	@RequestMapping(params="form",method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute Objekt objekt, BindingResult results, Model model){
		if (results.hasErrors()) return "objekt/create";
		objektService.save(objekt);
		model.addAttribute("objekt", new Objekt());
		model.addAttribute("uneseno", "Podaci su uspješno uneseni!");
		return "objekt/create";
	}
	
	@RequestMapping(value="/{id}",params="form",method=RequestMethod.GET)
	public String updateForm(@PathVariable int id, Model model){
		model.addAttribute("objekt", objektService.findById(id));
		return "objekt/create";
	}
	
	@RequestMapping(value="/{id}",params="form",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Valid @ModelAttribute Objekt objekt, BindingResult results, Model model){
		if (results.hasErrors()) return "objekt/create";
		objektService.save(objekt);
		model.addAttribute("objekt", objektService.findById(id));
		model.addAttribute("uneseno", "Podaci su uspješno promijenjeni!");
		return "objekt/create";
	}
	
	@RequestMapping(params="delete",method=RequestMethod.POST)
	public String delete(@RequestParam int id,Model model){
		Objekt objekt = objektService.findById(id);
		int idKategorija = objekt.getKategorija().getId();
		objektService.delete(objekt);
		model.addAttribute("listaObjekt", objektService.findByKategorijaId(idKategorija));
		return "objekt/ajaxsource";
	}
	
	@RequestMapping(params="ajax",method=RequestMethod.POST)
	public String ajax(@RequestParam("id")int id,Model model){
		if(id == 0){
			model.addAttribute("listaObjekt", new ArrayList<Objekt>());
			return "objekt/ajaxsource";
		}
		model.addAttribute("listaObjekt", objektService.findByKategorijaId(id));
		return "objekt/ajaxsource";
	}
}
