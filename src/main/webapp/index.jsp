<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.itheima.dao.IUserDao" %>
<%@ page import="com.itheima.utils.SqlSessionFactoryUtil" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    SqlSession sqlSession = SqlSessionFactoryUtil.openSession(true);
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    List<User> users = userDao.findAll();
    for (User user : users) {
        System.out.println(user);
    }
    SqlSessionFactoryUtil.close(sqlSession);
%>
</body>
</html>
