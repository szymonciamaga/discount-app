package pl.szymonciamaga.app.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@JsonFormat
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {

    @NotBlank
    private String name;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
}
