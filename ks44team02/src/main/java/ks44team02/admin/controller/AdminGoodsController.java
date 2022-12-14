package ks44team02.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ks44team02.dto.Goods;
import ks44team02.dto.GoodsApply;
import ks44team02.dto.GoodsCategory;
import ks44team02.dto.GoodsDiscount;
import ks44team02.dto.Ingredient;
import ks44team02.dto.MenuInformation;
import ks44team02.dto.MenuOrganize;
import ks44team02.service.CommonService;
import ks44team02.service.FileService;
import ks44team02.service.GoodsService;

@Controller
@RequestMapping(value = "/admin/goods")
public class AdminGoodsController {

	private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

	private final GoodsService goodsService;
	private final CommonService commonService;
	private final FileService fileService;

	public AdminGoodsController(GoodsService goodsService, CommonService commonService, FileService fileService) {
		this.goodsService = goodsService;
		this.commonService = commonService;
		this.fileService = fileService;
	}

	@PostConstruct
	public void adminGoodsControllerInit() {
		log.info("AdminGoodsController bean ??????");
	}

	// ?????? ?????? ?????? ?????????
	@GetMapping("/goodsRegApplyList")
	public String getGoodsRegApplyList(Model model) {

		List<GoodsApply> goodsRegApplyList = goodsService.getGoodsRegApplyList(null);
		
		model.addAttribute("title", "?????? ?????? ?????? ??????");
		model.addAttribute("goodsRegApplyList", goodsRegApplyList);
		return "admin/goods/goodsRegApplyList";
	}
	
	//?????? ?????? ?????? ????????? ??????
	@PostMapping("/goodsRegApplyList")
	public String getSearchGoodsRegApplyList(Model model
											,@RequestParam(value = "searchKey", defaultValue = "goodsName") String searchKey
										    ,@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue
										    ,@RequestParam(value = "minNum", required = false, defaultValue = "") String minNum
										    ,@RequestParam(value = "maxNum", required = false, defaultValue = "") String maxNum
										    ,@RequestParam(value = "minDate", required = false, defaultValue = "") String minDate
										    ,@RequestParam(value = "maxDate", required = false, defaultValue = "") String maxDate
										    ,HttpServletRequest request) {
		String serverName = request.getServerName(); 
		 log.info("{} <<<< serverName", serverName); 
		 log.info("{} <<<< user ????????????", System.getProperty("user.dir"));
		 int isLocalhost = 0;
		 
		 if ("localhost".equals(serverName)) {
			 isLocalhost = 1; 
		 }
											
		Map<String, Object> map = new HashMap<String, Object>();
		
		if("goodsName".equals(searchKey)) {
			searchKey = "ga_name";
		}else if("enterName".equals(searchKey)) {
			searchKey = "e.enter_name";
		}else if("goodsCategory".equals(searchKey)) {
			searchKey = "gc.cate_name";
		}else if("goodsProduce".equals(searchKey)) {
			searchKey = "ga_produce";
		}else if("goodsPrice".equals(searchKey)) {
			searchKey = "ga_price";
		}else if("goodsDiscountPrice".equals(searchKey)) {
			searchKey = "ga_discount";
		}else if("goodsStock".equals(searchKey)) {
			searchKey = "ga_stock";
		}else if("goodsDeliveryCharge".equals(searchKey)) {
			searchKey = "ga_delivery_charge";
		}else if("regDate".equals(searchKey)) {
			searchKey = "ga_reg_apply_datetime";
		}
		
		map.put("sk", searchKey);
		map.put("sv", searchValue);
		map.put("minNum", minNum);
		map.put("maxNum", maxNum);
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		map.put("isLocalhost", isLocalhost);
		
		log.info(">>>>>>>>>>>>>>>>>>>>{}", map);
		
		List<GoodsApply> goodsRegApplyList = goodsService.getGoodsRegApplyList(map);
		log.info(">>>>>>>>>>>{}", goodsRegApplyList);
		
		model.addAttribute("title", "?????? ?????? ?????? ??????");
		model.addAttribute("goodsRegApplyList", goodsRegApplyList);
		
		return "admin/goods/goodsRegApplyList";
	}
	
	//?????? ?????? ?????? ??????
	@PostMapping("/approveGoodsRegApply")
	@ResponseBody
	@Transactional
	public boolean approveGoodsRegApply(@RequestParam(value = "goodsApplyCode") String goodsApplyCode) {
		
		// ?????? ?????? ????????? ???????????? ???????????? ???
		//?????? ?????? ?????? ????????? ???????????? ?????? ???????????? INSERT
		String goodsCode = commonService.getNewCode("tb_goods");
		
		boolean approveGoodsRegApplyResult = goodsService.approveGoodsRegApply(goodsApplyCode, goodsCode);
		if(!approveGoodsRegApplyResult) return false;
		
		//????????? ?????? ????????? ???????????? ?????? ?????? ????????? ??????????????? INSERT
		String ingredientCode = commonService.getNewCode("tb_ingredient");
		
		Ingredient ingredient = new Ingredient();
		
		ingredient.setIngredientCode(ingredientCode);
		ingredient.setGoodsCode(goodsCode);
		
		boolean addIngredientResult = goodsService.addIngredient(ingredient, goodsApplyCode);
		if(!addIngredientResult) return false;
		
		return true;
	}
	
	//?????? ?????? ?????? ??????
	@PostMapping("/refuseGoodsRegApply")
	@ResponseBody
	public boolean refuseGoodsRegApply(@RequestParam(value = "refuseReason") String refuseReason
									  ,@RequestParam(value = "goodsApplyCode") String goodsApplyCode) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("refuseReason", refuseReason);
		map.put("goodsApplyCode", goodsApplyCode);
		
		boolean refuseGoodsRegApplyResult = goodsService.refuseGoodsRegApply(map);
		
		return refuseGoodsRegApplyResult;
	}
	
	// ?????? ?????? ?????? ?????? ??????
	@GetMapping("/goodsRegApplyDetail/{goodsApplyCode}")
	public String getGoodsRegApplyInfo(Model model
										,@PathVariable(value = "goodsApplyCode") String goodsApplyCode) {
		GoodsApply goodsRegApplyInfo = goodsService.getGoodsRegApplyInfo(goodsApplyCode);
		
		model.addAttribute("title", "?????? ?????? ?????? ?????? ??????");
		model.addAttribute("goodsRegApplyInfo", goodsRegApplyInfo);
		return "admin/goods/goodsRegApplyDetail";
	}

	// ?????? ???????????? ?????? ???
	@GetMapping("/category/regGoodsCate")
	public String addGoodsCategoryForm(Model model) {

		model.addAttribute("title", "?????? ???????????? ??????");
		return "admin/goods/category/regGoodsCate";
	}

	// ?????? ???????????? ?????? ??????
	@PostMapping("/category/regGoodsCate")
	public String addGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {
		String goodsCateCode = commonService.getNewCode("tb_goods_cate");
		goodsCategory.setGoodsCategoryCode(goodsCateCode);
		boolean result = goodsService.addGoodsCategory(goodsCategory);
		String msg = "";
		if (result) {
			msg = "?????? ??????";
		} else {
			msg = "?????? ??????";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:/admin/goods/category/goodsCateList";
	}

	// ?????? ???????????? ?????????
	@GetMapping("/category/goodsCateList")
	public String getGoodsCategoryList(Model model, @RequestParam(value = "msg", required = false) String msg) {
		
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		
		model.addAttribute("title", "?????? ???????????? ??????");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		if (msg != null) model.addAttribute("msg", msg);

		return "admin/goods/category/goodsCateList";
	}

	// ?????? ???????????? ?????? ???
	@GetMapping("/category/updateGoodsCate/{goodsCategoryCode}")
	public String modifyGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);

		model.addAttribute("title", "?????? ???????????? ??????");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);
		
		return "admin/goods/category/updateGoodsCate";
	}

	// ?????? ???????????? ?????? ??????
	@PostMapping("/category/updateGoodsCate")
	public String modifyGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {

		boolean result = goodsService.modifyGoodsCategory(goodsCategory);

		if (result) {
			reAttr.addAttribute("msg", "?????? ??????");
		} else {
			reAttr.addAttribute("msg", "?????? ??????");
		}

		return "redirect:/admin/goods/category/goodsCateList";
	}

	// ?????? ???????????? ?????? ???
	@GetMapping("/category/removeGoodsCate/{goodsCategoryCode}")
	public String removeGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);
		System.out.println(goodsCategoryInfo.toString());
		
		model.addAttribute("title", "?????? ???????????? ??????");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);

		return "admin/goods/category/removeGoodsCate";
	}

	// ?????? ???????????? ?????? ??????
	@PostMapping("/category/removeGoodsCate")
	public String removeGoodsCategory(@RequestParam(value = "goodsCategoryCode") String goodsCategoryCode,
			@RequestParam(value = "memberPw") String memberPw, HttpSession session, RedirectAttributes reAttr) {
		// session ???????????? ????????? ???????????? ??? ?????? session ????????? ???????????? ??????
		// String memberId = session.getAttribute("SID");
		// null??? ?????? ??????(??????????????? ??????)
		// ?????? ???????????? ????????? ??? ??????
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		if (idCheckResult) {
			// ????????? ?????? ??????
			goodsService.removeGoodsCategory(goodsCategoryCode);
			reAttr.addAttribute("msg", "????????? ??????????????? ?????????????????????.");
		} else {
			// ????????? ?????? ?????????
			reAttr.addAttribute("msg", "?????? ??????: ??????????????? ???????????? ????????????.");
		}
		return "redirect:/admin/goods/category/goodsCateList";
	}

	// ?????? ?????????
	@GetMapping("/goodsList")
	public String getGoodsList(Model model
							  ,HttpServletRequest request) {
		String serverName = request.getServerName(); 
		int isLocalhost = 0;
		 
		if ("localhost".equals(serverName)) { 
			isLocalhost = 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("isLocalhost", isLocalhost);
		
		List<Goods> goodsList = goodsService.getGoodsList(map);
		System.out.println(goodsList.toString());
		
		model.addAttribute("title", "?????? ?????? ??????");
		model.addAttribute("goodsList", goodsList);
		
		return "admin/goods/goodsList";
	}
	
	// ?????? ????????? ??????
	@PostMapping("/goodsList")
	public String getSearchGoodsList(Model model
										 ,@RequestParam(value = "msg", required = false) String msg
										 ,@RequestParam(value = "searchKey", defaultValue = "goodsName") String searchKey
										 ,@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue
										 ,@RequestParam(value = "minNum", required = false, defaultValue = "") String minNum
										 ,@RequestParam(value = "maxNum", required = false, defaultValue = "") String maxNum
									     ,@RequestParam(value = "minDate", required = false, defaultValue = "") String minDate
									     ,@RequestParam(value = "maxDate", required = false, defaultValue = "") String maxDate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if("goodsName".equals(searchKey)) {
			searchKey = "g_name";
		}else if("enterName".equals(searchKey)) {
			searchKey = "e.enter_name";
		}else if("goodsCategory".equals(searchKey)) {
			searchKey = "cate_name";
		}else if("goodsProduce".equals(searchKey)) {
			searchKey = "g_produce";
		}else if("goodsPrice".equals(searchKey)) {
			searchKey = "g_price";
		}else if("goodsDiscountPrice".equals(searchKey)) {
			searchKey = "g_discount";
		}else if("goodsStock".equals(searchKey)) {
			searchKey = "g_stock";
		}else if("goodsDeliveryCharge".equals(searchKey)) {
			searchKey = "g_delivery_charge";
		}else if("regDate".equals(searchKey)) {
			searchKey = "g_reg_datetime";
		}	
		map.put("sk", searchKey);
		map.put("sv", searchValue);
		map.put("minNum", minNum);
		map.put("maxNum", maxNum);
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		
		log.info(">>>>>>>>>{}", map);
		
		List<Goods> goodsList = goodsService.getGoodsList(map);
		System.out.println(goodsList.toString());
		model.addAttribute("title", "?????? ?????? ??????");
		model.addAttribute("goodsList", goodsList);
		return "admin/goods/goodsList";
	}
	
	// ?????? ?????? ??????
	@GetMapping("/goodsDetail/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String goodsCode, Model model) {

		// ?????? g_code??? ?????? ?????? select ??? ????????? ?????? ?????? ??????
		// g_code null? ?????? ???????????? ?????????????

		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		
		model.addAttribute("title", "?????? ?????? ??????");
		model.addAttribute("goodsInfo", goodsInfo);
		return "admin/goods/goodsDetail";
	}

	// ?????? ?????? ???
	@GetMapping("/menu/regMenu")
	public String addAdminMenuForm(Model model) {
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListForReg();
		List<Map<String, Object>> goodsList = goodsService.getGoodsListForMenu();
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryListUser();
		
		model.addAttribute("title", "?????? ??????");
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		return "admin/goods/menu/regMenu";
	}

	// ?????? ?????? ??????
	@PostMapping("/menu/regMenu")
	@ResponseBody
	@Transactional
	public boolean addAdminMenu(HttpServletRequest request
							  ,Goods goods
							  ,@RequestParam(value = "goodsItems") String goodsItems
							  ,@RequestParam(value = "goodsMainImage") MultipartFile goodsMainImage
							  ,@RequestParam(value = "goodsInfoImage") MultipartFile goodsInfoImage) throws ParseException {
		
		
		boolean addAdminMenuResult = true;
		
		String menuOfGoods = "{ \"goodsItems\" : " + goodsItems + "}";
		
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParse.parse(menuOfGoods);
		System.out.println(jsonObj);
		JSONArray goodsItemArray = (JSONArray) jsonObj.get("goodsItems");
		
		 String serverName = request.getServerName(); 
		 log.info("{} <<<< serverName", serverName); 
		 log.info("{} <<<< user ????????????", System.getProperty("user.dir"));
		 String fileRealPath = ""; 
		 int isLocalhost = 1;
		 
		 if ("localhost".equals(serverName)) { 
			 fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/"; 
			 //fileRealPath = 
			 // request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/"); 
		 } else { 
			 // fileRealPath = 
			 // request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/"); 
			 isLocalhost = 0; 
			 fileRealPath = System.getProperty("user.dir") + "/resources/"; 
		 }
		 
		 String goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
		 String goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
		 
		 goods.setGoodsMainImageCode(goodsMainImageIdx);
		 goods.setGoodsInfoImageCode(goodsInfoImageIdx);
		
		// tb_goods INSERT ??????
		String goodsCode = commonService.getNewCode("tb_goods");
		goods.setGoodsCode(goodsCode);
		
		// ????????? ???????????? ?????? ??? ????????? ?????? ???????????? ?????? ?????? ??????
		String goodsDiscountCode = goods.getGoodsDiscountCode();
		int goodsPrice = goods.getGoodsPrice();
		int goodsDiscountedPrice = 0;
		
		if("noDiscount".equals(goodsDiscountCode)) {
			goodsDiscountedPrice = goodsPrice;
		}else {
			GoodsDiscount goodsDiscount = goodsService.getGoodsDiscount(goodsDiscountCode);
			int goodsDiscountPrice = goodsDiscount.getGoodsDiscountPrice();
			int goodsDiscountRate = goodsDiscount.getGoodsDiscountRate();
			
			if(goodsDiscountPrice == 0 && goodsDiscountRate == 0) {
				goodsDiscountedPrice = goodsPrice;
			}else if(goodsDiscountPrice != 0 && goodsDiscountRate == 0) {
				goodsDiscountedPrice = (goodsPrice - goodsDiscountPrice);
			}else {
				double percent = goodsDiscountRate * 0.01;
				double discount = goodsPrice * percent;
				goodsDiscountedPrice = (int) (goodsPrice - discount);
			}
		}
		goods.setGoodsDiscountedPrice(goodsDiscountedPrice);
		
		//????????? ???????????? ???????????? ?????? ????????? ????????? ??????
		String contentsRef = "????????? ??????";
		goods.setGoodsNetWeight(0);
		goods.setGoodsNetWeightUnit(contentsRef);
		goods.setGoodsProduce(contentsRef);
		goods.setGoodsProductionExpirationInfo(contentsRef);
		
		//tb_goods ??? INSERT
		boolean addGoodsResult = goodsService.addGoods(goods);
		String menuCode = commonService.getNewCode("tb_menu_information");
		
		//INSERT ????????? ??????
		if(addGoodsResult) {
			MenuInformation menuInformation = new MenuInformation();
			
			menuInformation.setMenuCode(menuCode);
			menuInformation.setGoodsCode(goodsCode);
			menuInformation.setMenuName(goods.getGoodsName());
			
			//?????? ????????? ?????? ???????????? ?????? 
			//String memberId = (String) session.getAttribute("SID");
			//????????? ????????? ??? ??????
			String memberId = "id001";
			menuInformation.setMenuRegId(memberId);
			
			boolean addMenuInformationResult = goodsService.addMenuInformation(menuInformation);
			
			//INSERT ????????? ??????
			if(addMenuInformationResult) {
				// ????????? ?????? ?????? ?????? INSERT
				int arraySize = goodsItemArray.size();
				 for(int i=0; i < arraySize ; i++) {
		             MenuOrganize menuOrganize = new MenuOrganize();
		             
		             JSONObject goodsItemObject = (JSONObject) goodsItemArray.get(i);
		             menuOrganize.setMenuGoodsCode(commonService.getNewCode("tb_menu_organize"));
		             menuOrganize.setMenuCode(menuCode);
		             menuOrganize.setGoodsOfMenuCode((String) goodsItemObject.get("goodsOfMenuCode"));
		             menuOrganize.setMenuGoodsAmount(Integer.parseInt((String) goodsItemObject.get("menuGoodsAmount")));
		             log.info(menuOrganize.toString());
		             goodsService.addMenuOrganize(menuOrganize);
		         }
			}else {
				addAdminMenuResult = false;
			}
		
		//INSERT ????????? ??????
		}else {
			addAdminMenuResult = false;
		}
		return addAdminMenuResult;
	}
	

	// ?????? ?????????
	@GetMapping("/menu/menuList")
	public String getAdminMenuList(Model model
								  ,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//image??? ????????? ????????? ?????? isLocal test ??????
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user ????????????", System.getProperty("user.dir"));
		int isLocalhost = 1;
		
		if (!"localhost".equals(serverName)) { 
			isLocalhost = 0;
		}
		map.put("isLocalhost", isLocalhost);
		
		List<Goods> adminMenuList = goodsService.getAdminMenuList(map);
		
		model.addAttribute("title", "?????? ?????? ??????");
		model.addAttribute("adminMenuList", adminMenuList);
		return "admin/goods/menu/menuList";
	}
	
	//?????? ????????? ??????
	@PostMapping("/menu/menuList")
	public String getSearchMenuList(Model model
								   ,HttpServletRequest request
								   ,@RequestParam(value = "msg", required = false) String msg
								   ,@RequestParam(value = "searchKey", defaultValue = "goodsName") String searchKey
								   ,@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue
								   ,@RequestParam(value = "minNum", required = false, defaultValue = "") String minNum
								   ,@RequestParam(value = "maxNum", required = false, defaultValue = "") String maxNum
							       ,@RequestParam(value = "minDate", required = false, defaultValue = "") String minDate
							       ,@RequestParam(value = "maxDate", required = false, defaultValue = "") String maxDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user ????????????", System.getProperty("user.dir"));
		int isLocalhost = 1;
		
		if (!"localhost".equals(serverName)) { 
			isLocalhost = 0;
		}
		map.put("isLocalhost", isLocalhost);
		
		if("goodsName".equals(searchKey)) {
			searchKey = "g_name";
		}else if("goodsCategory".equals(searchKey)) {
			searchKey = "gc.cate_name";
		}else if("goodsPrice".equals(searchKey)) {
			searchKey = "g_price";
		}else if("goodsDiscountPrice".equals(searchKey)) {
			searchKey = "g_discount";
		}else if("goodsStock".equals(searchKey)) {
			searchKey = "g_stock";
		}else if("goodsDeliveryCharge".equals(searchKey)) {
			searchKey = "g_delivery_charge";
		}else if("regDate".equals(searchKey)) {
			searchKey = "g_reg_datetime";
		}	
		map.put("sk", searchKey);
		map.put("sv", searchValue);
		map.put("minNum", minNum);
		map.put("maxNum", maxNum);
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		
		log.info(">>>>>>>>>{}", map);
		
		List<Goods> adminMenuList = goodsService.getAdminMenuList(map);
		model.addAttribute("adminMenuList", adminMenuList);
		
		return "admin/goods/menu/menuList";
	}

	// ?????? ?????? ???
	@GetMapping("/menu/updateMenu/{menuCode}")
	public String modifyAdminMenuForm(@PathVariable(value = "menuCode") String menuCode
									 ,Model model) {
		Goods menuInfo = goodsService.getMenuInfo(menuCode);
		List<MenuOrganize> menuOrganizeList = goodsService.getMenuOrganizeList(menuCode);
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListForReg();
		List<Map<String, Object>> goodsList = goodsService.getGoodsListForMenu();
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrganizeList", menuOrganizeList);
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		return "admin/goods/menu/updateMenu";
	}

	// ?????? ?????? ??????
	@PostMapping("/menu/updateMenu/{menuCode}")
	@ResponseBody
	@Transactional
	public boolean modifyAdminMenu(@PathVariable(value = "menuCode") String menuCode
								 ,HttpServletRequest request
							     ,Goods goods
							     ,@RequestParam(value = "goodsItems") String goodsItems
							     ,@RequestParam(value = "goodsMainImage", required = false) MultipartFile goodsMainImage
							     ,@RequestParam(value = "goodsInfoImage", required = false) MultipartFile goodsInfoImage
							     ,HttpSession session) throws ParseException {
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user ????????????", System.getProperty("user.dir"));
		String fileRealPath = ""; 
		int isLocalhost = 1;
		 
		if ("localhost".equals(serverName)) { 
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/"; 
			//fileRealPath = 
			// request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/"); 
			} else { 
			// fileRealPath = 
			// request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/"); 
			isLocalhost = 0; 
			fileRealPath = System.getProperty("user.dir") + "/resources/"; 
		}
		
		String goodsMainImageIdx = "";
		String goodsInfoImageIdx = "";
		log.info(">>>>>>{}",goodsMainImage);
		if(!goodsMainImage.isEmpty()) {
			if(!goodsInfoImage.isEmpty()) {
				//goodsMainImage??? goodsInfoImage ?????? ??????
				goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
				goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
				goods.setGoodsMainImageCode(goodsMainImageIdx);
				goods.setGoodsInfoImageCode(goodsInfoImageIdx);
			}else {
				//goodsMainImage??? ??????
				goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
				goods.setGoodsMainImageCode(goodsMainImageIdx);
			}
		}else{
			if(!goodsInfoImage.isEmpty()) {
				//goodsInfoImage??? ??????
				goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
				goods.setGoodsInfoImageCode(goodsInfoImageIdx);
			}
		}
		
		String menuOfGoods = "{ \"goodsItems\" : " + goodsItems + "}";
		
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParse.parse(menuOfGoods);
		System.out.println(jsonObj);
		JSONArray goodsItemArray = (JSONArray) jsonObj.get("goodsItems");
		
		//tb_menu_oraganize ??? ?????? ????????? ??????
		boolean removeMenuOrganizeResult = goodsService.removeMenuOrganize(menuCode);
		
		if(!removeMenuOrganizeResult) return false;
		
		//tb_menu_organize ??? ?????????
		for(int i=0; i < goodsItemArray.size(); i++) {
            MenuOrganize menuOrganize = new MenuOrganize();
            
            JSONObject goodsItemObject = (JSONObject) goodsItemArray.get(i);
            menuOrganize.setMenuGoodsCode(commonService.getNewCode("tb_menu_organize"));
            menuOrganize.setMenuCode(menuCode);
            menuOrganize.setGoodsOfMenuCode((String) goodsItemObject.get("goodsOfMenuCode"));
            menuOrganize.setMenuGoodsAmount(Integer.parseInt((String) goodsItemObject.get("menuGoodsAmount")));
            boolean addMenuOrganizeResult = goodsService.addMenuOrganize(menuOrganize);
            if(!addMenuOrganizeResult) return false;
        }
		
		//MenuInformation ?????? ??????
		String goodsName = goods.getGoodsName();
		goodsService.modifyMenuInformation(menuCode, goodsName);
		
		// ????????? ???????????? ?????? ??? ????????? ?????? ???????????? ?????? ?????? ??????
		String goodsDiscountCode = goods.getGoodsDiscountCode();
		int goodsPrice = goods.getGoodsPrice();
		int goodsDiscountedPrice = 0;
		
		if("noDiscount".equals(goodsDiscountCode)) {
			goodsDiscountedPrice = goodsPrice;
		}else {
			GoodsDiscount goodsDiscount = goodsService.getGoodsDiscount(goodsDiscountCode);
			int goodsDiscountPrice = goodsDiscount.getGoodsDiscountPrice();
			int goodsDiscountRate = goodsDiscount.getGoodsDiscountRate();
			
			if(goodsDiscountPrice == 0 && goodsDiscountRate == 0) {
				goodsDiscountedPrice = goodsPrice;
			}else if(goodsDiscountPrice != 0 && goodsDiscountRate == 0) {
				goodsDiscountedPrice = (goodsPrice - goodsDiscountPrice);
			}else {
				double percent = goodsDiscountRate * 0.01;
				double discount = goodsPrice * percent;
				goodsDiscountedPrice = (int) (goodsPrice - discount);
			}
		}
		goods.setGoodsDiscountedPrice(goodsDiscountedPrice);
		log.info(">>>>>>>> {}", goods);
		
		//Goods ?????? ??????
		boolean modifyGoodsResult = goodsService.modifyGoods(goods);
		
		if(!modifyGoodsResult) return false;
		
		return true;
	}

	// ?????? ?????? ??????
	@PostMapping("menu/removeMenu/{menuCode}")
	@ResponseBody
	@Transactional
	public boolean removeAdminMenu(@PathVariable(value = "menuCode") String menuCode
								 ,@RequestParam(value = "memberPw") String memberPw
								 ,HttpSession session
								 ,HttpServletRequest request) {
		
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id001";
		boolean checkResult = commonService.sessionIdPwCheck(memberId, memberPw);
		log.info(">>>>>>>>>>>>>>>>>{}",checkResult);
		if(!checkResult) {
			return false;
		}
		
		boolean removeGoodsResult = goodsService.removeMenu(menuCode);
		if(!removeGoodsResult) {
			return false;
		}
		
		return true;
	}

	// ?????? ?????? ??????
	@GetMapping("/menu/menuDetail/{menuCode}")
	public String getMenuInfo(@PathVariable(value = "menuCode") String menuCode
							 ,Model model
							 ,HttpServletRequest request) {
		//String serverName = request.getServerName();
		List<Goods> menuOrgarnizeGoodsInfoList = goodsService.getMenuOrganizeGoodsInfo(menuCode);
		Goods menuInfo = goodsService.getMenuInfo(menuCode);
		List<MenuOrganize> menuOrganizeList = goodsService.getMenuOrganizeList(menuCode);
		
		model.addAttribute("title", "?????? ?????? ??????");
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrgarnizeGoodsInfoList", menuOrgarnizeGoodsInfoList);
		model.addAttribute("menuOrganizeList", menuOrganizeList);
		return "admin/goods/menu/menuDetail";
	}

	// ????????? ?????? ?????? ?????? ???
	@GetMapping("/discount/regGoodsDiscount")
	public String addGoodsDiscountForm(Model model) {
		
		model.addAttribute("title", "????????? ?????? ?????? ??????");
		
		return "admin/goods/discount/regGoodsDiscount";
	}

	// ????????? ?????? ?????? ?????? ??????
	@PostMapping("/discount/regGoodsDiscount")
	public String addGoodsDiscount(GoodsDiscount goodsDiscount
								  ,@RequestParam(value = "selectRatePrice") String selectRatePrice
								  ,@RequestParam(value = "discountNumber") int discountNumber
								  ,HttpSession session) {
		if("rate".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(discountNumber);
			goodsDiscount.setGoodsDiscountPrice(0);
		}else if("price".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(0);
			goodsDiscount.setGoodsDiscountPrice(discountNumber);
		}
		
		String newCode = commonService.getNewCode("tb_goods_discount_management");
		goodsDiscount.setGoodsDiscountCode(newCode);
		
		//?????? ?????? ??? ?????? 
		//String memberId = session.getAttribute("SID");
		//?????? ????????? ????????? enterprise ????????? entercode ?????? ??????????????????
		//????????? ????????? ??????
		String memberId = "id001";
		goodsDiscount.setGoodsDiscountRegistrant(memberId);
		
		log.info(goodsDiscount.toString());
		goodsService.addGoodsDiscount(goodsDiscount);
		
		return "redirect:/admin/goods/discount/goodsDiscountList";
	}

	// ????????? ?????? ?????? ?????????
	@GetMapping("/discount/goodsDiscountList")
	public String getGoodsDiscountList(Model model
									  ,@RequestParam(value = "msg", required = false) String msg
									  ,@RequestParam(value = "searchKey", defaultValue = "discountName") String searchKey
									  ,@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue
									  ,@RequestParam(value = "minNum", required = false, defaultValue = "") String minNum
									  ,@RequestParam(value = "maxNum", required = false, defaultValue = "") String maxNum
									  ,@RequestParam(value = "minDate", required = false, defaultValue = "") String minDate
									  ,@RequestParam(value = "maxDate", required = false, defaultValue = "") String maxDate
									  ) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if("discountName".equals(searchKey)) {
			searchKey = "discount_name";
		}else if("discountRate".equals(searchKey)) {
			searchKey = "discount_rate";
		}else if("discountPrice".equals(searchKey)) {
			searchKey = "discount_price";
		}else if("expirationDate".equals(searchKey)) {
			searchKey = "discount_expiration_date";
		}else if("memberId".equals(searchKey)) {
			searchKey = "gdm.member_id";
		}else if("regDate".equals(searchKey)) {
			searchKey = "g_pro_reg_datetime";
		}	
		map.put("sk", searchKey);
		map.put("sv", searchValue);
		map.put("minNum", minNum);
		map.put("maxNum", maxNum);
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		
		log.info(">>>>>>>>>{}", map);
		
		List<GoodsDiscount> goodsDiscountList = goodsService.getGoodsDiscountList(map);
		
		model.addAttribute("title", "????????? ?????? ?????? ??????");
		model.addAttribute("goodsDiscountList", goodsDiscountList);
		if(msg!=null) model.addAttribute("msg", msg);
		return "admin/goods/discount/goodsDiscountList";
	}

	// ????????? ?????? ?????? ?????? ???
	@GetMapping("/discount/updateGoodsDiscount/{goodsDiscountCode}")
	public String modifyGoodsDiscountForm(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
										 ,Model model) {
		GoodsDiscount goodsDiscountInfo = goodsService.modifyGoodsDiscountForm(goodsDiscountCode);
		
		model.addAttribute("title", "????????? ?????? ?????? ??????");
		model.addAttribute("goodsDiscountInfo", goodsDiscountInfo);
		return "admin/goods/discount/updateGoodsDiscount";
	}

	// ????????? ?????? ?????? ?????? ??????
	@PostMapping("/discount/updateGoodsDiscount/{goodsDiscountCode}")
	public String modifyGoodsDiscount(GoodsDiscount goodsDiscount
									 ,@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
									 ,@RequestParam(value = "memberPw") String memberPw
									 ,@RequestParam(value = "selectRatePrice") String selectRatePrice
									 ,@RequestParam(value = "discountNumber") int discountNumber
									 ,HttpSession session
									 ,RedirectAttributes reAttr) {
		
		if("rate".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(discountNumber);
			goodsDiscount.setGoodsDiscountPrice(0);
		}else if("price".equals(selectRatePrice)) {
			goodsDiscount.setGoodsDiscountRate(0);
			goodsDiscount.setGoodsDiscountPrice(discountNumber);
		}
		
		//?????? ?????? ??? ?????? ???????????? ??????
		//String memberId = session.getAttribute("SID");
		//????????? ????????? ??? ??????
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		System.out.println(goodsDiscount.toString());
		if(idCheckResult) {
			boolean result = goodsService.modifyGoodsDiscount(goodsDiscount);
			if(result) {
				reAttr.addAttribute("msg", "????????? ??????????????? ?????????????????????.");
			}else {
				reAttr.addAttribute("msg", "?????? ??????: GoodsMapper ??????");
			}
		}else {
			reAttr.addAttribute("msg", "?????? ??????: ??????????????? ??????????????????.");
		}

		return "redirect:/admin/goods/discount/goodsDiscountList";
	}
	
	//????????? ?????? ?????? ?????? ???
	@GetMapping("/discount/removeGoodsDiscount/{goodsDiscountCode}")
	public String removeGoodsDiscountForm(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
										 ,Model model) {
		GoodsDiscount goodsDiscountInfo = goodsService.removeGoodsDiscountForm(goodsDiscountCode);
		
		model.addAttribute("title", "????????? ?????? ?????? ??????");
		model.addAttribute("goodsDiscountInfo", goodsDiscountInfo);
		return "admin/goods/discount/removeGoodsDiscount";
	}

	// ????????? ?????? ?????? ?????? ??????
	@PostMapping("/discount/removeGoodsDiscount/{goodsDiscountCode}")
	public String removeGoodsDiscount(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
									 ,@RequestParam(value = "memberPw") String memberPw
									 ,HttpSession session
									 ,RedirectAttributes reAttr) {
		//?????? ?????? ??? ?????? ???????????? ??????
		//String memberId = session.getAttribute("SID");
		//????????? ????????? ??? ??????
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		
		if(idCheckResult) {
			boolean result2 = goodsService.removeGoodsDiscount(goodsDiscountCode);
			if(result2) {
				reAttr.addAttribute("msg", "????????? ??????????????? ?????????????????????");
			}else {
				reAttr.addAttribute("msg", "?????? ??????: GoodsMapper ??????");
			}
		}else {
			reAttr.addAttribute("msg", "?????? ??????: ??????????????? ??????????????????.");
		}
		
		return "redirect:/admin/goods/discount/goodsDiscountList";
	}
}
