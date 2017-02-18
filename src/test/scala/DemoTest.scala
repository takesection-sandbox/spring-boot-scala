package com.example {

  import org.hamcrest.CoreMatchers._
  import org.junit.Assert._
  import org.junit.{Before, Test}
  import org.junit.runner.RunWith
  import org.springframework.beans.factory.annotation.Autowired
  import org.springframework.boot.test.context.SpringBootTest
  import org.springframework.boot.test.mock.mockito.MockBean
  import org.springframework.test.context.junit4.SpringRunner
  import org.mockito.Mockito._

  @RunWith(classOf[SpringRunner])
  @SpringBootTest
  class DemoTest {

    @Autowired
    var demoProcess: DemoProcess = null

    @Test
    def demoTest: Unit = {
      val value: Demo = demoProcess.process

      assertThat(value, is(not(nullValue())))
      assertThat(value.id, is("id"))
      assertThat(value.name, is("name"))
    }
  }

  @RunWith(classOf[SpringRunner])
  @SpringBootTest
  class MockTest {

    @MockBean
    var demoRepository: DemoRepository = null

    @Autowired
    var demoProcess: DemoProcess = null

    @Before
    def setUp: Unit = {
      when(demoRepository.find()).thenReturn(Demo("foo", "bar"))
    }

    @Test
    def demoTest: Unit = {
      val value: Demo = demoProcess.process

      assertThat(value, is(not(nullValue())))
      assertThat(value.id, is("foo"))
      assertThat(value.name, is("bar"))
    }

  }
}