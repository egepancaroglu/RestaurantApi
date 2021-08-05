package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.BranchDTO;
import com.restaurantapi.models.dto.CommentsDTO;
import com.restaurantapi.models.dto.UsersDTO;
import com.restaurantapi.models.entity.Branch;
import com.restaurantapi.models.entity.Comments;
import com.restaurantapi.models.entity.Users;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CommentsDtoConverter implements GenericConverter<Comments, CommentsDTO> {

    private final GenericConverter<Branch, BranchDTO> branchDtoConverter;
    private final GenericConverter<Users, UsersDTO> usersDtoConverter;

    @Override
    public CommentsDTO convert(final Comments comments) {
        if (comments == null) {
            return null;
        }

        CommentsDTO comments1 = new CommentsDTO();

        comments1.setId(comments1.getId());
        comments1.setBranch(convert(comments1.getBranch()));
        comments1.setUsers(convert(comments1.getUsers()));
        comments1.setComment(comments1.getComment());
        comments1.setTaste_point(comments1.getTaste_point());
        comments1.setSpeed_point(comments1.getSpeed_point());


        return comments1;

    }


    private BranchDTO convert(final Branch branch) {
        return branchDtoConverter.convert(branch);
    }

    private UsersDTO convert(final Users users) {
        return usersDtoConverter.convert(users);
    }


}




