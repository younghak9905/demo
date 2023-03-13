package com.example.demo.repository;

import com.example.demo.domain.Image;
import com.example.demo.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JpaImageRepository implements ImageRepository{

    private final EntityManager em;

    public JpaImageRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Image findByImageNo(Long no) {
        List<Image> result = em.createQuery("select m from Image m where m.imageNo = :no", Image.class)
                .setParameter("no", no)
                .getResultList();
        return result.stream().findAny().orElse(null);
    }

    @Override
    public Image findByMemberNo(Long no) {
        List<Image> result = em.createQuery("select m from Image m where m.member.no = :no", Image.class)
                .setParameter("no", no)
                .getResultList();
        return result.stream().findAny().orElse(null);
    }

    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public List<Image> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Image> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Image> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Image entity) {

    em.remove(entity);

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Image> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Image> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Image> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Image> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Image> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Image> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Image> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Image getOne(Long aLong) {
        return null;
    }

    @Override
    public Image getById(Long aLong) {
        return null;
    }

    @Override
    public Image getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Image> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Image> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Image> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Image> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Image> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Image> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Image, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
