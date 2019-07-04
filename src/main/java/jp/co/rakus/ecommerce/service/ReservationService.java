package jp.co.rakus.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository repository;

	public ReservationCar findOne(int id) {
		return repository.findOne(id);
	}

//	public Map<Integer, String> addRadioButton(Model model) {
//		Map<Integer, String> settlementMap = new LinkedHashMap<>();
//		settlementMap.put(0, "代金引換");
//		settlementMap.put(1, "クレジットカード決済");
//		model.addAttribute("settlementMap", settlementMap);
//		return Collections.unmodifiableMap(settlementMap);
//	}

	public void save(int id, int settlementId) {
		repository.save(id,settlementId);
	}

	public int setReservationId(ReservationCar reservationCar) {
		return repository.setReservationId(reservationCar);
	}
}
