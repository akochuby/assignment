package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super();
        type = User.class;
    }

    @Override
    public void update(Integer id, User newEntity){
        User oldEntity = getCurrentSession().get(type, id);

        oldEntity.setEmail(newEntity.getEmail());
        oldEntity.setName(newEntity.getName());

        getCurrentSession().update(oldEntity);
    }
}
