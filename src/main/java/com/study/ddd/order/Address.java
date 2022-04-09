package com.study.ddd.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Address {
    private String address1;
    private String address2;
    private String zipcode;
}
