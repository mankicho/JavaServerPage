package jdbc;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

public class DBCPInitListener implements ServletContextListener {
    // 웹 어플리케이션을 시작할때 호출되는 매소드
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String poolConfig = servletContextEvent.getServletContext().getInitParameter("poolConfig");
        Properties prop = new Properties();

        try {
            // Properties 객체에 poolConfig 정보를 대입.
            prop.load(new StringReader(poolConfig));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadJDBCDriver(prop);
        initConnectionPool(prop);
    }

    // 웹 어플리케이션을 종료할때 호출되는 매소드
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void loadJDBCDriver(Properties prop) {
        String driverClass = prop.getProperty("jdbcDriver");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initConnectionPool(Properties prop) {
        try {
            String jdbcUrl = prop.getProperty("jdbcUrl");
            String dbUser = prop.getProperty("dbUser");
            String dbPassword = prop.getProperty("dbPassword");
            String poolName = prop.getProperty("poolName");

            ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(jdbcUrl, dbUser, dbPassword);
            PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
            poolableConnectionFactory.setValidationQuery("select 1");

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L); // 10분에 한번 사용하지않는 커넥션 제거
            poolConfig.setMaxIdle(50);
            poolConfig.setMaxIdle(4);
            poolConfig.setTestWhileIdle(true);

            GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
            poolableConnectionFactory.setPool(connectionPool);

            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.registerPool(poolName, connectionPool);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
