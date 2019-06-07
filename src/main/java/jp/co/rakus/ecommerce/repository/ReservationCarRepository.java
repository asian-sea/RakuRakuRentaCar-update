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

import jp.co.rakus.ecommerce.domain.Option;
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
		reservationCar.setTotalPrice(rs.getInt("total_price"));

//		Option option = new Option(rs.getInt("op_id"), rs.getString("op_name"), rs.getInt("op_price"));
//		reservationCar.setOption(option);

		return reservationCar;
	};

	private static final RowMapper<Option> optionRowMapper = (rs, i) -> {
		Option option = new Option();
		option.setId(rs.getInt("id"));
		option.setName(rs.getString("name"));
		option.setPrice(rs.getInt("price"));

		return option;
	};


	//キープを追加
	public int save(ReservationCar reservationCar) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(reservationCar);

		String insertSql = "INSERT INTO reservation_cars(status, car_id, start_date, end_date, total_price, user_id, settlement_id)"
				+ "VALUES(1, :carId, :startDate, :endDate, :totalPrice, :userId, -1)"
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
		String sql = "SELECT id, status, car_id, start_date, end_date, total_price FROM reservation_cars WHERE user_id = :id ORDER BY id DESC";
//				"SELECT reservation_cars.id AS id, reservation_cars.status AS status, reservation_cars.car_id AS car_id,"
//				+ " reservation_cars.start_date AS start_date, reservation_cars.end_date AS end_date, reservation_cars.total_price AS total_price,"
//				+ " options.id AS op_id, options.name AS op_name, options.price AS op_price"
//				+ " FROM reservation_cars"
//				+ " JOIN reservation_options"
//				+ " ON reservation_cars.id = reservation_options.reservation_car_id"
//				+ " JOIN options"
//				+ " ON reservation_options.option_id = options.id"
//				+ " WHERE user_id = :userId AND status = 1"
//				+ " ORDER BY reservation_cars.id DESC";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id",id);
		List<ReservationCar> reservationCarList = template.query(sql, param, reservationCarRowMapper);
		return reservationCarList;
	}

	//キープを表示
	public List<Option> findAllOption(int id){
		String sql = "SELECT id, name, price FROM options "
				+ " WHERE id IN(SELECT option_id FROM reservation_options WHERE status=1 AND reservation_car_id = :reservationCarId);";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("reservationCarId",id);
		List<Option> optionList = template.query(sql, param, optionRowMapper);
		return optionList;
	}

	public List<ReservationCar> findById(int id){
		String sql = "SELECT id, option_id, reservation_car_id WHERE reservation_car_id = :id";
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

	// キープのuserIdを変更
	public void updateUserId(int id, int dummyId) {
		String sql = "UPDATE reservation_cars SET user_id = :id WHERE user_id = :dummyId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id",id).addValue("dummyId", dummyId);
		template.update(sql, param);

	}

}
