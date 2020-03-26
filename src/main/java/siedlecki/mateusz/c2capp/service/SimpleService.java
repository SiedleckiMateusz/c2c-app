package siedlecki.mateusz.c2capp.service;

import java.util.List;
import java.util.Optional;

public interface SimpleService<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T t);

    void delete(T obj);

    void deleteById(ID id);


}
