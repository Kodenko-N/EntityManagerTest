import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Создание нового пользователя
        User user = new User();
        user.setName("John Doe");
        userDAO.create(user);

        // Чтение пользователя по ID
        User retrievedUser = userDAO.read(1L);
        System.out.println("Retrieved User: " + retrievedUser.getName());

        // Обновление пользователя
        retrievedUser.setName("Jane Doe");
        userDAO.update(retrievedUser);

        // Удаление пользователя
        userDAO.delete(1L);

        // Закрытие EntityManagerFactory
        HibernateUtil.shutdown();
    }
}