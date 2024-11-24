package org.hign.platform.u202014511.assessment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202014511.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202014511.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202014511.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202014511.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.u202014511.assessment.interfaces.rest.transform.MentalStateExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/mental-state-exams", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Endpoints for managing mental state exams")
public class MentalStateExamsController {
    private final MentalStateExamCommandService mentalStateExamCommandService;

    public MentalStateExamsController(MentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a mental state exam", description = "Create a mental state exam with the given data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mental state exam created"),
            @ApiResponse(responseCode = "400", description = "Invalid data")
    })
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        var command = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var mentalStateExam = mentalStateExamCommandService.handle(command);
        if (mentalStateExam.isEmpty()) return ResponseEntity.badRequest().build();
        var createdMentalStateExam = mentalStateExam.get();
        var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(createdMentalStateExam);
        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);
    }
}
