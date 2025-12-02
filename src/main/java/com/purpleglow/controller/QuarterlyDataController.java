package com.purpleglow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
public class QuarterlyDataController {

    @GetMapping("/quarterly-table")
    public String showQuarterlyTable(Model model) {
        // 1. 创建模拟数据 (实际应用中应从数据库获取)
        Map<String, Double> dataMap = generateSampleData();

        // 2. 生成100个季度ID (格式: YYYY-QX)
        List<String> allQuarters = generateQuarterIds();

        // 3. 将数据转换为10x10矩阵
        List<List<String>> quarterRows = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int startIdx = i * 10;
            int endIdx = Math.min(startIdx + 10, allQuarters.size());
            quarterRows.add(allQuarters.subList(startIdx, endIdx));
        }

        // 4. 添加属性到模型
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("quarterRows", quarterRows);

        return "quarterlyTable";
    }

    private Map<String, Double> generateSampleData() {
        Map<String, Double> dataMap = new LinkedHashMap<>();
        int year = 2000;
        int quarter = 1;

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String key = String.format("%d-Q%d", year, quarter);
            double value = 50 + random.nextDouble() * 150; // 50-200之间的随机数
            dataMap.put(key, Math.round(value * 10) / 10.0); // 保留一位小数

            // 增加季度计数
            quarter++;
            if (quarter > 4) {
                quarter = 1;
                year++;
            }
        }
        return dataMap;
    }

    private List<String> generateQuarterIds() {
        List<String> quarters = new ArrayList<>();
        int year = 2000;
        int quarter = 1;

        for (int i = 0; i < 100; i++) {
            quarters.add(String.format("%d-Q%d", year, quarter));

            quarter++;
            if (quarter > 4) {
                quarter = 1;
                year++;
            }
        }
        return quarters;
    }
}