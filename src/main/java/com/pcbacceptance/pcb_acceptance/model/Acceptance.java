package com.pcbacceptance.pcb_acceptance.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get set method등 만들어줌 structure 확인
@AllArgsConstructor //매개변수를 가진 생성자 만들어줌
@NoArgsConstructor //기본생성자 만들어줌
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Acceptance {

    @Size(min = 1, max = 2)
    @NotEmpty
    String productType;

}