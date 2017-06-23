/**
 * Projet CHOUETTE
 *
 * ce projet est sous license libre
 * voir LICENSE.txt pour plus de details
 *
 */

package fr.certu.chouette.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;

import fr.certu.chouette.filter.Filter;
import fr.certu.chouette.model.neptune.Line;

/**
 * @author michel
 *
 */
public class LineDaoTemplateTests extends AbstractDaoTemplateTests<Line> {

	/* (non-Javadoc)
	 * @see fr.certu.chouette.dao.hibernate.AbstractDaoTemplateTests#createDaoTemplate()
	 */
	@Override
	@BeforeMethod (alwaysRun=true)
	public void createDaoTemplate() 
	{
		initDaoTemplate("Line", "lineDao");
	}

	@Override
	public void refreshBean() 
	{
		bean = createLine();
	}

	@Override
	protected Filter getSelectFilter() 
	{
		return Filter.getNewEqualsFilter("ptNetwork.name", "TestNG Network");
//		return Filter.getNewAndFilter(
//				Filter.getNewEqualsFilter("ptNetwork.id", null),
//				Filter.getNewEqualsFilter("company.id", null),
//				Filter.getNewLikeFilter("name", "nom ligne -53808172"));
	}

   /* (non-Javadoc)
    * @see fr.certu.chouette.dao.hibernate.AbstractDaoTemplateTests#getHqlValues()
    */
   @Override
   protected List<Object> getHqlValues()
   {
      List<Object> values = new ArrayList<Object>();
      values.add("A");
      return values;
   }

   /* (non-Javadoc)
    * @see fr.certu.chouette.dao.hibernate.AbstractDaoTemplateTests#getHQLFilter()
    */
   @Override
   protected String getHQLFilter()
   {
      return "select distinct b from "+beanName+" b left join b.routes r where r.wayBack = ?";
   }
	
	
}
