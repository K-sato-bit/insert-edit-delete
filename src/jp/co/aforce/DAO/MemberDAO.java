package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.aforce.Bean.MemberBean;

public class MemberDAO extends ConnectionManager {

	//登録INSERT
	public int insert(MemberBean member) throws SQLException, ClassNotFoundException {
		
		//登録数
		int count = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement
						("INSERT INTO members "
								+ "VALUES(?,?,?,?,?,?)")) {

			Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
					String memberNo = "A" + sdf.format(date);
			//値の設定
			ps.setString(1, memberNo);
			ps.setString(2, member.getName());
			ps.setInt(3, member.getAge());
			ps.setInt(4, member.getBirth_year());
			ps.setInt(5, member.getBirth_month());
			ps.setInt(6, member.getBirth_day());
			count = ps.executeUpdate();

			con.close();
			ps.close();
		}
		
		return count;
		
	}


	//表示SELECT
		public MemberBean select(String member_no) throws SQLException, ClassNotFoundException {
			
			MemberBean member = new MemberBean();
			
			//指定したno
			String sql = "SELECT * FROM  members WHERE member_no = ?";
			
			//データベース接続
			try(Connection con = ConnectionManager.getConnection();
					PreparedStatement ps = con.prepareStatement(sql);) {
				
				//設定
				ps.setString(1, member_no);
				
				ResultSet rs = ps.executeQuery();
				
				//結果
				while (rs.next()){
			
				member.setMember_no(rs.getString("member_no"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setBirth_year(rs.getInt("birth_year"));
				member.setBirth_month(rs.getInt("birth_month"));
				member.setBirth_day(rs.getInt("birth_day"));
				
				}
				
			}
			return member;
			
		}
	
		
	//一覧SELECTALL
	public List<MemberBean> selectAll() throws SQLException, ClassNotFoundException {
		
		List<MemberBean> memberList = new ArrayList<MemberBean>();
		
		try (Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM members")){
			
			while (rs.next()) {
				String member_no = rs.getString("member_no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int birth_year = rs.getInt("birth_year");
				int birth_month = rs.getInt("birth_month");
				int birth_day = rs.getInt("birth_day");
				
				MemberBean member = new MemberBean();
				member.setMember_no(member_no);
				member.setName(name);
				member.setAge(age);
				member.setBirth_year(birth_year);
				member.setBirth_month(birth_month);
				member.setBirth_day(birth_day);
					
				memberList.add(member);
				
			}
		}
		
		return memberList;
	}
		
	
	//編集EDIT
	public int edit(MemberBean member) throws SQLException, ClassNotFoundException {
		//編集数
		int count = 0;

		String sql = "UPDATE members SET member_no = ?, name = ?, age = ?, birth_year = ?, birth_month=?, birth_day = ? WHERE member_no = ?";
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {

			//値の設定
			ps.setString(1, member.getMember_no());
			ps.setString(2, member.getName());
			ps.setInt(3, member.getAge());
			ps.setInt(4, member.getBirth_year());
			ps.setInt(5, member.getBirth_month());
			ps.setInt(6, member.getBirth_day());
			ps.setString(7, member.getMember_no());
			
	
			count = ps.executeUpdate();
		}
		
		return count;
	}
	
	
	//削除DELETE
	public int delete(String member_no) throws SQLException, ClassNotFoundException {
		//削除数
		int count = 0;
		
		String sql = "DELETE FROM members WHERE member_no =?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, member_no);

			count = ps.executeUpdate();
		}

		return count;
	}
}


