package com.pcbacceptance.pcb_acceptance.controller;

import com.pcbacceptance.pcb_acceptance.model.Acceptance;
import com.pcbacceptance.pcb_acceptance.model.Api;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ResponseProductTypeController {

    @PostMapping("/response")
    public ResponseEntity<Acceptance> returnProductType(
            @Valid
            @RequestBody
            Api<Acceptance> acceptance
    ) {
        var body = acceptance.getData();
        String productType = body.getProductType();
        List<String>errorType = body.getErrorType();
        switch (productType) {
            case "1":
                log.info("Product type 01: Description for product type 01");
                break;
            case "2":
                log.info("Product type 02: Description for product type 02");
                break;
            case "3":
                log.info("Product type 03: Description for product type 03");
                break;
            case "4":
                log.info("Product type 04: Description for product type 04");
                break;
            case "5":
                log.info("Product type 05: Description for product type 05");
                break;
            case "6":
                log.info("Product type 06: Description for product type 06");
                break;
            case "7":
                log.info("Product type 07: Description for product type 07");
                break;
            case "8":
                log.info("Product type 08: Description for product type 08");
                break;
            case "9":
                log.info("Product type 09: Description for product type 09");
                break;
            case "10":
                log.info("Product type 10: Description for product type 10");
                break;
            case "11":
                log.info("Product type 11: Description for product type 11");
                break;
            case "12":
                log.info("Product type 12: Description for product type 12");
                break;
            default:
                log.warn("Unknown product type: " + productType);
        }
        if(errorType.isEmpty()){
            log.info("양품 (fair quality)");
        }else {
            for (String error : errorType) {
                switch (error) {
                    case "Missing_hole":
                        log.info("Missing_hole");
                        break;
                    case "Mouse_bite":
                        log.info("Mouse_bite");
                        break;
                    case "Open_circuit":
                        log.info("Open_circuit");
                        break;
                    case "Short":
                        log.info("Short");
                        break;
                    case "Spur":
                        log.info("Spur");
                        break;
                    case "Spurious_copper":
                        log.info("Spurious_copper");
                        break;
                    default:
                        log.info("Unknown error: " + error);
                        break;
                }
            }
        }
        var response = Api
                .<Acceptance>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response.getData());
    }

}