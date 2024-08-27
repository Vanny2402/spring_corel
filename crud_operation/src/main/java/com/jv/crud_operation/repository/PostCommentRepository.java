package com.jv.crud_operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jv.crud_operation.model.entity.PostCommentEntity;

@Repository
public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Long>{
	List<PostCommentEntity> findAllByPostId(Long postId);
	
}
