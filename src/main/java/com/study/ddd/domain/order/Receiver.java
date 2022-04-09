package com.study.ddd.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Receiver {
    private String name;
    private String phone;
}
