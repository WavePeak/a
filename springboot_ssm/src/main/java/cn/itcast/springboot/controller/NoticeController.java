package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.pojo.Notice;
import cn.itcast.springboot.service.NoticeService;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	/** 查询所有的公告 */
	@GetMapping("/findAll")
	public List<Notice> finAll(){
		return noticeService.findAll();
	}
	
	/** 分页查询公告 */
	@PostMapping("/findByPage")
	public Map<String, Object> findByPage(@RequestParam("page")Integer page,
				@RequestParam("rows")Integer rows){
		// {"total" : 100, "rows" : [{},{}]}
		return noticeService.findByPage(page ,rows);
	}
	
}
