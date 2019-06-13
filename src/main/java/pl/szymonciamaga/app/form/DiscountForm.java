package pl.szymonciamaga.app.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;


@JsonFormat
public class DiscountForm {

    @Getter
    @Setter
    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal discount;

    @Valid
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 5)
    private Set<ProductForm> products;

    public Set<ProductForm> getProducts() {
        return Collections.unmodifiableSet(products);
    }
}
