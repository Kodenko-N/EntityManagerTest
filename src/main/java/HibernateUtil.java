
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;



    public class HibernateUtil {

        private static EntityManagerFactory entityManagerFactory;

        static {
            try {
                // Настройки подключения к базе данных
                Map<String, String> properties = new HashMap<>();
                properties.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
                properties.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/kn_db");
                properties.put("jakarta.persistence.jdbc.user", "root");
                properties.put("jakarta.persistence.jdbc.password", "RootPassword1");
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
                properties.put("hibernate.hbm2ddl.auto", "create"); // или "create", "validate", "none"
                properties.put("hibernate.show_sql", "true"); // Показывать SQL-запросы в логах
                properties.put("hibernate.format_sql", "true"); // Форматировать SQL-запросы
                properties.put("hibernate.use_sql_comments", "true"); // Добавлять комментарии к SQL-запросам

                // Создаем EntityManagerFactory программно
                entityManagerFactory = new HibernatePersistenceProvider()
                        .createEntityManagerFactory("user", properties);
                System.out.println("EntityManagerFactory is " + entityManagerFactory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}