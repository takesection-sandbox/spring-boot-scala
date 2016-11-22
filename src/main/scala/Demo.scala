
package com.example {

  import org.springframework.beans.factory.annotation.Autowired
  import org.springframework.boot.SpringApplication
  import org.springframework.boot.autoconfigure.SpringBootApplication
  import org.springframework.context.annotation.Bean

  @SpringBootApplication
  class DemoApplication {

    def main(args: Array[String]): Unit = {
      var clz: Array[Object] = Array(classOf[DemoApplication])
      SpringApplication.run(clz, args)
    }

    @Bean
    def demoProcess: DemoProcess = new DemoProcess

    @Bean
    def demoDao: DemoDao = new DemoDaoImpl
  }

  case class Demo(id: String, name: String)

  trait DemoDao {
    def find(): Demo
  }

  class DemoDaoImpl extends DemoDao {
    override def find(): Demo = Demo("id", "name")
  }

  class DemoProcess {

    @Autowired
    var demoDao: DemoDao = null

    def process: Demo = demoDao.find

  }

}