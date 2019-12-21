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

    // 초기화 할 때
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String poolConfig = servletContextEvent.getServletContext().getInitParameter("poolConfig");
        Properties prop = new Properties();
        try {
            prop.load(new StringReader(poolConfig));
        } catch (IOException e) {
            throw new RuntimeException("prop.load makes exception " + e);
        }
        loadJdbc(prop);
        DBCPInit(prop);
    }

    // 종료 할 때
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void loadJdbc(Properties prop) {
        String driver = prop.getProperty("jdbcDriver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class.forName Exception " + e);
        }
    }

    private void DBCPInit(Properties prop) {
        String jdbcUrl = prop.getProperty("jdbcUrl");
        String dbUser = prop.getProperty("dbUser");
        String dbPassword = prop.getProperty("dbPassword");

        try {
            ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(jdbcUrl, dbUser, dbPassword);
            PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
            poolableConnectionFactory.setValidationQuery("select 1");

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTestWhileIdle(true);
            poolConfig.setMaxIdle(40);
            poolConfig.setMinIdle(4);
            poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);

            GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
            poolableConnectionFactory.setPool(connectionPool);

            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver poolingDriver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            String poolName = prop.getProperty("poolName");
            poolingDriver.registerPool(poolName, connectionPool);
        } catch (Exception e) {
            throw new RuntimeException("DBCPInit throw exception " + e);
        }
    }
}
