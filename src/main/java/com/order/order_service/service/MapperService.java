package com.order.order_service.service;

import java.util.Collection;
import java.util.List;

public interface MapperService {
    <E, U> E map(final U data, Class<E> className);

    <E, U> List<E> map(final Collection<U> dataList, Class<E> className);
}
