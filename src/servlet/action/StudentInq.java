package servlet.action;

import servlet.data.hqsj;
import servlet.json.core.ListObject;
import servlet.json.responseUtils.ResponseUtils;
import servlet.json.status.StatusHouse;
import servlet.json.utils.JackJsonUtils;
import servlet.model.lilunkejiaoxue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class StudentInq
 */
public class StudentInq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<lilunkejiaoxue> list = hqsj.getAlllilunkejiaoxue();
		ListObject listObject=new ListObject();
		listObject.setItems(list);
		listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listObject);
		ResponseUtils.renderJson(response, responseText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
