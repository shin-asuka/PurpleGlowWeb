package com.purpleglow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.purpleglow.entity.TotalTradeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TotalTradeRecordMapper extends BaseMapper<TotalTradeRecord> {

    // 查询所有有效记录
    @Select("SELECT * FROM total_trade_record WHERE valid = 1")
    List<TotalTradeRecord> selectAllValid();

    // 根据策略ID查询记录
    @Select("SELECT * FROM total_trade_record WHERE strategy_id = #{strategyId} AND valid = 1")
    List<TotalTradeRecord> selectByStrategyId(@Param("strategyId") String strategyId);

    // 根据时间范围查询记录
    @Select("SELECT * FROM total_trade_record WHERE time_key BETWEEN #{startTime} AND #{endTime} AND valid = 1")
    List<TotalTradeRecord> selectByTimeRange(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime);

    // 根据代码查询记录
    @Select("SELECT * FROM total_trade_record WHERE code = #{code} AND valid = 1")
    List<TotalTradeRecord> selectByCode(@Param("code") String code);
}
