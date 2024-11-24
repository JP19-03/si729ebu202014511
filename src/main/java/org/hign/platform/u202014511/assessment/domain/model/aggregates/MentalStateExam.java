package org.hign.platform.u202014511.assessment.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hign.platform.u202014511.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202014511.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202014511.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Getter
    @NotNull
    private Long patientId;

    @Embedded
    @NotNull
    private ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;

    @Getter
    @NotNull
    private Date examDate;

    @Getter
    @NotNull
    @Min(0)
    @Max(10)
    private Integer orientationScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(3)
    private Integer registrationScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(5)
    private Integer attentionAndCalculationScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(3)
    private Integer recallScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(9)
    private Integer languageScore;

    protected MentalStateExam() {}

    public MentalStateExam(CreateMentalStateExamCommand command, Date examDate) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = new ExaminerNationalProviderIdentifier(command.examinerNationalProviderIdentifier());
        this.examDate = examDate;
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
    }

    public String getExaminerNationalProviderIdentifier() {
        return examinerNationalProviderIdentifier.examinerNationalProviderIdentifier();
    }
}
