package jp.co.aforce.edit;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Bean.MemberBean;
import jp.co.aforce.DAO.MemberDAO;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/servlet/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		//転送先
		String url = "../jsp/edit.jsp";

		if (request.getParameter("name").equals("") || request.getParameter("age").equals("")) {

			request.setAttribute("message", "*エラー　入力されていない項目があります。");

		} else {

			//リクエストパラメータの取得
			String member_no = request.getParameter("member_no");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day = Integer.parseInt(request.getParameter("birth_day"));

			//データベースに追加するデータを保持するオブジェクト作成、設定
			MemberBean member = new MemberBean();
			member.setMember_no(member_no);
			member.setName(name);
			member.setAge(age);
			member.setBirth_year(birth_year);
			member.setBirth_month(birth_month);
			member.setBirth_day(birth_day);

			//DAO生成
			MemberDAO dao = new MemberDAO();

			int count = 0;
			try {
				//DAO利用（データベースの追加）
				count = dao.edit(member);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			if (count > 0) {
				url = "../jsp/edit-result.jsp";

			} else {
				url = "../jsp/edit-error.jsp";
			}

			//セッションオブジェクトの取得
			HttpSession session = request.getSession();

			//セッションスコープへの設定
			session.setAttribute("member", member);

		}
		
		//リクエスト転送
		request.getRequestDispatcher("../jsp/edit-result.jsp").forward(request, response);

	}
}
