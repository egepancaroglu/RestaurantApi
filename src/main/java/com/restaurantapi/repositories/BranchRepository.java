package com.restaurantapi.repositories;

import com.restaurantapi.models.entity.Branch;
import com.restaurantapi.models.enumerated.Role;
import com.restaurantapi.models.enumerated.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends BaseRepository<Branch> {
    List<Branch> findAllByStatus(Status status);

    List<Branch> findAllByRoles(Role roles);


}