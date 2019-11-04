package cloud;

import com.luban.moudle.controller.ApplicationController;
import com.luban.moudle.instance.InstanceConfig;
import com.luban.moudle.register.Register;
import com.luban.moudle.servlet.LuBanDispatcherServlet;
import com.luban.moudle.servlet.ResourceInstance;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Arrays;

@Configuration
@EnableConfigurationProperties(RegisterConfigProperties.class)
public class AppConfig {


    public AppConfig(){
        System.out.println("----------------");
    }


    @Bean
    public ApplicationController applicationController(Register register,InstanceConfig instanceConfig){
        ApplicationController applicationController = new ApplicationController(register,instanceConfig);
        return  applicationController;
    }

    @Bean
    public InstanceConfig instanceConfig(){
        return  new InstanceConfigImpl();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ResourceInstance resourceInstance){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        LuBanDispatcherServlet luBanDispatcherServlet = new LuBanDispatcherServlet(resourceInstance);
        servletServletRegistrationBean.setServlet(luBanDispatcherServlet);
        servletServletRegistrationBean.setLoadOnStartup(1);
        servletServletRegistrationBean.setUrlMappings(Arrays.asList("*.do"));
//      servletServletRegistrationBean.setUrlMappings();

        return servletServletRegistrationBean;
    }

    @Bean
    public ResourceInstance resourceInstance(ApplicationController applicationController){
        ResourceInstance resourceInstance = new ResourceInstanceImpl();
        resourceInstance.getResourceInstances().put(ApplicationController.class,applicationController);
        return resourceInstance;

    }



    @Bean
    public Register register(){
        EventInstanceRegister register = new EventInstanceRegister();
        return  register;
    }









}
