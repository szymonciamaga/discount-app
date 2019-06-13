package pl.szymonciamaga.app.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@JsonFormat
@NoArgsConstructor
@AllArgsConstructor
public class DiscountForm {

    @Digits(integer = 6, fraction = 2)
    private BigDecimal discount;

    @Valid
    @Size(min = 1, max = 5)
    private Set<ProductForm> products;
}
