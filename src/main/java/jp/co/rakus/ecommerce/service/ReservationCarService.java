package jp.co.rakus.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.repository.ReservationCarRepository;

@Service

public class ReservationCarService {
	@Autowired
	private ReservationCarRepository reservationCarRepository;

	//キープに追加
	public void addCar(ReservationCar reservationCar) {
		reservationCarRepository.save(reservationCar);
	}

	//キープを表示
	public List<ReservationCar> findAll(){
		return reservationCarRepository.findAll();
	}

	//キープを削除
	public void delete(int id) {
		reservationCarRepository.delete(id);
	}

}
