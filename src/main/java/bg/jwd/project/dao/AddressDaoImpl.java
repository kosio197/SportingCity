package bg.jwd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bg.jwd.project.entities.Address;
import bg.jwd.project.entities.Quarter;

@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Address addAddress(String city, Quarter quarter, String streetNumber, String description) {

        Address address = new Address();
        address.setCity(city);
        address.setDescription(description);
        address.setQuarter(quarter);
        address.setStreetNumber(streetNumber);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(address);
        tx.commit();
        session.close();

        return address;
    }

    @Override
    public Address getAddress(int Id) {

        Criteria criteria = sessionFactory.openSession().createCriteria(Address.class);
        criteria.add(Restrictions.like("Id", Id));
        @SuppressWarnings("unchecked")
        List<Address> addressList = criteria.list();
        Address address = new Address();

        if (addressList.size() != 0) {
            address = addressList.get(0);
        }
        return address;
    }

    @Override
    public Address editAddress(int id, String city, Quarter quarter, String streetNumber, String description) {

        Address address = getAddress(id);
        address.setCity(city);
        address.setDescription(description);
        address.setQuarter(quarter);
        address.setStreetNumber(streetNumber);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(address);
        tx.commit();
        session.close();

        return address;
    }

    @Override
    public Address getFilteredAddress(String city, Quarter quarter) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Address> getAllAddress() {

        Criteria criteria = sessionFactory.openSession().createCriteria(Address.class);

        return criteria.list();
    }

    @Override
    public void deleteAddress(Address address) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(address);
        tx.commit();
        session.close();
    }

}
