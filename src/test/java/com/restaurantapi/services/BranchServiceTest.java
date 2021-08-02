package com.restaurantapi.services;

import com.restaurantapi.models.Branch;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.BranchRepository;
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
public class BranchServiceTest {

    private static final Status STATUS = Status.WAITING;
    private static final Status STATUSNEW = Status.APPROVED;

    @InjectMocks
    private BranchService branchService;

    @Mock
    private BranchRepository branchRepository;


    @Test
    public void ReturnAllBranch() {
        Branch branch1 = Branch.builder().id(1L).build();
        Branch branch2 = Branch.builder().id(2L).build();
        List<Branch> branchList = Arrays.asList(branch1, branch2);

        Mockito.when(branchRepository.findAll()).thenReturn(branchList);

        List<Branch> fetchedList = branchService.getAll();

        assertEquals(branchList.size(), fetchedList.size());
    }

    @Test
    public void ReturnBranch() {
        Branch branch = Branch.builder().id(1L).name("Burger King").build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(branch);

        Branch fetchedBranch = branchService.getById(1L);

        assertEquals(branch.getId(), fetchedBranch.getId());
    }

    @Test
    public void ReturnSavedBranch() {
        Branch branch = Branch.builder().build();

        Mockito.doReturn(branch).when(branchRepository).save(branch);

        Branch returnedBranch = branchService.create(branch);


    }

    @Test
    public void ReturnUpdatedBranch() {
        Branch existBranch = Branch.builder().id(1L).status(STATUS).build();
        Branch newBranch = Branch.builder().id(1L).status(STATUSNEW).build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(existBranch);
        Mockito.when(branchRepository.save(newBranch)).thenReturn(newBranch);

        Branch updatedBranch = branchService.update(newBranch);
        Assertions.assertNotEquals(existBranch.getStatus(), STATUS);
        Assertions.assertEquals(existBranch.getStatus(), STATUSNEW);

    }
}
