package com.restaurantapi.services;

import com.restaurantapi.models.Address;
import com.restaurantapi.repositories.AddressRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    private static final String DISTRICT_MODA = "Moda";
    private static final String DISTRICT_CAFERAGA = "Caferaga";
    private static final String OTHER_CONTENT_EV = "Ev";
    private static final String OTHER_CONTENT_KAMPUS = "Kampus";


    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;


    @Test
    public void ReturnAllAddress() {
        Address address1 = Address.builder().id(1L).build();
        Address address2 = Address.builder().id(2L).build();
        List<Address> addressList = Arrays.asList(address1, address2);

        Mockito.when(addressRepository.findAll()).thenReturn(addressList);

        List<Address> fetchedList = addressService.getAll();

        assertEquals(addressList.size(), fetchedList.size());
    }

    @Test
    public void ReturnAddress() {
        Address address = Address.builder().id(1L).district("Merkez Mahallesi").build();

        Mockito.when(addressRepository.getById(1L)).thenReturn(address);

        Address fetchedAddress = addressService.getById(1L);

        assertEquals(address.getId(), fetchedAddress.getId());
    }

    @Test
    public void ReturnSavedAddress() {
        Address address = Address.builder().build();

        Mockito.doReturn(address).when(addressRepository).save(address);

        Address returnedAddress = addressService.create(address);


    }

    @Test
    public void ReturnUpdatedAddress() {
        Address existAddress = Address.builder().id(1L).district(DISTRICT_MODA).build();
        Address newAddress = Address.builder().id(1L).district(DISTRICT_CAFERAGA).build();

        Mockito.when(addressRepository.getById(1L)).thenReturn(existAddress);
        Mockito.when(addressRepository.save(newAddress)).thenReturn(newAddress);

        Address updatedAddress = addressService.update(newAddress);
        Assertions.assertNotEquals(existAddress.getDistrict(), DISTRICT_MODA);
        Assertions.assertEquals(existAddress.getDistrict(), DISTRICT_CAFERAGA);

    }
}