package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextMyTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    AnnotationConfigApplicationContext ac1 =new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 정의로 모두 조회")
    void findBeansByDef(){
        String[] beanDefinitionNames = ac1.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac1.getBeanDefinition(beanDefinitionName);


            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("Name :"+beanDefinitionName+"        beanDefinition :"+ beanDefinition);
            }
        }
    }

    @Test
    @DisplayName(" 빈 조회")
    void findBeans() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s);     
        }
       
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy RateDiscount(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscount(){
            return new FixDiscountPolicy();
        }
    }
}
