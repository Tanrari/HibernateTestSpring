import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.SingerDao;
import spring.entities.Album;
import spring.entities.Instrument;
import spring.entities.Singer;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class DbInitializer {
    private Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    @Autowired
    SingerDao singerDao;

//    @Autowired
//    InstrumentDao instrumentDao;
    @PostConstruct
    public void initDb(){
        logger.info("Starting database initialization...");
        Instrument guitar = new Instrument();
        guitar.setInstrumentId("Guitar");
        singerDao.saveInstrument(guitar);
        Instrument piano = new Instrument();
        piano.setInstrumentId("Piano");
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date((new GregorianCalendar(1977,9,16)).getTime().getTime()));
        singer.setInstruments(new HashSet<>(Arrays.asList(piano,guitar)));
        Album album1 = new Album();
        album1.setTitle("The search for everything");
        album1.setReleaseDate(new java.sql.Date (new GregorianCalendar(2017,0,20).getTime().getTime()));
        singer.addAlbum(album1);
        singerDao.insert(singer);
        logger.info("DataBase initialization finished");
    }
    @Test
    public void test(){
        initDb();
    }
}
