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
		reservationCar.setStatus(rs.getInt("status"));
		reservationCar.setCarId(rs.getInt("car_id"));
		reservationCar.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
		reservationCar.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
		return reservationCar;
	};



	//キープを追加
	public int save(ReservationCar reservationCar) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(reservationCar);

		String insertSql = "INSERT INTO reservation_cars(status, car_id, start_date, end_date, user_id, settlement_id)"
				+ "VALUES(1, :carId, :startDate, :endDate, :userId, -1)"
				+ "RETURNING id";

		return template.queryForObject(insertSql, param, Integer.class);
	}

	//オプション内容
	public void saveOption(int optionId, int reservationCarId) {
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("optionId", optionId)
				.addValue("reservationCarId", reservationCarId);

		String optionSql = "INSERT INTO reservation_options (option_id, reservation_car_id)"
				+ "VALUES(:optionId, :reservationCarId)";

		template.update(optionSql, param);
	}

	public int findOneOption(int optionId) {
		String sql = "SELECT price FROM options WHERE id = :optionId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("optionId", optionId);
		return template.queryForObject(sql, param, Integer.class);
	}
	//キープを表示
	public List<ReservationCar> findAll(int id){
		String sql = "SELECT id, status, car_id, start_date, end_date FROM reservation_cars WHERE user_id = :id AND status = 1 ORDER BY id DESC";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id",id);
		List<ReservationCar> reservationCarList = template.query(sql, param, reservationCarRowMapper);
		return reservationCarList;
	}

	//キープを削除
	public void delete(int id) {
		String deleteSql = "DELETE FROM reservation_cars WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		template.update(deleteSql, param);
	}

}
