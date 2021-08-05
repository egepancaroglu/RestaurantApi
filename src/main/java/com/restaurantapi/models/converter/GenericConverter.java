package com.restaurantapi.models.converter;

public interface GenericConverter<S, T> {
    T convert(S source);
}
