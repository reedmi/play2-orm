import sbt._
import Keys._
import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys
import play.Project._
import com.typesafe.config._

object ApplicationBuild extends Build {

    val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

    val appName = conf.getString("application.name")
    val appVersion = conf.getString("application.version")

    val appDependencies = Seq(
        // Add your project dependencies here,
        javaCore,
        javaJdbc,
        cache,
        javaJpa,

        "org.springframework" % "spring-expression" % "3.2.3.RELEASE",
        "org.apache.shiro" % "shiro-spring" % "1.2.3",

        "mysql" % "mysql-connector-java" % "5.1.19",
        "org.hibernate" % "hibernate-entitymanager" % "4.2.5.Final",
        "com.googlecode.genericdao" % "dao" % "1.2.0",
        "com.googlecode.genericdao" % "search-jpa-hibernate" % "1.2.0")

    val main = play.Project(appName, appVersion, appDependencies).settings(
        // Add your own project settings here
        ebeanEnabled := false,

        resolvers := Seq(
            "Local Play Repository" at "file://" + System.getenv("PLAY_HOME") + "/local",
            "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
            "Sedis Repo" at "http://pk11-scratch.googlecode.com/svn/trunk/"),

        // Hard code the path of the configuration file for test. See http://play.lighthouseapp.com/projects/82401/tickets/981-overriding-configuration-for-tests for details.
        javaOptions in Test += "-Dconfig.file=conf/application-test.conf")

}
