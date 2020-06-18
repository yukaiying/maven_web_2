package action;

import bean.User;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterAction extends HttpServlet {
    UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User(req.getParameter("username"),req.getParameter("password"));
        userDaoImpl.insertUser(user);
    }
}
