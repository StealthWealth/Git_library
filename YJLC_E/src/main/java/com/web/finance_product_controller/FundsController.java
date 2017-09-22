package com.web.finance_product_controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.finance_product_bean.Finance_product_funds;
import com.web.finance_product_bean.Finance_product_subscribe;
import com.web.finance_product_service.FundsService;
import com.web.vip_auditing_Bean.Member;

@Controller(value="funds")
@RequestMapping("/funds")
public class FundsController {

	@Autowired
	private FundsService fundsService;
	
	@RequestMapping("/listfunds")
	public String listfunds(Model model,String qname,String wname,String ename){  //查询私募/股权类信息
		Map map = new HashMap<>();
		map.put("qname", qname);
		map.put("wname", wname);
		map.put("ename", ename);
		List<Finance_product_funds> listfunds = this.fundsService.listfunds(map);
		model.addAttribute("listfunds", listfunds);
		model.addAttribute("qname", qname);
		model.addAttribute("wname", wname);
		model.addAttribute("ename", ename);
		
		return "finance_funds";
	}
	
	@RequestMapping("/listsubscribe/{id}")
	public String listsubscribe(@PathVariable("id")int id,Model model){   //查询签署状态
		List<Finance_product_subscribe> listsubscribe = this.fundsService.listsubscribe(id);
		model.addAttribute("listsubscribe", listsubscribe);
		return "finance_subscribe";
	}
	

	@RequestMapping("/fundsadd")
	public String fundsadd(){  //跳转到添加 JSP 
		return "finance_funds_add";
	}
	
	@RequestMapping("/savefunds")
	public String savefunds(Finance_product_funds funds){  //保存 私募/股权类信息
		funds.setProduct_manager_pic("upload/"+funds.getProduct_manager_pic());
		this.fundsService.fundssave(funds);
		return "redirect:/funds/listfunds";
	}
	
	@RequestMapping("/editfunds/{id}")
	public String editfunds(@PathVariable("id")int id,Model model){  //  私募 /  股权类  根据ID查询信息进行编辑
		Finance_product_funds funds = this.fundsService.getfundsid(id);
		model.addAttribute("funds", funds);
		return "finance_funds_edit";
	}
	
	@RequestMapping("/updatefunds")
	public String updatefunds(Finance_product_funds finance_product_funds){   //修改私募信息
		this.fundsService.updatefunds(finance_product_funds);
		return "redirect:/funds/listfunds";
	}
	
	@RequestMapping("/updatesubscribe/{id}/{product_id}")
	public String updatesubscribe(@PathVariable("id")int did,@PathVariable("product_id")int pid){   // 签署失败
		this.fundsService.updatesubscribe(did);
		return "redirect:/funds/listsubscribe/{product_id}";
	}
	
	
	//查询签署
	@RequestMapping("subscribeadd/{id}/{period}")
	public String subscribeadd(@PathVariable("id")int id,Model model,@PathVariable("period")int period){
		System.err.println("---------"+period);
		Finance_product_subscribe subscribe = this.fundsService.getsubscribeid(id);
		model.addAttribute("subscribe", subscribe);
		Date date = new Date();
		date.setDate(date.getDate()+period);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("str", sim.format(new Date()));
		model.addAttribute("endtime", sim.format(date));
		return "finance_subscribe_add";
	}
	
	
	//签署合同
	@RequestMapping("/update")
	public String savesubscribe(Finance_product_subscribe subscribe,int did,int member_id,@RequestParam("file")MultipartFile[] files,HttpServletRequest request)throws Exception{
		for (int i = 0; i < files.length; i++) {
			String filename = files[i].getOriginalFilename();
			
			System.out.println(filename+"///000000000");
			String path = request.getRealPath("/upload/");
			File newFiles = new File(path, filename);
			if (!newFiles.exists()) {
				newFiles.createNewFile();
			}
			files[i].transferTo(newFiles);
			System.out.println("--------------------"+newFiles.getName());
			subscribe.setComment("upload/"+files[0].getOriginalFilename());
			subscribe.setRisk_reveal("upload/"+files[1].getOriginalFilename());
			System.out.println("-----------------did:"+did);
			Finance_product_funds funds = this.fundsService.getfundsid(did);
			Member member = this.fundsService.getmemberid(member_id);
			subscribe.setFunds(funds);
			subscribe.setMember(member);
			this.fundsService.updatesubscribe(subscribe);
		}
		return "redirect:/funds/listsubscribe/"+did;
	}
	
	//图片相关
	@RequestMapping("/uploadFile")
	public String upload(@RequestParam("file")MultipartFile file,HttpServletRequest request,Finance_product_funds funds,Model model) throws IOException{
		//获取文件名
		String filename = file.getOriginalFilename();
		//获取上传的绝对路径  upload 手动创建
		String path = request.getRealPath("/upload/");
		//获取新的文件对象
		File newFile = new File(path, filename);
		if(!newFile.exists()){ //文件不存在
			//创建文件
			newFile.createNewFile();
		}
		//将文件内容放入新的文件
		file.transferTo(newFile);
		funds.setProduct_manager_pic(newFile.getName());
		model.addAttribute("photo", funds);
		return "finance_funds_add";
	}
}
