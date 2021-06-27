package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the current session
        HttpSession session = request.getSession();

        String registerCheck = (String) session.getAttribute("username");
        String getAction = request.getParameter("action");

        // When users click the logout hyperlink
        try {
            if (getAction.equals("logout")) {
                session.invalidate();
                session = request.getSession();
                String logoutText = "You have succesfully logged out!";
                request.setAttribute("displayText", logoutText);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            System.err.println("No action registered");
        }

        // if there is no resgistered username, redirect user to register page
        if (registerCheck == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the current session
        HttpSession session = request.getSession();

        String userName = request.getParameter("username");

        if (userName == null || userName.equals("")) {
//            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            response.sendRedirect("ShoppingList");
        } else {
//            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            response.sendRedirect("ShoppingList");
            session.setAttribute("username", userName);
        }

        String getAction = request.getParameter("action");
        ArrayList<String> shoppingList = new ArrayList<String>();
        if(session.getAttribute("itemList") != null){
            shoppingList = (ArrayList<String>) session.getAttribute("itemList");
        }

        // adding shopping list items to AL to be printed
        if (getAction.equals("add")) {
            String item = request.getParameter("item");
            if (item != null) {
                shoppingList.add(item); 
                session.setAttribute("itemList", shoppingList);
            } else {
                String addItemMessage = "Please enter a valid item";
                request.setAttribute("addItemText", addItemMessage);
            }
        }
        
        if(getAction.equals("delete")){
            String itemSelected = request.getParameter("item");
            shoppingList.remove(itemSelected);
        }

    }

}
