package spring.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Instrument;
import spring.entities.Singer;
import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao{
    private SessionFactory sessionFactory;
    private static final Log logger  = LogFactory.getLog(SingerDaoImpl.class);


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true )
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("Singer saved with:" + singer.getId());

    }

    @Override
    public void update(Singer singer) {

    }



    @Override
    public void deleteSinger(Singer singer) {

    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }

    public void saveInstrument(Instrument instrument){
        sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        logger.info("Instrument saved with:" + instrument.getInstrumentId());
    }

    public void delete(Singer singer){
        sessionFactory.getCurrentSession().delete(singer);
        logger.info("Singer deleted with id:"+singer.getId());
    }
    @Override
    public Singer findById(long id) {
        return (Singer) sessionFactory.getCurrentSession().getNamedQuery("Singer.findById")
                .setParameter("id",id).uniqueResult();
    }
}
