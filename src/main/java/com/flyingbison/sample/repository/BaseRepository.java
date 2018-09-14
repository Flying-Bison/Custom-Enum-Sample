package com.flyingbison.sample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    /* --- Make desired standard repository methods available --- */

    /**
     * This method deletes an entity from the database
     *
     * @param entity - deleted entity
     */
    void delete(T entity);

    /**
     * This method finds a single entity based on the id column
     * @param id - id of entity to be found
     * @return - Entity found by Id
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    Optional<T> findById(Long id);

    /**
     * This method finds all entities of the given type
     * @return - List of all entitites
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    List<T> findAll();

    /**
     * This method saves an entity
     * @param entity - entity to be saved
     * @return - saved entity
     */
    T save(T entity);


    /* -- Make paging and sorting methods available -- */

    /**
     * Returns all entities sorted by the given options.
     *
     * @param sort
     * @return all entities sorted by the given options
     */
    Iterable<T> findAll(Sort sort);

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     * @return a page of entities
     */
    Page<T> findAll(Pageable pageable);
}
