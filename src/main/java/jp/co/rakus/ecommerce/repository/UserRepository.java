package jp.co.rakus.ecommerce.repository;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import jp.co.rakus.ecommerce.domain.User;

@Repository
@Transactional
public class UserRepository {
	
	private static final RowMapper<User> userRowMapper=(rs,i) ->{
		Integer id=rs.getInt("id");
		String name=rs.getString("name");
		String email=rs.getString("email");
		String password=rs.getString("password");
		String address=rs.getString("address");
		String telephone=rs.getString("telephone");
		return new User(id,name,email,password,address,telephone);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbctemplate;
	
	
//	メールアドレス、パスワードからメンバー取得
	public User findByEmailAndPassword(String email,String password) {
		SqlParameterSource param=new MapSqlParameterSource()
				.addValue("email",email)
				.addValue("password",password);
		User user=null;
		
		try {
			user=jdbctemplate.queryForObject(
					"SELECT id,name,email,address,password,telephone FROM users WHERE email=:email AND password=:password",
					param,userRowMapper);
			
			return user;
		} catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
//	ユーザの新規登録
	public User save(User user) {
		SqlParameterSource param=new BeanPropertySqlParameterSource(user);
		
		if(user.getId()==null) {
			String insertSql="INSERT INTO user(name,email,password,address,telephone)"
								+"VALUES(:name,:email,:password,:address,:telephone)";
			
			jdbctemplate.update(insertSql,param);
		}else{
			String updateSql="UPDATE user SET name=:name,email=:email,password=:password,"
								+ "address=:address,:telephone=:telephone";
		jdbctemplate.update(updateSql, param);
		}
		
		return user;
	}
	
	public void deleteById(Integer id) {
		String deleteSql="DELETE FROM users WHERE id=:id";
		
		SqlParameterSource param=new MapSqlParameterSource().addValue("id",id);
		
		jdbctemplate.update(deleteSql,param);
	}

}
