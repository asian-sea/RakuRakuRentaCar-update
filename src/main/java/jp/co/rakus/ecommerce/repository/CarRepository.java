package jp.co.rakus.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.Grade;
import jp.co.rakus.ecommerce.domain.Option;
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

	private static final RowMapper<Grade> gradeRowMapper = (rs, i) -> {
		Grade grade = new Grade();
		grade.setId(rs.getInt("id"));
		grade.setName(rs.getString("name"));
		grade.setPrice(rs.getInt("price"));

		return grade;

	};

	private static final RowMapper<Shop> shopRowMapper = (rs, i) -> {
		Shop shop = new Shop();
		shop.setId(rs.getInt("id"));
		shop.setName(rs.getString("name"));
		shop.setAddress(rs.getString("address"));

		return shop;
	};

	private static final RowMapper<Car> carRowMapper = (rs, i) -> {
		Car car = new Car();
		car.setId(rs.getInt("id"));
		car.setName(rs.getString("name"));
		car.setImagePath(rs.getString("imagePath"));

		return car;
	};

	private static final RowMapper<Option> optionRowMapper = (rs, i) -> {
		Option option = new Option();
		option.setId(rs.getInt("id"));
		option.setName(rs.getString("name"));
		option.setPrice(rs.getInt("price"));

		return option;
	};


	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public List<Grade> findAllGrade(){
		String sql = "SELECT id, name, price from grades";
		List<Grade> gradeList = jdbc.query(sql, gradeRowMapper);
		return gradeList;
	}

	public List<Shop> findAllShop(){
		String sql = "SELECT id, name, address from shops";
		List<Shop> shopList = jdbc.query(sql, shopRowMapper);
		return shopList;
	}

	public List<Car> findByShopId(int id){
		String sql = "SELECT id, name, imagePath from cars WHERE shop_id = :shopId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("shopId", id);
		List<Car> carList = jdbc.query(sql, param, carRowMapper);
		return carList;
	}

	public List<Car> findByGradeId(int id){
		String sql = "SELECT id, name, imagePath from cars WHERE grade_id = :gradeId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("gradeId", id);
		List<Car> carList = jdbc.query(sql, param, carRowMapper);
		return carList;
	}
	
	public List<Car> findByShopIdAndGradeId(int shopId, int gradeId){
		String sql = "SELECT id, name, imagePath from cars WHERE shop_id = :shopId AND grade_id = :gradeId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("shopId", shopId)
				.addValue("gradeId", gradeId);
		List<Car> carList = jdbc.query(sql, param, carRowMapper);
		return carList;
	}

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

	public List<Option> findAllOption(){
		String sql = "SELECT id, name, price FROM options";
		List<Option> optionList = jdbc.query(sql, optionRowMapper);
		return optionList;
	}
}
