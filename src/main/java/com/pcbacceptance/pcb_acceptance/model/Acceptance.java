package com.pcbacceptance.pcb_acceptance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get set method등 만들어줌 structure 확인
@AllArgsConstructor //매개변수를 가진 생성자 만들어줌
@NoArgsConstructor //기본생성자 만들어줌
public class Acceptance {
    String product_type;
}