package pl.szymonciamaga.app.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@JsonFormat
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {

    @NotBlank
    private String name;

    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
}
