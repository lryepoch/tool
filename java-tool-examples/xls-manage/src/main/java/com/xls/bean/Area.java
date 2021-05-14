package com.xls.bean;

import lombok.Data;

/**
 * @author lryepoch
 * @date 2019-11-30 2019/11/30
 * @description
 */
@Data
public class Area {
    private Integer areaNum;
    private String province;
    private String city;
    private String district;
    private Integer postcode;
}