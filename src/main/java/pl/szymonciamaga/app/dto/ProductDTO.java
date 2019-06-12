package pl.szymonciamaga.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@JsonFormat
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;

    @Digits(integer = 6, fraction = 2)
    private BigDecimal discount;

}
