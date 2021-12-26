package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SiEx {

    @Test
    @DisplayName("싱글톤을 활용한 객체 생성")
    void notSingleton(){
        Menu menu1 = Menu.getInstance();
        Menu menu2 = Menu.getInstance();

        String menu1_name = menu1.setName("자장면");
        String menu2_name = menu2.setName("볶음밥");

        System.out.println("menu1 = " + menu1_name);
        System.out.println("menu2 = " + menu2_name);

        Assertions.assertThat(menu1).isEqualTo(menu2);
    }
}
