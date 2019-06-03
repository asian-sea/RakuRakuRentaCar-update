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

import jp.co.rakus.ecommerce.domain.User;

@Repository
@Transactional
public class UserRepository {
	@Autowired
	NamedParameterJdbcTemplate template;
	
	private static final RowMapper<User>userRowMapper=(rs,i) ->{
		User user=new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};
	
	public List<User>findAll(){
		
		String sql="SELECT id,name,email,password,addless,telephone FROM users ORDER BY id";
		
		List<User>userList = template.query(sql,userRowMapper);
		
		return userList;
	}
	
	public User save(User user) {
		SqlParameterSource param=new BeanPropertySqlParameterSource(user);
		
		if(user.getId()==null) {
			String insertSql="INSERT INTO user(name,email,password,address,telephone)"
								+"VALUES(:name,:email,:password,:address,:telephone)";
			
			template.update(insertSql,param);
		}else{
			String updateSql="UPDATE user SET name=:name,email=:email,password=:password,"
								+ "address=:address,:telephone=:telephone";
		template.update(updateSql, param);
		}
		
		return user;
	}
	
	public void deleteById(Integer id) {
		String deleteSql="DELETE FROM users WHERE id=:id";
		
		SqlParameterSource param=new MapSqlParameterSource().addValue("id",id);
		
		template.update(deleteSql,param);
	}

}
