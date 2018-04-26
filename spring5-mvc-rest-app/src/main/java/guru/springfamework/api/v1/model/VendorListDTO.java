package guru.springfamework.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * Created by rubatsirochiripa on 20/4/2018.
 */
@Data
public class VendorListDTO {

    List<VendorDTO> vendorDTOList;

    public VendorListDTO(List<VendorDTO> vendorDTOList) {
        this.vendorDTOList = vendorDTOList;
    }
}
