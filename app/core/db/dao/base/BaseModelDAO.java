package core.db.dao.base;

import core.db.dao.DAO;
import core.db.model.BaseModel;


public interface BaseModelDAO<T extends BaseModel> extends DAO<T, Long> {

}
