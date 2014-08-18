package hr.box.mobile.restful.controller;

import hr.box.mobile.domain.Instanca;
import hr.box.mobile.domain.Ocjene;
import hr.box.mobile.service.InstancaService;
import hr.box.mobile.service.OcjeneService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;

@Controller
public class RestController {
	
	@Autowired
	private InstancaService instancaService;
	
	@Autowired
	private OcjeneService ocjeneService;
	
	@RequestMapping(value = "/objekts/{ids}/instancas", method = RequestMethod.GET)
	@ResponseBody
	public List<Instanca> listInstanca(@PathVariable Integer[] ids){
		return instancaService.findByObjektIds(ids);
	}
		
	@RequestMapping(value="/ocjenes", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Ocjene create(@RequestBody Ocjene ocjene){
		ocjeneService.save(ocjene);
		return ocjene;
	}
	
	@RequestMapping(value="/objekts/{id}/ocjenes", method = RequestMethod.GET)
	@ResponseBody
	public List<Ocjene> listOcjeneByPage(@PathVariable int id, 
										 @RequestParam("page") int page){
		
		Sort sort = new Sort(Sort.Direction.DESC, "date");
		PageRequest pageRequest = new PageRequest(page - 1, 10, sort);
		return Lists.newArrayList(ocjeneService.findByObjektId(id, pageRequest));
		
	}
	
	@RequestMapping(value="/ocjenes/{id}", method = RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Ocjene update(@RequestBody Ocjene ocjene, @PathVariable int id){
		ocjene.setId(id);
		ocjeneService.save(ocjene);
		return ocjene;
	}
	
	@RequestMapping(value="/ocjenes/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id){
		ocjeneService.delete(id);
	}
	
	
	
}
