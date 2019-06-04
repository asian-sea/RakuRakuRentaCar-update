package jp.co.rakus.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce.domain.ReservationCar;

@Repository
@Transactional

public class ReservationCarRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	//RowMapper comment
	private static final RowMapper<ReservationCar> reservationCarRowMapper = (rs,i) -> {
		ReservationCar reservationCar = new ReservationCar();
		reservationCar.setId(rs.getInt("id"));
		reservationCar.setCarId(rs.getInt("car_id"));
		reservationCar.setReservationId(rs.getInt("reservation_id"));
		reservationCar.setStartDate(rs.getTimestamp("start_date"));
		reservationCar.setEndDate(rs.getTimestamp("end_date"));
		return reservationCar;
	};



	//キープを追加
	public void save(ReservationCar reservationCar) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(reservationCar);

		String insertSql = "INSERT INTO reservation_cars(car_id, reservation_id, start_date, end_date, user_id)"
				+ "VALUES(:carId, :reservationId, :startDate, :endDate, :userId)";

		template.update(insertSql, param);
	}

	//オプション内容
	public void saveOption(ReservationCar reservationCar) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(reservationCar);

		String optionSql = "INSERT INTO reservation_options (option_id, reservation_car_id)"
				+ "VALUES(:optionId, :reservationCarId)";

		template.update(optionSql, param);
	}

	//キープを表示
	public List<ReservationCar> findAll(int id){
		String sql = "SELECT id, car_id, reservation_id, start_date, end_date, option FROM reservation_cars ORDER BY id DESC";
		List<ReservationCar> reservationCarList = template.query(sql, reservationCarRowMapper);
		return reservationCarList;
	}

	//キープを削除
	public void delete(int id) {
		String deleteSql = "DELETE FROM reservation_cars WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		template.update(deleteSql, param);
	}

}
