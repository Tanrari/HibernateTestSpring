
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import spring.config.AppConfig;
import spring.dao.SingerDao;
import spring.dao.SingerDaoImpl;
import spring.entities.Singer;

import java.util.List;

public class SpringHibernateDemo {
    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);
    @Test
    public  void main() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
       System.out.println(singerDao);
       listSingers(singerDao.findAll());

    }

    private static void listSingers(List<Singer> singers){
        logger.info("--- Listing singers:");
        for (Singer singer: singers){
//            logger.info(singer);
            System.out.println(singer.toString());
        }

    }
}

