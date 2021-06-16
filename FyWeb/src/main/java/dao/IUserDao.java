package dao;



import bean.User;

import java.util.List;

/**
 * 只规定能做什么，具体如何去做，不清楚
 */
public interface IUserDao {
    List<User> viewUser(int curPage);
    int totalPage();
}
