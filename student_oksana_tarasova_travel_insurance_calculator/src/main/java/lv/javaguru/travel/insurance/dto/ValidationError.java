package lv.javaguru.travel.insurance.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ValidationError {

    private String field;
    private String message;
}
