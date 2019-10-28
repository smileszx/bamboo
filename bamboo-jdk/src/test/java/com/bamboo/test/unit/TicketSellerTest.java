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
        Assertions.assertEquals(ticketSeller.getInventory(), 9);
    }
}
