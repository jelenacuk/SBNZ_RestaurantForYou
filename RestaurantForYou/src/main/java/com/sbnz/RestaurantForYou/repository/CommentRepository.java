package com.sbnz.RestaurantForYou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
