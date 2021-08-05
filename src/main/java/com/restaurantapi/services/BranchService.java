package com.restaurantapi.services;

import com.restaurantapi.models.entity.Branch;
import com.restaurantapi.models.enumerated.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchService {


    Branch create(Branch branch);

    List<Branch> getAll();

    Branch getById(Long id);

    Branch update(Branch branch);

    Branch deleteById(Long id);

    Branch findById(Long id);

    List<Branch> findAll();

    String delete(Long id);

    List<Branch> getByStatus(Status status);

    List<Branch> getWaitingBranchList(Status status);



}
