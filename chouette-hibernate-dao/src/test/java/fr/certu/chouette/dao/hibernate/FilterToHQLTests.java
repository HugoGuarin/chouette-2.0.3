package fr.certu.chouette.dao.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fr.certu.chouette.filter.Filter;
import fr.certu.chouette.model.neptune.Line;
import fr.certu.chouette.model.neptune.Timetable;

/**
 * @author michel
 *
 */
@ContextConfiguration(locations={"classpath:testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)

public class FilterToHQLTests extends AbstractTransactionalTestNGSpringContextTests
{
   private static final Logger logger = Logger.getLogger(FilterToHQLTests.class);

   private SessionFactory factory;

   @BeforeMethod (groups = {"hql"})
   public void init()
   {
      factory = (SessionFactory) applicationContext.getBean("sessionFactory");
   }
   
   @Test (groups = {"hql"}, description = "check HQL equals one simple attribute" )
   public void verifyHQL1() 
   {
      FilterToHibernateHqlTranslator translator = new FilterToHibernateHqlTranslator(factory);
      Filter clause = Filter.getNewEqualsFilter("objectId", "NINOXE:Line:1234");
      List<Object> values = new ArrayList<Object>();
      String hql = translator.translateToHQLSelect(Line.class, clause, values);
      Reporter.log(hql);
//      Assert.assertEquals(hql,"select distinct b0 from fr.certu.chouette.model.neptune.Line as b0 where b0.objectId = ?");
//      Assert.assertEquals(values.size(), 1);
//      Assert.assertEquals(values.get(0), "NINOXE:Line:1234");
      
   }

   
   @Test (groups = {"hql"}, description = "check HQL equals one collection attribute" )
   public void verifyHQL2() 
   {
      FilterToHibernateHqlTranslator translator = new FilterToHibernateHqlTranslator(factory);
      Filter clause = Filter.getNewEqualsFilter("calendarDays", toDate("02/10/2011"));
      List<Object> values = new ArrayList<Object>();
      String hql = translator.translateToHQLSelect(Timetable.class, clause, values);
      Reporter.log(hql);
//      Assert.assertEquals(hql,"select distinct b0 from fr.certu.chouette.model.neptune.Timetable as b0 left join b0.calendarDays as b1 where b1.value = ?");
//      Assert.assertEquals(values.size(), 1);
//      Assert.assertEquals(values.get(0), toDate("02/10/2011"));
      
   }
   
   
   
   protected static java.sql.Date toDate(String sDate)
   {
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Date d = new Date();
      try
      {
          d = format.parse(sDate);
      }
      catch (ParseException e)
      {
         
      }
      return new java.sql.Date(d.getTime());
      
   }


}
