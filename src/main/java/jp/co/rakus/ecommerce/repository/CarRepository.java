package jp.co.rakus.ecommerce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.Grade;
import jp.co.rakus.ecommerce.domain.Shop;

@Repository
public class CarRepository {

	private static final RowMapper<Car> rowMapper = (rs, i) -> {
		Car car = new Car();
		car.setId(rs.getInt("id"));
		car.setName(rs.getString("name"));
		car.setImagePath(rs.getString("imagePath"));

		Grade grade = new Grade(rs.getInt("g_id"), rs.getString("g_name"), rs.getInt("price"));
		car.setGrade(grade);
		Shop shop = new Shop(rs.getInt("s_id"), rs.getString("s_name"), rs.getString("address"));
		car.setShop(shop);

		return car;
	};

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public Car findOne(int id) {
		String sql = "SELECT cars.id AS id, cars.name AS name, imagepath, grades.id AS g_id, grades.name AS g_name, price, shops.id AS s_id, shops.name AS s_name, address"
				+ " FROM cars"
				+ " JOIN grades"
				+ " ON cars.grade_id = grades.id"
				+ " JOIN shops"
				+ " ON cars.shop_id = shops.id"
				+ " WHERE cars.id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", id);
		Car car = jdbc.queryForObject(sql, param, rowMapper);
		return car;
	}
}
