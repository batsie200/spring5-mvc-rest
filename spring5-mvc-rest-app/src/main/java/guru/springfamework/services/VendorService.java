package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;

import java.util.List;

/**
 * Created by rubatsirochiripa on 20/4/2018.
 */
public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendor(Long id);
}
