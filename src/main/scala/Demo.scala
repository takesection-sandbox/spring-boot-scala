
package com.example {

  import org.springframework.beans.factory.annotation.Autowired
  import org.springframework.boot.SpringApplication
  import org.springframework.boot.autoconfigure.SpringBootApplication
  import org.springframework.context.annotation.Bean
  import org.springframework.stereotype.{Component, Repository}

  @SpringBootApplication
  class DemoApplication {

    def main(args: Array[String]): Unit = {
      var clz: Array[Object] = Array(classOf[DemoApplication])
      SpringApplication.run(clz, args)
    }
  }

  case class Demo(id: String, name: String)

  trait DemoRepository {
    def find(): Demo
  }

  @Repository
  class DemoRepositoryImpl extends DemoRepository {
    override def find(): Demo = Demo("id", "name")
  }

  @Component
  class DemoProcess {

    @Autowired
    var demoRepository: DemoRepository = null

    def process: Demo = demoRepository.find

  }

}