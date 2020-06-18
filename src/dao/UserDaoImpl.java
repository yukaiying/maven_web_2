package dao;

import bean.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    Connection con = DBUtils.getCon();

    @Override
    public void insertUser(User user){
        try {
            PreparedStatement ps = con.prepareStatement("insert into  tab_user(user_name,pass_word) values('"+user.getUserName()+"','"+user.getPassWord()+"')");
            ps.executeUpdate();
            DBUtils.closeCon(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
