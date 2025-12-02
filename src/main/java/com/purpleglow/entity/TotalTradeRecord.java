package com.purpleglow.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
@Data
@TableName("total_trade_record")
public class TotalTradeRecord {

        @TableId("id")
        private Long id;

        @TableField("strategy_id")
        private String strategyId;

        @TableField("deal_id")
        private String dealId;

        private String code;

        private String volume;

        private String amount;

        @TableField("time_key")
        private String timeKey;

        private Timestamp ctime;

        private Timestamp utime;

        private Integer valid;
}

