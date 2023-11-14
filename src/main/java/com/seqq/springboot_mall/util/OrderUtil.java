package com.seqq.springboot_mall.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    public static String generateProductOrderCode() {
        // 获取当前的日期和时间
        LocalDateTime now = LocalDateTime.now();

        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        // 格式化当前时间
        String productOrderCode = now.format(formatter);

        return productOrderCode;
    }

    public static List<LocalDate> getDateRange(String startDateString, String endDateString, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter);

        List<LocalDate> dateList = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            dateList.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return dateList;
    }

    public static String[] convertDateListToStringArray(List<LocalDate> dateList, String dateFormat) {
        String[] dateStringArray = new String[dateList.size()];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        for (int i = 0; i < dateList.size(); i++) {
            dateStringArray[i] = dateList.get(i).format(formatter);
        }

        return dateStringArray;
    }
}
