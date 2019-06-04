package jp.co.rakus.ecommerce.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.Grade;
import jp.co.rakus.ecommerce.domain.Option;
import jp.co.rakus.ecommerce.domain.Shop;
import jp.co.rakus.ecommerce.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;

	//home画面に営業所とグレードを出力
	@RequestMapping(value="/")
	public String index(Model model, @ModelAttribute CarForm form) {
		List<Grade> gradeList = new ArrayList<Grade>();
		gradeList = service.findAllGrade();
		model.addAttribute("gradeList", gradeList);
		List<Shop> shopList = new ArrayList<Shop>();
		shopList = service.findAllShop();
		model.addAttribute("shopList", shopList);
		service.addRadioButton(model);
		return "home";//home画面を呼び出し
	}

	//home画面で選択された営業店のidの値を取得し、serviceクラスのfindByShopIdに引数として渡す
	@RequestMapping(value="/toCarList/{id}")
	public String toCarList(Model model, @PathVariable Integer id) {
		List<Car> carList = new ArrayList<Car>();
		carList = service.findByShopId(id);
		model.addAttribute("carList", carList);
		return "carList";//車種一覧画面を呼び出し
	}

	//home画面で選択されたグレードのidの値を取得、serviceクラスのfindByGradeIdに引数として渡す
	@RequestMapping(value="/toCarList1/{id}")
	public String toCarList1(Model model, @PathVariable Integer id) {
		List<Car> carList = new ArrayList<Car>();
		carList = service.findByGradeId(id);
		model.addAttribute("carList", carList);
		return "carList";//車種一覧画面を呼び出し
	}
	
	@RequestMapping(value="/toCarList2")
	public String toCarList2(Model model,CarForm form) {
		List<Car> carList = new ArrayList<Car>();
		int shopId = form.getSettlement();
		int gradeId = form.getSettlement1();
		carList = service.findByShopIdAndGradeId(shopId,gradeId);
		model.addAttribute("carList", carList);
		return "carList";//車種一覧画面を呼び出し
	}


	@RequestMapping("/detail/{id}")
	public String showDetail(Model model, @PathVariable Integer id, @ModelAttribute ReservationCarForm form) {
		Car car = service.findOne(id);
		model.addAttribute("car", car);
		List<Option> optionList = service.findAllOption();
		model.addAttribute("optionList", optionList);
		return "carDetail";
	}
}
