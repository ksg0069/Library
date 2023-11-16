package com.lib.fin.facility;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lib.fin.commons.Pager;
import com.lib.fin.schedule.ScheduleVO;

@Controller
@RequestMapping("/facility/*")
public class FacilityControl {
	@Autowired
	private FacilityService facilityService;
	
	@GetMapping("getFacilitylist")
	public ModelAndView getFacility(Pager pager,ModelAndView mv) throws Exception {
		List<FacilityVO> ar=facilityService.getFacilityList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("facility/facilitylist");
		return mv;
	}
	@PostMapping("add")
	public String setFacilityAdd(HttpServletRequest request, FacilityVO facilityVO)throws Exception{ 
			        
		 int result = facilityService.setFacilityAdd(facilityVO);
		
		 return "redirect:./getFacilitylist";
	}
		
	
	@PostMapping("update")
	public String setFacilityUpdate(FacilityVO facilityVO)throws Exception{;
		 
		int result = facilityService.setFacilityUpdate(facilityVO);
		return "redirect:./getFacilitylist";
	}
	
	@PostMapping("delete")
	public String setFacilityDelete(FacilityVO facilityVO) throws Exception{
		int result = facilityService.setFacilityDelete(facilityVO);
		return "redirect:./getFacilitylist";
	}
	

}

