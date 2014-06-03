package core.db.dao.base;

import core.db.dao.AbstractDAO;
import core.db.model.BaseModel;


public abstract class AbstractBaseModelDAO<T extends BaseModel> extends AbstractDAO<T, Long> implements BaseModelDAO<T> {

    public AbstractBaseModelDAO() {
        this.typeOfID = Long.class;
    }

}
