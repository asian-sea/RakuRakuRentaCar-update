package jp.co.rakus.ecommerce.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce.domain.Account;

@Repository
public class AccountRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private PasswordEncoder passwordEncoder;

//	ユーザ情報を保存
	public Account save(Account account) {
		String password = passwordEncoder.encode(account.getPassword());
		account.setPassword(password);
		SqlParameterSource param=new BeanPropertySqlParameterSource(account);

		if (account.getId() == null) {
			jdbcTemplate.update(
					"INSERT INTO users(name,address,telephone,email,password) values(:name,:address,:telephone,:email,:password)",
					param);


		} else {
			jdbcTemplate.update(
					"UPDATE users SET name=:name,address=:address,telephone=:telephone,email=:email,password=:password, WHERE id=:id",
					param);

		}
			return account;
	}


}
