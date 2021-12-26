package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.AutoConfig;
import hello.core.AutoWiredTest.AllBeanTest;
import hello.core.CoreApplication;
import hello.core.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AutoConfig.class, AllBeanTest.DiscountService.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName +" object = " +bean);
        }
    }@Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName +" object = " +bean);
            }
        }
    }

    @Test
    @DisplayName("Primary 테스트")
    void Primary(){
        AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AutoConfig.class);

        Object orderService = ac.getBean("rateDiscountPolicy");

    }
}
