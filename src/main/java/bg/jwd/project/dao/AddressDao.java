package bg.jwd.project.dao;

import java.util.List;

import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Quarter;

public interface AddressDao {

    Address addAddress(String city, Quarter quarter, String streetNumber, String description);

    Address getAddress(int Id);

    Address editAddress(int id, String city, Quarter quarter, String streetNumber, String description);

    Address getFilteredAddress(String city, Quarter quarter);

    List<Address> getAllAddress();

    void deleteAddress(Address address);

}
