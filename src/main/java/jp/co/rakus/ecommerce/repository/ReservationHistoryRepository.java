package jp.co.rakus.ecommerce.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce.domain.ReservationCar;

@Repository
@Transactional

public class ReservationHistoryRepository {

	private static final RowMapper<ReservationCar> rowMapper = (rs, i) -> {
		ReservationCar car = new ReservationCar();
		car.setId(rs.getInt("id"));
		car.setCarId(rs.getInt("car_id"));
		car.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
		car.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
		return car;
	};


}
