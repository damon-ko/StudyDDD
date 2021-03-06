package com.study.ddd.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}
