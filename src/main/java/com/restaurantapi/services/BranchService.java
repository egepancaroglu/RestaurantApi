package com.restaurantapi.services;

import com.restaurantapi.models.Branch;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private BranchRepository branchRepository;

    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    public Branch getById(Long id) {
        return branchRepository.getById(id);
    }

    public List<Branch> getByStatus(Status status) {
        return branchRepository.findAllByStatus(status);
    }

    public Branch update(Branch branch) {
        Branch foundBranch = branchRepository.getById(branch.getId());
        if (branch.getStatus() != null) {
            foundBranch.setStatus(branch.getStatus());
        }
        if (branch.getName() != null) {
            foundBranch.setName(branch.getName());
        }
        if (branch.getRole() != null) {
            foundBranch.setRole(branch.getRole());
        }
        return branchRepository.save(branch);
    }

    public Branch deleteById(Long id) {
        Branch branch = branchRepository.getById(id);
        if (branch != null) {
            branchRepository.deleteById(id);
            return branch;
        }
        return branch;
    }

    public List<Branch> getWaitingBranchList() {

        return branchRepository.findAllByStatus(Status.WAITING);
    }

    public String delete(long id) {

        branchRepository.deleteById(id);
        return "SUCCESS";
    }


}
