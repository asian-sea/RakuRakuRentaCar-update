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
		car.setTotalPrice(rs.getInt("total_price"));
		car.setReservationId(rs.getString("reservation_id"));
		car.setCarName(rs.getString("name"));
		car.setImagePath(rs.getString("imagepath"));
		return car;
	};

//	private static final RowMapper<Car> carRowMapper = (rs,i) -> {
//		Car car = new Car();
//		car.setId(rs.getInt("id"));
//		car.setName(rs.getString("name"));
//		car.setImagePath(rs.getString("imagepath"));
//		return car;
//	};

	//予約履歴を表示
	public List<ReservationCar> findHistory(int id){
		String sql = "SELECT r.id, status, car_id, start_date, end_date, user_id, total_price, reservation_id, name, imagepath"
				+ " FROM reservation_cars AS r JOIN cars AS c ON car_id = c.id WHERE user_id = :id AND status = 2 ORDER BY id DESC";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<ReservationCar> reservationHistoryList = template.query(sql, param, reservationHistoryRowMapper);
		return reservationHistoryList;
	}

	//車種名、画像を表示
	public List<ReservationCar> findCar(int id) {
		String sql = "SELECT r.id, r.car_id, r.start_date, r.end_date, r.total_price, r.reservation_id, c.name, c.imagepath"
				+ " FROM cars AS c JOIN reservation_cars AS r ON c.id = r.car_id WHERE r.id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<ReservationCar> reservationCarDetail = template.query(sql, param, reservationHistoryRowMapper);
		return reservationCarDetail;
	}

	//予約キャンセル
	public void cancel(int id) {
		String cancelSql = "UPDATE reservation_cars SET status = 3 WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(cancelSql, param);
	}



}
