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
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		bookHelper bh = new bookHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String readerName = request.getParameter("readerName");
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<book> selectedBooksInList = new ArrayList<book>();
		if (selectedBooks != null && selectedBooks.length > 0){
			for(int i = 0; i<selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				book c = bh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(c);
			}
		}
		reader reader = new reader(readerName);
		listDetails sld = new listDetails(listName, reader);
		sld.setListofBooks(selectedBooksInList);
		listDetailsHelper slh = new listDetailsHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
