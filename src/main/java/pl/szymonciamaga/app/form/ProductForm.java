package pl.szymonciamaga.app.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.szymonciamaga.app.model.Product;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {

    @NotBlank
    @Digits(integer = 6, fraction = 2)
    private BigDecimal discount;

    @NotBlank
    @Valid
    private Set<Product> products;
}
