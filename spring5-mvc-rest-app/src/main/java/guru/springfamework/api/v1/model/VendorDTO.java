package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by rubatsirochiripa on 20/4/2018.
 */
@Data
public class VendorDTO {

    @ApiModelProperty(value = "name of the vendor", required = true)
    private String name;

    @JsonProperty(value = "vendor_url")
    private String vendorUrl;
}
