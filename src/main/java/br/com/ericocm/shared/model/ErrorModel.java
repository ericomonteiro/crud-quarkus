package br.com.ericocm.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class ErrorModel {

    private String title;
    private String message;

    public static List<ErrorModel> fromConstraintViolationException(String title, ConstraintViolationException e) {

        return e.getConstraintViolations()
                .stream()
                .map(violation -> new ErrorModel(title, violation.getMessage()))
                .collect(Collectors.toList());


    }



}
