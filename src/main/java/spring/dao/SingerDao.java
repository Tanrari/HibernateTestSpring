package spring.dao;


import spring.entities.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Singer singer);
    void update(Singer singer);
    void delete(Long singerId);
    List<Singer> findAllWithDetail();
    void insertWithDetail(Singer singer);
    List<Singer> findAllWithAlbum();
    String findNameById(Long id);
    void insertWithAlbum(Singer singer);
    Singer findById(long id);

}
