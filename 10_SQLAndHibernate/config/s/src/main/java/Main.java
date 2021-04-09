import java.sql.*;

    public class Main {
        private static final String SQL_QUERY = "SELECT courses.name as course_name, " +
                "COUNT(MONTH(subscription_date)) / COUNT(DISTINCT MONTH(subscription_date)) " +
                "AS count_per_month " +
                "FROM subscriptions, courses " +
                "WHERE courses.id = subscriptions.course_id " +
                "GROUP BY course_name;";

        public static void main(String[] args) throws SQLException {
            String url = "jdbc:mysql://localhost/skillbox?useUnicode=true&serverTimezone=UTC";
            String user = "root";
            String pass = "Otakua0102!";

            Connection connection = DriverManager.getConnection(url, user, pass);
            try {
                if (connection != null) {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(SQL_QUERY);
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("course_name") + "\t" +
                                resultSet.getString("count_per_month"));
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (connection != null)

                    connection.close();
            }
        }
    }


