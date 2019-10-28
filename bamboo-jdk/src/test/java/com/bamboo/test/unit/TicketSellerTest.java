package com.bamboo.test.unit;

import org.junit.jupiter.api.*;

/**
 * @Description
 * 售票类单元测试
 * @Author victor su
 * @Date 2019/10/28 18:43
 **/
@DisplayName("售票器类型测试")
public class TicketSellerTest {
    private TicketSeller ticketSeller;

    @BeforeAll
    public static void init () {
        System.out.println("================== init =================");
        Assertions.assertEquals(1, 1);
    }

    @AfterAll
    public static void cleanup () {
        Assertions.assertEquals("a", "a");
        System.out.println("================== cleanup =================");

    }

    @BeforeEach
    public void create () {
        System.out.println("================== create =================");

        this.ticketSeller = new TicketSeller();
    }

    @AfterEach
    public void destroy () {
        System.out.println("================== destroy =================");
    }

    @Test
    @DisplayName("售票后余票应减少")
    public void shouldReduceInventoryWhenTicketSoldOut () {

        ticketSeller.setInventory(10);
        ticketSeller.sell(1);
        Assertions.assertEquals(9, ticketSeller.getInventory());
    }

    @Test
    @DisplayName("校验邮箱地址")
    /**
     * 正则匹配网址
     * http://www.regexpal.com/
     * http://rubular.com/
     * 正则表达式全集
     * http://tool.oschina.net/uploads/apidocs/jquery/regexp.html
     *
     * ^	匹配输入字符串的开始位置。如果设置了RegExp对象的Multiline属性，^也匹配“\n”或“\r”之后的位置。
     * $	匹配输入字符串的结束位置。如果设置了RegExp对象的Multiline属性，$也匹配“\n”或“\r”之前的位置。
     * *	匹配前面的子表达式零次或多次。例如，zo*能匹配“z”以及“zoo”。*等价于{0,}。
     * +	匹配前面的子表达式一次或多次。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。
     * ?	匹配前面的子表达式零次或一次。例如，“do(es)?”可以匹配“does”或“does”中的“do”。?等价于{0,1}。
     * \d	匹配一个数字字符。等价于[0-9]。
     * \D	匹配一个非数字字符。等价于[^0-9]。
     * x|y	匹配x或y。例如，“z|food”能匹配“z”或“food”。“(z|f)ood”则匹配“zood”或“food”。
     * [xyz]	字符集合。匹配所包含的任意一个字符。例如，“[abc]”可以匹配“plain”中的“a”。
     * [^xyz]	负值字符集合。匹配未包含的任意字符。例如，“[^abc]”可以匹配“plain”中的“p”。
     * [a-z]	字符范围。匹配指定范围内的任意字符。例如，“[a-z]”可以匹配“a”到“z”范围内的任意小写字母字符。
     * [^a-z]	负值字符范围。匹配任何不在指定范围内的任意字符。例如，“[^a-z]”可以匹配任何不在“a”到“z”范围内的任意字符。
     */
    public void validateEmailAddress () {
        String email = "smile.s-z_xs4mile.s-z_xsm4ile.s-z_x@out.lo-o9k.co9m";
        Assertions.assertEquals(true, email.matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,5}$"));
    }
}
