package com.example.demo.sample.filter;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaGoodsFilterCondition extends GoodsFilterCondition {

    private String date;
    private boolean instantBooking;
    private List<Long> categories = new ArrayList<>();


}
