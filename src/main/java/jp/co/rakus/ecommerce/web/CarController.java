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
import jp.co.rakus.ecommerce.domain.Shop;
import jp.co.rakus.ecommerce.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		List<Grade> gradeList = new ArrayList<Grade>();
		gradeList = service.findAllGrade();
		model.addAttribute("gradeList", gradeList);
		List<Shop> shopList = new ArrayList<Shop>();
		shopList = service.findAllShop();
		model.addAttribute("shopList", shopList);
		return "home";
	}
	
	@RequestMapping(value="/toCarList/{id}")
	public String toCarList(Model model, @PathVariable Integer id) {
		List<Car> carList = new ArrayList<Car>();
		carList = service.findByShopId(id);
		model.addAttribute("carList", carList);
		return "carList";
	}
	
//	@RequestMapping(value="/toCarList1/{id}")
//	public String toCarList1(Model model, @PathVariable Integer id) {
//		List<Car> carList = new ArrayList<Car>();
//	}
		
	
	@RequestMapping("/detail")
	public String showDetail(Model model, @ModelAttribute ReservationCarForm form) {
		Car car = service.findOne(1);
		model.addAttribute("car", car);
		service.addRadioButton(model);
		return "carDetail";
	}
}
