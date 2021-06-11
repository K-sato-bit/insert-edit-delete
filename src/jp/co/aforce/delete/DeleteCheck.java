package jp.co.aforce.delete;

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
 * Servlet implementation class DeleteCheck
 */
@WebServlet("/jp.co.aforce.delete/delete-check")
public class DeleteCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//会員番号取得
		String member_no = request.getParameter("member_no");
		
		//セッションオブジェクト取得
		HttpSession session = request.getSession();

		//DAO生成
		MemberDAO dao = new MemberDAO();

		//転送先
		String url;

		MemberBean member = null;
		
		try {
			member = dao.select(member_no);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (member.getMember_no() != null) {

			url = "../jsp/delete.jsp";
			
			//セッションスコープ設定
			session.setAttribute("member", member);

		} else {
			url = "../jsp/delete-start.jsp";
			request.setAttribute("message", "*エラー　該当する会員情報が見つかりません。");
		}

		//リクエスト転送
		request.getRequestDispatcher(url).forward(request, response);
	}
}

