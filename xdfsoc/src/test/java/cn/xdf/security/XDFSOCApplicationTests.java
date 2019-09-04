package cn.xdf.security;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cn.xdf.security.bean.Employee;
import cn.xdf.security.bean.GoodsBill;
import cn.xdf.security.bean.Region;
import cn.xdf.security.bean.User;
import cn.xdf.security.bean.VulType;
import cn.xdf.security.bean.WorkOrder;
import cn.xdf.security.controller.VulTypeController;
import cn.xdf.security.dao.IEmployeeDao;
import cn.xdf.security.dao.IGoodsBillDao;
import cn.xdf.security.dao.IRegionDao;
import cn.xdf.security.dao.IRouteInfoDao;
import cn.xdf.security.dao.IUserDao;
import cn.xdf.security.dao.IVulTypeDao;
import cn.xdf.security.dao.IWorkOrderDao;
import cn.xdf.security.service.IRouteService;
import cn.xdf.security.service.IWorkOrderService;
import cn.xdf.security.util.Enctype;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class XDFSOCApplicationTests {
	
//	@Autowired
//	private IUserDao userDao;
//	@Autowired
//	private IEmployeeDao employeeDao;
//	
//	@Autowired
//	private IRouteService routeService;
//	
//	@Autowired
//	private IRegionDao regionDao;
//	
//	@Autowired
//	private IRouteInfoDao routeInfoDao;
//	
//	@Autowired
//	private IGoodsBillDao goodsBillDao;
	
	@Autowired
	private IVulTypeDao vultypeDao;

//	private IWorkOrderService workOrderService;
//	@Autowired
//	private IWorkOrderDao workOrderDao;
	
//	@Before
//    public void setUp() throws Exception{
//        //MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
//       // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
//    }

	@Test
	public void test() {
		//List<VulType> list = vultypeDao.findALLVulTypes();
		
//		for(VulType vt:list){
//			System.out.println(vt);
//		}
		VulType vultype = vultypeDao.findById("1");
		System.out.println(vultype);
	}
	
	
//	@Test
//	public void testWorkOrder() {
//		WorkOrder wo = new WorkOrder();
//		wo.setDepartment("网络运营部");
//		wo.setBizLine("iTeach");
//		wo.setProName("iTeach");
//		wo.setProManager("张三");
//		wo.setAppName("iTeach自主转班系统");
//		wo.setLink("http://test.iteach.xdf.cn");
//		wo.setAppDesc("该系统用于学生自主转班，wiki链接：xxxxxxx");
//		wo.setFramework("ThinkPHP5.0");
//		wo.setDb("Mysql");
//		wo.setMiddleware("中");
//		wo.setExpectedTime("2019-09-10");
//	//	workOrderService.save(wo);
//		workOrderDao.save(wo);
//	}

	@Test
	public void test4() {
		VulType vul = new VulType();
		vul.setId(13);
		vul.setVulName("Jtest");
		vul.setVulDesc("Jtest");
		vul.setVulRes("Jtest111");
		vultypeDao.updateVulType(vul.getVulName(),vul.getVulDesc(),vul.getVulRes(),vul.getId());
		//vulController.
	}

}
