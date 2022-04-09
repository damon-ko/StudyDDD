package com.study.ddd.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}
