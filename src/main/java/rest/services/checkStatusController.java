package rest.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * method: 配置使用什么的方法
 * headers: 配置可以调用handler method的header
 * produces and consumes 中可以定义所调用的内容类型，如json或者xml 
 * @param : null
 */

@Controller
@RequestMapping("/CrudDemo")
public class checkStatusController {
	private static final String template = "%s is %s";

	@RequestMapping(value = "/create")
	@ResponseBody
	public Operation create(@RequestParam(value="name", defaultValue="xiaoMing") String name) {
		return new Operation(name,String.format(template, "he","creating message"));
	}
	
	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	@ResponseBody
	public Operation getMesg(@RequestParam(value="name", defaultValue="xiaoMing") String name) {
		return new Operation(name,String.format(template, "he","getting message"));
	}
	
	@RequestMapping(
			value = "/post", 
			method = { RequestMethod.POST, RequestMethod.PUT }, 
			headers = { "name=enluanJia","context-text=application/json" }, 
			produces = { "application/json", "application/xml" })
	@ResponseBody
	public String postMesg() {
		return "post/put message";
	}

}