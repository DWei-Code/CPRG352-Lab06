package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

        if (getAction.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            String logoutText = "You have succesfully logged out!";
            request.setAttribute("displayText", logoutText);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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
        session.setAttribute("username", userName);

        if (userName == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        }
    }

}
