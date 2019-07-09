package jp.co.rakus.ecommerce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		car.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
		car.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
		car.setTotalPrice(rs.getInt("total_price"));
		car.setReservationId(rs.getString("reservation_id"));

		return car;
	};

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public ReservationCar findOne(int id) {
		String sql =
//				"SELECT reservation_cars.id AS id, reservation_cars.car_id AS car_id,"
//				+ " reservation_cars.start_date AS start_date, reservation_cars.end_date AS end_date, reservation_cars.total_price AS total_price,"
//				+ " options.id AS op_id, options.name AS op_name, options.price AS op_price"
//				+ " FROM reservation_cars"
//				+ " JOIN reservation_options"
//				+ " ON reservation_cars.id = reservation_options.reservation_car_id"
//				+ " JOIN options"
//				+ " ON reservation_options.option_id = options.id"
//				+ " WHERE reservation_cars.id = :id";
				"SELECT id, car_id, start_date, end_date, total_price, reservation_id FROM reservation_cars WHERE id =:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		ReservationCar reservationCar = jdbc.queryForObject(sql, param, rowMapper);
		return reservationCar;
	}

	public void save(int id, int settlementId) {
		String sql = "UPDATE reservation_cars SET status = 2, settlement_id = :settlementId , reservation_date = now() WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("settlementId", settlementId)
				.addValue("id", id);
		jdbc.update(sql, param);
	}

	//予約ID発行
	public int setReservationId(ReservationCar reservationCar) {
		String sql = "UPDATE reservation_cars SET reservation_id = "
				+ " TO_CHAR(reservation_date, 'yyyymmdd')|| to_char(nextval('reservationID_seq'),'FM000000') WHERE id=:id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(reservationCar);
		return jdbc.update(sql, param);
	}

}
