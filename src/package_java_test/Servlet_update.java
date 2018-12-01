package package_java_test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_update
 */
@WebServlet("/Servlet_update")
public class Servlet_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentID=Integer.parseInt(request.getParameter("studentID"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String ID_number=request.getParameter("number_ID");
		String address=request.getParameter("address");
		System.out.println("---------------------------------");
		System.out.println(studentID);
		System.out.println(name);
		System.out.println(age);
		System.out.println(ID_number);
		System.out.println(address);
		UserManage userManage=new UserManage();
		UserInfo userInfo=new UserInfo();
		userInfo.setAddress(address);
		userInfo.setAge(age);
		userInfo.setID_number(ID_number);
		userInfo.setName(name);
		userInfo.setStudentID(studentID);
		userManage.update(userInfo);
		request.setAttribute("Info", userInfo);
		request.getRequestDispatcher("update_message.jsp").forward(request, response);
		
	}

}
