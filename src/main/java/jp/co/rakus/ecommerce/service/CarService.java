package jp.co.rakus.ecommerce.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.Grade;
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

	public Car findOne(int id) {
		Car car = repository.findOne(id);
		return car;
	}

	public void addRadioButton(Model model) {
		Map<Integer, String> smokeMap = new LinkedHashMap<>();
		smokeMap.put(0, "禁煙");
		smokeMap.put(1, "喫煙");
		model.addAttribute("smokeMap", smokeMap);

		Map<Integer, String> etcMap = new LinkedHashMap<>();
		etcMap.put(0, "なし");
		etcMap.put(1, "あり");
		model.addAttribute("etcMap", etcMap);

		Map<Integer, String> childSeatMap = new LinkedHashMap<>();
		childSeatMap.put(0, "なし");
		childSeatMap.put(1, "あり");
		model.addAttribute("childSeatMap", childSeatMap);
	}
}
