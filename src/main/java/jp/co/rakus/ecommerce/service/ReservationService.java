package jp.co.rakus.ecommerce.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository repository;

	public ReservationCar findOne(int id) {
		return repository.findOne(id);
	}

	public void addRadioButton(Model model) {
		Map<Integer, String> settlementMap = new LinkedHashMap<>();
		settlementMap.put(0, "代金引換");
		settlementMap.put(1, "クレジットカード決済");
		model.addAttribute("settlementMap", settlementMap);
	}
}
