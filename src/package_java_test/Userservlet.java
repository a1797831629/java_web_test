package package_java_test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Userservlet
 */
@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userservlet() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");  
		response.setCharacterEncoding("UTF-8");
		int studentID=Integer.parseInt(request.getParameter("studentID"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String ID_number=request.getParameter("number_ID");
		String address=request.getParameter("address");
		UserInfo userInfo=new UserInfo();
		UserManage userManage=new UserManage();
		userInfo.setAddress(address);
		userInfo.setAge(age);
		userInfo.setID_number(ID_number);
		userInfo.setName(name);
		userInfo.setStudentID(studentID);
		userInfo=userManage.add(userInfo);
		request.setAttribute("Info", userInfo);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
