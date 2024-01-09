package com.chennann.dorm;

import com.chennann.dorm.pojo.WaterBill;
import com.chennann.dorm.service.WaterService;
import com.chennann.dorm.util.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DormApplicationTests {

    @Autowired
    private WaterService waterService;

    @Test
    void contextLoads() {
    }

    @Test
    void testBill () throws NoSuchAlgorithmException {
        List<WaterBill> waterBillList = new ArrayList<>();
        waterBillList = waterService.monthlyBillGenerator();



        for (WaterBill waterBill : waterBillList) {
            waterBill.setWaterBillNumber(NumberUtil.generateShortOrderNumber());
            waterBill.setWaterBillStatus("未缴费");
//            System.out.println(waterBill);
        }

        waterService.insertBills(waterBillList);
    }

}
