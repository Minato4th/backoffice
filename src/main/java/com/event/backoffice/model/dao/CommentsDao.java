package com.event.backoffice.model.dao;

import com.event.backoffice.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsDao extends JpaRepository<Comments, Long> {
}
