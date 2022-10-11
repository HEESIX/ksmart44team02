package ks44team02.admin.controller;

import java.io.File;
import java.nio.file.Paths;
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
import ks44team02.dto.GoodsInfoImage;
import ks44team02.dto.GoodsMainImage;
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
		log.info("AdminGoodsController bean 생성");
	}

	// 상품 등록 신청 리스트
	@GetMapping("/goodsRegApplyList")
	public String getGoodsRegApplyList(Model model) {

		List<GoodsApply> goodsRegApplyList = goodsService.getGoodsRegApplyList(null);
		model.addAttribute("title", "상품 등록 신청 목록");
		model.addAttribute("goodsRegApplyList", goodsRegApplyList);
		return "admin/goods/goodsRegApplyList";
	}
	
	//상품 등록 신청 리스트 검색
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
		 log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
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
		model.addAttribute("goodsRegApplyList", goodsRegApplyList);
		
		return "admin/goods/goodsRegApplyList";
	}
	
	//상품 등록 신청 승인
	@PostMapping("/approveGoodsRegApply")
	@ResponseBody
	@Transactional
	public boolean approveGoodsRegApply(@RequestParam(value = "goodsApplyCode") String goodsApplyCode) {
		
		// 상품 신청 정보를 승인으로 업데이트 후
		//상품 등록 신청 정보를 바탕으로 상품 테이블에 INSERT
		String goodsCode = commonService.getNewCode("tb_goods");
		
		boolean approveGoodsRegApplyResult = goodsService.approveGoodsRegApply(goodsApplyCode, goodsCode);
		if(!approveGoodsRegApplyResult) return false;
		
		//발행된 상품 코드를 바탕으로 상품 등록 신청한 영양정보를 INSERT
		String ingredientCode = commonService.getNewCode("tb_ingredient");
		
		Ingredient ingredient = new Ingredient();
		
		ingredient.setIngredientCode(ingredientCode);
		ingredient.setGoodsCode(goodsCode);
		
		boolean addIngredientResult = goodsService.addIngredient(ingredient, goodsApplyCode);
		if(!addIngredientResult) return false;
		
		return true;
	}
	
	//상품 등록 신청 거절
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
	
	// 상품 등록 신청 상세 정보
	@GetMapping("/goodsRegApplyDetail/{goodsApplyCode}")
	public String getGoodsRegApplyInfo(Model model
										,@PathVariable(value = "goodsApplyCode") String goodsApplyCode) {
		GoodsApply goodsRegApplyInfo = goodsService.getGoodsRegApplyInfo(goodsApplyCode);
		model.addAttribute("goodsRegApplyInfo", goodsRegApplyInfo);
		return "admin/goods/goodsRegApplyDetail";
	}

	// 상품 카테고리 등록 폼
	@GetMapping("/category/regGoodsCate")
	public String addGoodsCategoryForm(Model model) {

		model.addAttribute("title", "상품 카테고리 등록");
		return "admin/goods/category/regGoodsCate";
	}

	// 상품 카테고리 등록 처리
	@PostMapping("/category/regGoodsCate")
	public String addGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {
		String goodsCateCode = commonService.getNewCode("tb_goods_cate");
		goodsCategory.setGoodsCategoryCode(goodsCateCode);
		boolean result = goodsService.addGoodsCategory(goodsCategory);
		String msg = "";
		if (result) {
			msg = "등록 성공";
		} else {
			msg = "등록 실패";
		}
		reAttr.addAttribute("msg", msg);
		return "redirect:/admin/goods/category/goodsCateList";
	}

	// 상품 카테고리 리스트
	@GetMapping("/category/goodsCateList")
	public String getGoodsCategoryList(Model model, @RequestParam(value = "msg", required = false) String msg) {
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		model.addAttribute("title", "상품 카테고리 목록");
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		if (msg != null)
			model.addAttribute("msg", msg);

		return "admin/goods/category/goodsCateList";
	}

	// 상품 카테고리 수정 폼
	@GetMapping("/category/updateGoodsCate/{goodsCategoryCode}")
	public String modifyGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);

		model.addAttribute("title", "상품 카테고리 수정");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);
		return "admin/goods/category/updateGoodsCate";
	}

	// 상품 카테고리 수정 처리
	@PostMapping("/category/updateGoodsCate")
	public String modifyGoodsCategory(GoodsCategory goodsCategory, RedirectAttributes reAttr) {

		boolean result = goodsService.modifyGoodsCategory(goodsCategory);

		if (result) {
			reAttr.addAttribute("msg", "수정 완료");
		} else {
			reAttr.addAttribute("msg", "수정 실패");
		}

		return "redirect:/admin/goods/category/goodsCateList";
	}

	// 상품 카테고리 삭제 폼
	@GetMapping("/category/removeGoodsCate/{goodsCategoryCode}")
	public String removeGoodsCategoryForm(@PathVariable(value = "goodsCategoryCode") String goodsCategoryCode,
			Model model) {
		GoodsCategory goodsCategoryInfo = goodsService.getGoodsCategoryInfo(goodsCategoryCode);
		System.out.println(goodsCategoryInfo.toString());
		model.addAttribute("title", "상품 카테고리 삭제");
		model.addAttribute("goodsCategoryInfo", goodsCategoryInfo);

		return "admin/goods/category/removeGoodsCate";
	}

	// 상품 카테고리 삭제 처리
	@PostMapping("/category/removeGoodsCate")
	public String removeGoodsCategory(@RequestParam(value = "goodsCategoryCode") String goodsCategoryCode,
			@RequestParam(value = "memberPw") String memberPw, HttpSession session, RedirectAttributes reAttr) {
		// session 저장하는 로그인 완성되면 이 부분 session 아이디 가져오게 교체
		// String memberId = session.getAttribute("SID");
		// null일 경우 체크(비정상적인 접근)
		// 현재 없으므로 픽스된 값 입력
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		if (idCheckResult) {
			// 아이디 비번 일치
			goodsService.removeGoodsCategory(goodsCategoryCode);
			reAttr.addAttribute("msg", "삭제가 정상적으로 완료되었습니다.");
		} else {
			// 아이디 비번 불일치
			reAttr.addAttribute("msg", "삭제 실패: 비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/admin/goods/category/goodsCateList";
	}

	// 상품 리스트
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		List<Goods> goodsList = goodsService.getAdminGoodsList(null);
		System.out.println(goodsList.toString());
		model.addAttribute("goodsList", goodsList);
		return "admin/goods/goodsList";
	}
	
	// 상품 리스트 검색
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
		
		List<Goods> goodsList = goodsService.getAdminGoodsList(map);
		System.out.println(goodsList.toString());
		model.addAttribute("goodsList", goodsList);
		return "admin/goods/goodsList";
	}
	
	// 개별 상품 정보
	@GetMapping("/goodsDetail/{g_code}")
	public String getGoodsInfo(@PathVariable(value = "g_code") String goodsCode, Model model) {

		// 받은 g_code로 상품 정보 select 후 모델에 담는 작업 필요
		// g_code null? 혹은 존재하지 않을경우?

		Goods goodsInfo = goodsService.getGoodsInfo(goodsCode);
		model.addAttribute("goodsInfo", goodsInfo);
		return "admin/goods/goodsDetail";
	}

	// 상품 수정 폼
	@GetMapping("/updateGoods/{g_code}")
	public String modifyGoodsForm(@PathVariable(value = "g_code") String g_code) {

		return "admin/goods/updateGoods";
	}

	// 상품 수정 처리
	@PostMapping("/updateGoods")
	public String modifyGoods() {

		// 수정 처리 후 돌아갈 화면 redirect
		return "redirect:/admin/goods/goodsList";
	}

	// 상품 삭제 처리
	@PostMapping("/removeGoods/{g_code}")
	public String removeAdminGoods(@PathVariable(value = "g_code") String g_code) {

		return "redirect:/admin/goods/goodsList";
	}

	// 식단 등록 폼
	@GetMapping("/menu/regMenu")
	public String addAdminMenuForm(Model model) {
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListForReg();
		List<Map<String, Object>> goodsList = goodsService.getGoodsList();
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		
		model.addAttribute("title", "식단 등록");
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		return "admin/goods/menu/regMenu";
	}

	// 식단 등록 처리
	@PostMapping("/menu/regMenu")
	@ResponseBody
	@Transactional
	public boolean addAdminMenu(HttpServletRequest request
							  ,Goods goods
							  ,@RequestParam(value = "goodsItems") String goodsItems
							  ,@RequestParam(value = "goodsMainImage") MultipartFile goodsMainImage
							  ,@RequestParam(value = "goodsInfoImage") MultipartFile goodsInfoImage
							  ,HttpSession session) throws ParseException {
		
		String menuOfGoods = "{ \"goodsItems\" : " + goodsItems + "}";
		boolean addAdminMenuResult = true;
		
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParse.parse(menuOfGoods);
		System.out.println(jsonObj);
		JSONArray goodsItemArray = (JSONArray) jsonObj.get("goodsItems");
		
		
		 String serverName = request.getServerName(); 
		 log.info("{} <<<< serverName", serverName); 
		 log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
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
		
		// tb_goods INSERT 준비
		String goodsCode = commonService.getNewCode("tb_goods");
		goods.setGoodsCode(goodsCode);
		
		// 상품별 할인혜택 조회 후 할인된 혹은 할인되지 않은 가격 세팅
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
		
		//상품의 원산지와 유통기한 정보 컨텐츠 참조로 세팅
		String contentsRef = "컨텐츠 참조";
		goods.setGoodsNetWeight(0);
		goods.setGoodsNetWeightUnit(contentsRef);
		goods.setGoodsProduce(contentsRef);
		goods.setGoodsProductionExpirationInfo(contentsRef);
		
		//tb_goods 에 INSERT
		boolean addGoodsResult = goodsService.addGoods(goods);
		String menuCode = commonService.getNewCode("tb_menu_information");
		
		//INSERT 성공일 경우
		if(addGoodsResult) {
			MenuInformation menuInformation = new MenuInformation();
			
			menuInformation.setMenuCode(menuCode);
			menuInformation.setGoodsCode(goodsCode);
			menuInformation.setMenuName(goods.getGoodsName());
			
			//세션 구현될 경우 세션으로 대체 
			//String memberId = (String) session.getAttribute("SID");
			//현재는 픽스된 값 사용
			String memberId = "id001";
			menuInformation.setMenuRegId(memberId);
			
			boolean addMenuInformationResult = goodsService.addMenuInformation(menuInformation);
			
			//INSERT 성공일 경우
			if(addMenuInformationResult) {
				// 식단의 상품 등록 구성 INSERT
				 for(int i=0; i < goodsItemArray.size(); i++) {
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
		
		//INSERT 실패일 경우
		}else {
			addAdminMenuResult = false;
		}

		return addAdminMenuResult;
	}
	

	// 식단 리스트
	@GetMapping("/menu/menuList")
	public String getAdminMenuList(Model model
								  ,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//image가 관련된 부분은 전부 isLocal test 필요
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
		int isLocalhost = 1;
		
		if (!"localhost".equals(serverName)) { 
			isLocalhost = 0;
		}
		map.put("isLocalhost", isLocalhost);
		
		List<Goods> adminMenuList = goodsService.getAdminMenuList(map);
		model.addAttribute("adminMenuList", adminMenuList);
		return "admin/goods/menu/menuList";
	}
	
	//식단 리스트 검색
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
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
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

	// 식단 수정 폼
	@GetMapping("/menu/updateMenu/{menuCode}")
	public String modifyAdminMenuForm(@PathVariable(value = "menuCode") String menuCode
									 ,Model model) {
		Goods menuInfo = goodsService.getMenuInfo(menuCode);
		List<MenuOrganize> menuOrganizeList = goodsService.getMenuOrganizeList(menuCode);
		List<GoodsDiscount> goodsDiscountListAdmin = goodsService.getGoodsDiscountListForReg();
		List<Map<String, Object>> goodsList = goodsService.getGoodsList();
		List<GoodsCategory> goodsCategoryList = goodsService.getGoodsCategoryList();
		
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrganizeList", menuOrganizeList);
		model.addAttribute("goodsDiscountListAdmin", goodsDiscountListAdmin);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		return "admin/goods/menu/updateMenu";
	}

	// 식단 수정 처리
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
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
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
				//goodsMainImage와 goodsInfoImage 모두 수정
				goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
				goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
				goods.setGoodsMainImageCode(goodsMainImageIdx);
				goods.setGoodsInfoImageCode(goodsInfoImageIdx);
			}else {
				//goodsMainImage만 수정
				goodsMainImageIdx = fileService.goodsMainImageUpload(goodsMainImage, fileRealPath, isLocalhost); 
				goods.setGoodsMainImageCode(goodsMainImageIdx);
			}
		}else{
			if(!goodsInfoImage.isEmpty()) {
				//goodsInfoImage만 수정
				goodsInfoImageIdx = fileService.goodsInfoImageUpload(goodsInfoImage, fileRealPath, isLocalhost);
				goods.setGoodsInfoImageCode(goodsInfoImageIdx);
			}
		}
		
		String menuOfGoods = "{ \"goodsItems\" : " + goodsItems + "}";
		
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParse.parse(menuOfGoods);
		System.out.println(jsonObj);
		JSONArray goodsItemArray = (JSONArray) jsonObj.get("goodsItems");
		
		//tb_menu_oraganize 의 정보 튜플들 삭제
		boolean removeMenuOrganizeResult = goodsService.removeMenuOrganize(menuCode);
		
		if(!removeMenuOrganizeResult) return false;
		
		//tb_menu_organize 에 재삽입
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
		
		//MenuInformation 정보 수정
		String goodsName = goods.getGoodsName();
		goodsService.modifyMenuInformation(menuCode, goodsName);
		
		// 상품별 할인혜택 조회 후 할인된 혹은 할인되지 않은 가격 세팅
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
		
		//Goods 정보 수정
		boolean modifyGoodsResult = goodsService.modifyGoods(goods);
		
		if(!modifyGoodsResult) return false;
		
		return true;
	}

	// 식단 삭제 처리
	@PostMapping("menu/removeMenu/{menuCode}")
	@ResponseBody
	@Transactional
	public String removeAdminMenu(@PathVariable(value = "menuCode") String menuCode
								 ,@RequestParam(value = "memberPw") String memberPw
								 ,HttpSession session
								 ,HttpServletRequest request) {
		String msg = "식단 삭제가 정상적으로 완료되었습니다.";
		Goods goods = goodsService.getMenuInfo(menuCode);
		
		//String memberId = (String) session.getAttribute("SID");
		String memberId = "id001";
		boolean checkResult = commonService.sessionIdPwCheck(memberId, memberPw);
		log.info(">>>>>>>>>>>>>>>>>{}",checkResult);
		if(!checkResult) {
			msg = "삭제 실패: 비밀번호를 확인해주세요.";
			return msg;
		}
		
		boolean removeMenuOranizeResult =  goodsService.removeMenuOrganize(menuCode);
		if(!removeMenuOranizeResult) {
			msg = "삭제 실패: 식단 포함 상품 정보 삭제를 하지 못했습니다.";
			return msg;
		}
		
		boolean removeMenuInformationResult = goodsService.removeMenuInformation(menuCode);
		if(!removeMenuInformationResult) {
			msg = "삭제 실패: 식단 정보 삭제를 하지 못했습니다.";
			return msg;
		}
		
		String goodsCode = goods.getGoodsCode();
		boolean removeGoodsResult = goodsService.removeGoods(goodsCode);
		if(!removeGoodsResult) {
			msg = "삭제 실패: 상품 정보를 삭제하지 못했습니다.";
			return msg;
		}
		
		String serverName = request.getServerName(); 
		log.info("{} <<<< serverName", serverName); 
		log.info("{} <<<< user 디렉토리", System.getProperty("user.dir"));
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
		
		//실제 상품 메인 이미지 삭제
		String goodsMainImageCode = goods.getGoodsMainImageCode();
		
		GoodsMainImage goodsMainImageInfo = goodsService.getGoodsMainImageInfo(goodsMainImageCode);
		String goodsMainImagePath = goodsMainImageInfo.getMainImagePath();
		
		String mainImageRealPath = Paths.get(fileRealPath + goodsMainImagePath).toString();
		File mainImage = new File(mainImageRealPath);
		if(mainImage.exists()) {
			if(mainImage.delete()) {
				log.info(">>>>>>>>>메인 이미지 삭제 성공");
			}else {
				msg = "삭제 실패: 메인 이미지 삭제가 실패하였습니다.";
				return msg;
			}
		}else {
			msg = "삭제 실패: 메인 이미지를 찾을 수 없습니다.";
			return msg;
		}
		
		//실제 상품 정보 이미지 삭제
		String goodsInfoImageCode = goods.getGoodsInfoImageCode();
		
		GoodsInfoImage goodsInfoImageInfo = goodsService.getGoodsInfoImageInfo(goodsInfoImageCode);
		String goodsInfoImagePath = goodsInfoImageInfo.getInfoImagePath();
		
		String infoImageRealPath = Paths.get(fileRealPath +  goodsInfoImagePath).toString();
		File infoImage = new File(infoImageRealPath);
		if(infoImage.exists()) {
			if(infoImage.delete()) {
				log.info(">>>>>>>>>소개 이미지 삭제 성공");
			}else {
				msg = "삭제 실패: 정보 이미지 삭제가 실패하였습니다.";
				return msg;
			}
		}else {
			msg = "삭제 실패: 정보 이미지를 찾을 수 없습니다.";
			return msg;
		}
		
		//DB의 상품 메인 이미지 정보 삭제
		boolean removeGoodsMainImageResult = goodsService.removeGoodsMainImage(goodsMainImageCode);
		if(!removeGoodsMainImageResult) {
			msg = "삭제 실패: 상품 메인 이미지를 삭제하지 못했습니다.";
			return msg;
		}
		
		//DB의 상품 정보 이미지 정보 삭제 
		boolean removeGoodsInfoImageResult = goodsService.removeGoodsInfoImage(goodsInfoImageCode);
		if(!removeGoodsInfoImageResult) {
			msg = "삭제 실패: 상품 정보 이미지를 삭제하지 못했습니다.";
			return msg;
		}
		
		return msg;
	}

	// 개별 식단 정보
	@GetMapping("/menu/menuDetail/{menuCode}")
	public String getMenuInfo(@PathVariable(value = "menuCode") String menuCode
							 ,Model model
							 ,HttpServletRequest request) {
		//String serverName = request.getServerName();
		List<Goods> menuOrgarnizeGoodsInfoList = goodsService.getMenuOrganizeGoodsInfo(menuCode);
		Goods menuInfo = goodsService.getMenuInfo(menuCode);
		List<MenuOrganize> menuOrganizeList = goodsService.getMenuOrganizeList(menuCode);
		
		model.addAttribute("title", "개별 식단 정보");
		model.addAttribute("menuInfo", menuInfo);
		model.addAttribute("menuOrgarnizeGoodsInfoList", menuOrgarnizeGoodsInfoList);
		model.addAttribute("menuOrganizeList", menuOrganizeList);
		return "admin/goods/menu/menuDetail";
	}

	// 상품별 할인 혜택 등록 폼
	@GetMapping("/discount/regGoodsDiscount")
	public String addGoodsDiscountForm() {
		return "admin/goods/discount/regGoodsDiscount";
	}

	// 상품별 할인 혜택 등록 처리
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
		
		//세션 생성 후 변경 
		//String memberId = session.getAttribute("SID");
		//해당 아이디 값으로 enterprise 조회후 entercode 또한 세팅해줘야함
		//픽스한 값으로 설정
		String memberId = "id001";
		goodsDiscount.setGoodsDiscountRegistrant(memberId);
		
		log.info(goodsDiscount.toString());
		goodsService.addGoodsDiscount(goodsDiscount);
		
		return "redirect:/admin/goods/discount/goodsDiscountList";
	}

	// 상품별 할인 혜택 리스트
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
		
		model.addAttribute("title", "상품별 할인 혜택 목록");
		model.addAttribute("goodsDiscountList", goodsDiscountList);
		if(msg!=null) model.addAttribute("msg", msg);
		return "admin/goods/discount/goodsDiscountList";
	}

	// 상품별 할인 혜택 수정 폼
	@GetMapping("/discount/updateGoodsDiscount/{goodsDiscountCode}")
	public String modifyGoodsDiscountForm(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
										 ,Model model) {
		GoodsDiscount goodsDiscountInfo = goodsService.modifyGoodsDiscountForm(goodsDiscountCode);
		model.addAttribute("goodsDiscountInfo", goodsDiscountInfo);
		return "admin/goods/discount/updateGoodsDiscount";
	}

	// 상품별 할인 혜택 수정 처리
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
		
		//세션 생성 후 아래 과정으로 대체
		//String memberId = session.getAttribute("SID");
		//없으니 픽스된 값 사용
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		System.out.println(goodsDiscount.toString());
		if(idCheckResult) {
			boolean result = goodsService.modifyGoodsDiscount(goodsDiscount);
			if(result) {
				reAttr.addAttribute("msg", "수정이 정상적으로 완료되었습니다.");
			}else {
				reAttr.addAttribute("msg", "수정 실패: GoodsMapper 확인");
			}
		}else {
			reAttr.addAttribute("msg", "수정 실패: 비밀번호를 확인해주세요.");
		}

		return "redirect:/admin/goods/discount/goodsDiscountList";
	}
	
	//상품별 할인 혜택 삭제 폼
	@GetMapping("/discount/removeGoodsDiscount/{goodsDiscountCode}")
	public String removeGoodsDiscountForm(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
										 ,Model model) {
		GoodsDiscount goodsDiscountInfo = goodsService.removeGoodsDiscountForm(goodsDiscountCode);
		
		model.addAttribute("goodsDiscountInfo", goodsDiscountInfo);
		return "admin/goods/discount/removeGoodsDiscount";
	}

	// 상품별 할인 혜택 삭제 처리
	@PostMapping("/discount/removeGoodsDiscount/{goodsDiscountCode}")
	public String removeGoodsDiscount(@PathVariable(value = "goodsDiscountCode") String goodsDiscountCode
									 ,@RequestParam(value = "memberPw") String memberPw
									 ,HttpSession session
									 ,RedirectAttributes reAttr) {
		//세션 생성 후 아래 과정으로 대체
		//String memberId = session.getAttribute("SID");
		//없으니 픽스한 값 사용
		String memberId = "id001";
		boolean idCheckResult = commonService.sessionIdPwCheck(memberId, memberPw);
		
		if(idCheckResult) {
			boolean result2 = goodsService.removeGoodsDiscount(goodsDiscountCode);
			if(result2) {
				reAttr.addAttribute("msg", "삭제가 정상적으로 완료되었습니다");
			}else {
				reAttr.addAttribute("msg", "삭제 실패: GoodsMapper 확인");
			}
		}else {
			reAttr.addAttribute("msg", "삭제 실패: 비밀번호를 확인해주세요.");
		}
		
		return "redirect:/admin/goods/discount/goodsDiscountList";
	}
}
