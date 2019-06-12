package pl.szymonciamaga.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@JsonFormat
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDiscountDTO {

    private Set<ProductDTO> productDTOS = new HashSet<>();

}
