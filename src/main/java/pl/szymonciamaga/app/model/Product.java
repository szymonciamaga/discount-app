package pl.szymonciamaga.app.model;

import lombok.*;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;

    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

}
