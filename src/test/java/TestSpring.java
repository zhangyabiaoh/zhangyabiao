import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestSpring {
	/*@Autowired
	FactoryDao factoryDao;*/
	/*@Autowired
	FactoryDao factory;
	*/
	
	@Test
	public void testService() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		/*Factory f = factoryDao.get("1");
		
		System.out.println(f.getFullName());*/
	}
}
