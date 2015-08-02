/**
 * Created by vdudi on 7/20/15.
 */
import java.sql.DriverManager
import java.sql.Connection

object JdbcConnectSelect {

  def main(args: Array[String]): Unit ={

    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/drupal"
    val username = "root"
    val password = ""

    var connection:Connection = null
    try{
      Class.forName(driver)
      connection = DriverManager.getConnection(url,username, password)

      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("select name, mail from users")

      while(resultSet.next()) {
        val host = resultSet.getString("name")
        val user = resultSet.getString("mail")

        println("host, user =" + host + "," + user)

      }


    } catch {
      case e => e.printStackTrace()
    }
    finally {
      connection.close()
    }

  }

}
