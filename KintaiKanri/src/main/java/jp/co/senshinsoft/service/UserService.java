package jp.co.senshinsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.senshinsoft.domain.User;
import jp.co.senshinsoft.persistence.UserMapper;

@Service
public class UserService {
	
	@Autowired
	public UserMapper mapper;
	
	
	/**
	 * mapperを呼び出して、ログインしている社員の名前(姓と名)をリストで取得する。
	 * テーブル名：user
	 * @param userId ログインしている社員の社員ID
	 * @return ログインしている社員の名前
	 */
	public String findEmployeeName(String userId){
		String userName = null;
		List<String> list = mapper.findEmployeeName(userId);
		for(String s : list) {
			userName+=s;
		}
		return userName;
	}
	
	
	/**
	 * mapperを呼び出して、社員番号に該当するユーザ情報を取得する。
	 * @param userId
	 * @return 社員番号に該当するユーザ情報
	 */
	public User findAccountByUserId(String userId) {
		User user = mapper.findAccountByUserId(userId);

		return user;
	}
	
}