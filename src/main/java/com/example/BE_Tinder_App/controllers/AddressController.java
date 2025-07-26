package com.example.BE_Tinder_App.controllers;


import com.example.BE_Tinder_App.common.AddressConstants;
import com.example.BE_Tinder_App.common.CommonUtils;
import com.example.BE_Tinder_App.dto.address.LocationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final RestTemplate restTemplate;

    @GetMapping("/getAllProvince")
    public ResponseEntity<Object> getAllProvince() throws JsonProcessingException {
        String url = AddressConstants.ADDRESS_DOMAIN + "/provinces?page=0&size=1000";
        String jsonResponse = getJsonResponse(url);
        LocationDTO responseData = CommonUtils.intObjectMapper().readValue(jsonResponse, LocationDTO.class);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAllDistrict")
    public ResponseEntity<Object> getAllDistrict(@RequestParam String idProvince,
                                                 @RequestParam(required = false) String query) throws JsonProcessingException {
        query = StringUtils.isNotEmpty(query) ? "&query=" + query : "";
        String url = AddressConstants.ADDRESS_DOMAIN + "/districts/" + idProvince + "?page=0&size=1000" + query;
        String jsonResponse = getJsonResponse(url);
        LocationDTO responseData = CommonUtils.intObjectMapper().readValue(jsonResponse, LocationDTO.class);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAllWard")
    public ResponseEntity<Object> getAllWard(@RequestParam String districtId,
                                             @RequestParam(required = false) String query) throws JsonProcessingException {
        query = StringUtils.isNotEmpty(query) ? "&query=" + query : "";
        String url = AddressConstants.ADDRESS_DOMAIN + "/wards/" + districtId + "?page=0&size=1000" + query;
        String jsonResponse = getJsonResponse(url);
        LocationDTO responseData = CommonUtils.intObjectMapper().readValue(jsonResponse, LocationDTO.class);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    private String getJsonResponse(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return (String) responseEntity.getBody();
    }
}
