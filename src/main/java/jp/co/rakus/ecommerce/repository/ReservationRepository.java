package jp.co.rakus.ecommerce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce.domain.ReservationCar;

@Repository
public class ReservationRepository {

	private static final RowMapper<ReservationCar> rowMapper = (rs, i) -> {
		ReservationCar car = new ReservationCar();
		car.setId(rs.getInt("id"));
		car.setCarId(rs.getInt("car_id"));
		car.setReservationId(rs.getInt("reservation_id"));
		car.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
		car.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
		return car;
	};

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public ReservationCar findOne(int id) {
		String sql = "SELECT id, car_id, reservation_id, start_date, end_date"
				+ " FROM reservation_cars WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", id);
		ReservationCar reservationCar = jdbc.queryForObject(sql, param, rowMapper);
		return reservationCar;
	}
}
