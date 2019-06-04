package jp.co.rakus.ecommerce.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.Grade;
import jp.co.rakus.ecommerce.domain.Option;
import jp.co.rakus.ecommerce.domain.Shop;
import jp.co.rakus.ecommerce.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public List<Grade> findAllGrade() {
		List<Grade> gradeList = repository.findAllGrade();
		return gradeList;
	}

	public List<Shop> findAllShop(){
		List<Shop> shopList = repository.findAllShop();
		return shopList;
	}
	

	public List<Car> findByShopId(int id){
		List<Car> carList = repository.findByShopId(id);
		return carList;
	}

	public List<Car> findByGradeId(int id){
		List<Car> carList = repository.findByGradeId(id);
		return carList;
	}
	
	public List<Car> findByShopIdAndGradeId(int shopId, int gradeId){
		List<Car> carList = repository.findByShopIdAndGradeId(shopId, gradeId);
		return carList;
	}
	
	public void addRadioButton(Model model) {
		Map<Integer, String> settlementMap = new LinkedHashMap<>();
		settlementMap.put(1, "新宿店");
		settlementMap.put(2, "調布店");
		settlementMap.put(3, "静岡店");
		model.addAttribute("settlementMap", settlementMap);
		
		Map<Integer, String> settlementMap1 = new LinkedHashMap<>();
		settlementMap1.put(1, "コンパクトカー");
		settlementMap1.put(2, "セダン");
		settlementMap1.put(3, "スポーツカー");
		model.addAttribute("settlementMap1", settlementMap1);
	}

	public Car findOne(int id) {
		Car car = repository.findOne(id);
		return car;
	}

	public List<Option> findAllOption() {
		List<Option> optionList = repository.findAllOption();
		return optionList;
	}

//	public void addRadioButton(Model model) {
//		Map<Integer, String> smokeMap = new LinkedHashMap<>();
//		smokeMap.put(0, "禁煙");
//		smokeMap.put(1, "喫煙");
//		model.addAttribute("smokeMap", smokeMap);
//
//		Map<Integer, String> etcMap = new LinkedHashMap<>();
//		etcMap.put(0, "なし");
//		etcMap.put(1, "あり");
//		model.addAttribute("etcMap", etcMap);
//
//		Map<Integer, String> childSeatMap = new LinkedHashMap<>();
//		childSeatMap.put(0, "なし");
//		childSeatMap.put(1, "あり");
//		model.addAttribute("childSeatMap", childSeatMap);
//	}
}
