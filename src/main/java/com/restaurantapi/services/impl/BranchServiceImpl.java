package com.restaurantapi.services.impl;

import com.restaurantapi.models.Branch;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.BranchRepository;
import com.restaurantapi.services.BranchService;

import java.util.List;

public class BranchServiceImpl implements BranchService {


    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch findById(Long id) {
        return branchRepository.getById(id);
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getById(Long id) {
        return branchRepository.getById(id);
    }

    @Override
    public List<Branch> getByStatus(Status status) {
        return branchRepository.findAllByStatus(status);
    }

    @Override
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

    @Override
    public Branch deleteById(Long id) {
        Branch branch = branchRepository.getById(id);
        if (branch != null) {
            branchRepository.deleteById(id);
            return branch;
        }
        return branch;
    }

    @Override
    public List<Branch> getWaitingBranchList(Status status) {

        return branchRepository.findAllByStatus(Status.WAITING);
    }

    @Override
    public String delete(Long id) {

        branchRepository.deleteById(id);
        return "SUCCESS";
    }

}
