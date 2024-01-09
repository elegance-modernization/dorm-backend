package com.chennann.dorm.mapper;

import com.chennann.dorm.pojo.WaterBill;
import com.chennann.dorm.pojo.WaterOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WaterMapper {

    void order(WaterOrder waterOrder);

    @Update("update waterOrder set waterOrderStatus=#{waterOrderStatus} where waterOrderId=#{waterOrderId}")
    void changeState(WaterOrder waterOrder);

    @Select("select * from waterOrder where waterOrderId=#{waterOrderId} and waterOrderNumber=#{waterOrderNumber}")
    WaterOrder findOrderByIdAndNumber(Integer waterOrderId, String waterOrderNumber);

    List<WaterOrder> listWaterOrder(Integer waterStationId, Integer state);

    @Delete("delete from waterOrder where waterOrderId=#{waterOrderId} and waterOrderNumber=#{waterOrderNumber}")
    void cancel(WaterOrder waterOrder);

    @Select("select dormNumber, waterStationId, sum(waterCount) as waterCount, sum(waterCount) * (select waterPrice from waterStation where waterStation.waterStationId = waterOrder.waterStationId) as totalPrice from waterOrder where waterOrderStatus='已完成' group by dormNumber, waterStationId")
    List<WaterBill> monthlyBillGenerator();

    void insertBills(List<WaterBill> waterBillList);
}
