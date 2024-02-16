package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.book;
import model.listDetails;
import model.reader;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
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
		// TODO Auto-generated method stub
		listDetailsHelper dao = new listDetailsHelper();
		bookHelper bh = new bookHelper();
		readerHelper rh = new readerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		listDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String readerName = request.getParameter("readerName");
		reader newReader = rh.findReader(readerName);
		try {
			String[] selectedItems =request.getParameterValues("allItemsToAdd");
			List<book> selectedItemsInList = new ArrayList<book>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				book c = bh.searchForBookById(Integer.
				parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListofBooks(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<book> selectedItemsInList = new ArrayList<book>();
			listToUpdate.setListofBooks(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setReader(newReader);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
