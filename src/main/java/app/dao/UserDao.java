package app.dao;

import app.exception.UnexpectedException;
import app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super();
        type = User.class;
    }

    @Override
    public void update(Integer id, User newEntity) throws UnexpectedException {
        User oldEntity = getCurrentSession().get(type, id);
        if (oldEntity == null)
            throw new UnexpectedException("User to update does not exist");

        oldEntity.setEmail(newEntity.getEmail());
        oldEntity.setName(newEntity.getName());

        getCurrentSession().update(oldEntity);
    }
}
