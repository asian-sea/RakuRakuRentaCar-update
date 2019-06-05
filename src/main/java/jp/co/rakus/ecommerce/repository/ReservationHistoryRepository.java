package jp.co.rakus.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce.domain.ReservationCar;

@Repository
@Transactional

public class ReservationHistoryRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<ReservationCar> reservationHistoryRowMapper = (rs, i) -> {
		ReservationCar car = new ReservationCar();
		car.setId(rs.getInt("id"));
		car.setCarId(rs.getInt("car_id"));
		car.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
		car.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
		return car;
	};

	//予約履歴を表示
	public List<ReservationCar> findHistory(int id){
		String sql = "SELECT id, status, car_id, start_date, end_date, user_id FROM reservation_cars WHERE user_id = :id and status = 2 ORDER BY id DESC";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<ReservationCar> reservationHistoryList = template.query(sql, param, reservationHistoryRowMapper);
		return reservationHistoryList;
	}

	//予約キャンセル
	public void cancel(int id) {
		String cancelSql = "DELETE FROM reservation_cars WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(cancelSql, param);
	}


}
