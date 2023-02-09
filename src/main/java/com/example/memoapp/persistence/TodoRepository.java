package com.example.memoapp.persistence;

import com.example.memoapp.model.TodoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

    @Query("SELECT t FROM TodoEntity t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);
}
