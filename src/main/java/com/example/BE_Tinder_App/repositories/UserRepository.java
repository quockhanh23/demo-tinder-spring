package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    @Query("SELECT new com.example.BE_Tinder_App.dto.UserInfo" +
            "(u.id, u.username, u.dateOfBird, u.avatar, u.coverImage, u.createdAt, u.updatedAt, u.status, u.gender) " +
            "FROM User u WHERE u.id IN :listId")
    Page<UserInfo> findAllByIdIn(Pageable pageable, Set<Long> listId);

    @Query(value = "SELECT new com.example.BE_Tinder_App.dto.UserInfo" +
            "(u.id, u.username, u.dateOfBird, u.avatar, u.coverImage, u.createdAt, u.updatedAt, u.status, u.gender) " +
            "FROM User u WHERE u.username like CONCAT('%', :searchText, '%') ")
    Page<UserInfo> getAllUserPage(Pageable pageable, @Param("searchText") String searchText);

    @Query(value = """
                SELECT new com.example.BE_Tinder_App.dto.UserInfo(
                    u.id, u.username, u.dateOfBird, u.avatar, u.coverImage,
                    u.createdAt, u.updatedAt, u.status, u.gender)
                FROM User u
                WHERE u.id != :idUser and
                 NOT EXISTS (
                    SELECT b FROM Block b WHERE b.idUserAction = :idUser
                )
                AND NOT EXISTS (
                    SELECT l FROM LikeUser l WHERE l.idUserAction = :idUser
                )
                AND NOT EXISTS (
                    SELECT d FROM DislikeUser d WHERE d.idUserAction = :idUser
                )
                AND NOT EXISTS (
                    SELECT m FROM Matches m WHERE m.idUser1 = :idUser
                )
            """)
    Page<UserInfo> getAllUserByCondition(Pageable pageable, @Param("idUser") Long idUser);

    @Query(value = """
                SELECT distinct new com.example.BE_Tinder_App.dto.UserInfo(
                    u.id, u.username, u.dateOfBird, u.avatar, u.coverImage,
                    u.createdAt, u.updatedAt, u.status, u.gender)
                FROM User u
                WHERE u.id != :idUser and
                  EXISTS (
                   SELECT m FROM Matches m WHERE m.idUser1 = :idUser
                )
                 and EXISTS (
                   SELECT m FROM Matches m WHERE m.idUser2 = :idUser
                )
            """)
    Page<UserInfo> getAllMatchPage(Pageable pageable, @Param("idUser") Long idUser);


}