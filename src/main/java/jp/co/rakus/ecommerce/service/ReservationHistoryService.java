package jp.co.rakus.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.repository.ReservationHistoryRepository;

@Service

public class ReservationHistoryService {

	@Autowired
	ReservationHistoryRepository reservationHistoryRepository;

	//予約履歴表示
	public List<ReservationCar> findHistory(int id){
		return reservationHistoryRepository.findHistory(id);
	}

	//車種名、画像を表示
	public List<ReservationCar> findCar(int id) {
		return reservationHistoryRepository.findCar(id);
	}

	//予約キャンセル
	public void cancel(int id) {
		reservationHistoryRepository.cancel(id);
	}

}
