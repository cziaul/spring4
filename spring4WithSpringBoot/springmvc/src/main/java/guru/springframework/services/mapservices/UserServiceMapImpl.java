package guru.springframework.services.mapservices;

import java.util.List;

import guru.springframework.domain.DomainObject;
import guru.springframework.domain.Users;
import guru.springframework.services.UserService;

public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Users getById(Integer id) {
        return (Users) super.getById(id);
    }

    @Override
    public Users saveOrUpdate(Users domainObject) {
        return (Users) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}