package hr.box.mobile.controller;

import hr.box.mobile.domain.Ocjene;
import hr.box.mobile.domain.OcjeneGrid;
import hr.box.mobile.service.OcjeneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@RequestMapping(value="/ocjene")
@Controller
public class OcjeneController {
	
	@Autowired
	OcjeneService ocjeneService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(){
		return "ocjene/list";
	}
	
	@RequestMapping(value="listgrid", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public OcjeneGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sortBy,
			@RequestParam(value = "sord", required = false) String order,
			@RequestParam(value = "comment", required = false) String comment,
			@RequestParam(value = "objektName", required = false) String objektName){
		
		if (comment == null) {
			comment = "%";
		} else{
			System.out.print(comment);
			comment = "%"+comment+"%";
		}
		
		if (objektName == null) {
			objektName = "%";
		} else {
			objektName = "%"+objektName+"%";
		}
		
		Sort sort = null;
		
		if (sortBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, sortBy);
			} else {
				sort = new Sort(Sort.Direction.ASC, sortBy);
			}
		}
		
		PageRequest pageRequest = null;
		
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}
		
		Page<Ocjene> ocjenePage = ocjeneService.findOcjeneByCriteria(comment, objektName, pageRequest);
		
		OcjeneGrid ocjeneGrid = new OcjeneGrid();
		
		ocjeneGrid.setCurrentPage(ocjenePage.getNumber() + 1);
		ocjeneGrid.setTotalPages(ocjenePage.getTotalPages());
		ocjeneGrid.setTotalRecords(ocjenePage.getTotalElements());
		ocjeneGrid.setOcjeneData(Lists.newArrayList(ocjenePage.iterator()));
		
		return ocjeneGrid;
	}
	
	
	@RequestMapping(value="/del", method=RequestMethod.POST)
	public String delete(@RequestParam("id") int id){
		ocjeneService.delete(id);
		return "ocjene/list";
	}
	
}
