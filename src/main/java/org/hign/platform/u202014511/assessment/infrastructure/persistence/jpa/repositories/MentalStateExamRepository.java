package org.hign.platform.u202014511.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202014511.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {

}
