package pack.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	public static final String DATABASE = "jdbc:mysql://mysql:3306/test_mvc_crud";
	public static final String LOGIN = "adminskllvJ7";
	public static final String PASSWORD = "VHz5X3422RDV";

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Connection connexion = null;
                Statement statement = null;
                ResultSet resultat = null;
		
		 try {
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException e) { }
 
		
		connexion = DriverManager.getConnection(DATABASE, LOGIN, PASSWORD);
		
		String login1 ="";
		
		try {
                    
                     statement = connexion.createStatement();
                     resultat = statement.executeQuery("SELECT  login FROM client;");

                     while (resultat.next()) {
                         login1 = login1+resultat.getString("login");
                    }

                     connexion.close();

                } catch (SQLException e) {
                      e.printStackTrace();
                }
		
		// TODO Auto-generated method stub
		response.getWriter().append("Hello  -  "+login1+"   - je suis la servlet Test MODIFICATION !!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
