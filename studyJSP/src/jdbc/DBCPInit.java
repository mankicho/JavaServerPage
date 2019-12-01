package jdbc;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCPInit extends HttpServlet {

    @Override
    public void init() throws ServletException {
        driverLoad();
        initConnectionPool();
    }

    private void driverLoad() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initConnectionPool() {
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8";
            String userName = "jmk";
            String userPassword = "mmk";

            ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, userName, userPassword);
            // 커넥션 풀이 커넥션 생성할 때 사용할 커넥션 팩토리를 생성.
            PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connFactory, null);
            // Poolable Connection을 생성하는 팩토리 생성. DBCP는 커넥션 풀에 커넥션을 보관할때 PoolableConnection을 사용.PoolableConnection은
            // 내부적으로 실제 커넥션을 담고있고 커넥션 풀을 관리하는데 필요한 기능을 추가로 제공한다. 예를들어 close() 메서드를 실행하면
            // 커넥션 종료가아니라 풀에 커넥션을 반환한다.
            poolableConnectionFactory.setValidationQuery("select 1");
            // 커넥션이 유효한지 여부를 검사할때 사용할 쿼리 지정.
            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            // 커넥션 풀의 설정정보 생성
            poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L); // 600초 마다 놀고있는 커넥션을 제거한다.
            poolConfig.setTestWhileIdle(true); // 유효하지않은 커넥션도 검사해서 연결이 끊긴 커넥션은 풀에서 제거한다.
            poolConfig.setMinIdle(4);
            poolConfig.setMaxIdle(50);
            // 여기까지 설정 정보.
            GenericObjectPool<PoolableConnection> genericObjectPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
            poolableConnectionFactory.setPool(genericObjectPool);
            // ppolableConnectionFactory에 커넥션 풀을 연결한다.
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            // 커넥션 풀을 제공하는 JDBC 드라이버 등록.
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.registerPool("jsp", genericObjectPool);
            // 웹 프로그램에서 사용하는 JDBC URL을 jdbc:apache:commons:dbcp:jsp로 지정.
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
