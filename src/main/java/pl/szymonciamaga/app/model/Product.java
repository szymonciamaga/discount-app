package pl.szymonciamaga.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@JsonFormat
public class Product {

    private String name;

    @Digits(integer = 6, fraction = 2)
    private BigDecimal discount;
}
