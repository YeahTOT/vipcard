package com.example.vipcard.repository;

import com.example.vipcard.model.CardRecord;
import com.example.vipcard.model.StoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface CardRecordRepository extends JpaRepository<CardRecord,Integer> {

    // 根据userCardId查询操作记录
    @Query("select record from CardRecord record where record.userCardId = :userCardId")
    Collection<CardRecord> findCardRecordsByUserCardId(@Param("userCardId") int userCardId);

    // 根据时间段查询操作记录
    @Query("select record from CardRecord record where record.userCardId = :userCardId and record.recordTime > :recordTime1 and record.recordTime < :recordTime2")
    Collection<CardRecord> findCardRecordsByUserCardIdAndData(@Param("userCardId") int userCardId, String recordTime1, String recordTime2);
}
