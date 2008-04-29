/*
 * This is a common dao with basic CRUD operations and is not limited to any 
 * persistent layer implementation
 * 
 * Copyright (C) 2008  Imran M Yousuf
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.smartitengineering.dao.impl.hibernate;

import com.smartitengineering.dao.common.QueryParameter;
import com.smartitengineering.domain.PersistentDTO;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractDAO<Template extends PersistentDTO> extends HibernateDaoSupport implements Serializable
{
    protected void createEntity( Template entity )
    {
        if( entity == null )
        {
            throw new IllegalArgumentException();
        }
        getHibernateTemplate().save( entity );
    }
    
    protected void updateEntity( Template entity )
    {
        if( entity == null )
        {
            throw new IllegalArgumentException();
        }
        getHibernateTemplate().update( entity );
    }
    
    protected void deleteEntity( Template entity )
    {
        if( entity == null )
        {
            throw new IllegalArgumentException();
        }
        getHibernateTemplate().delete( entity );
    }
    
    protected Template readSingle( Class entityClass, Hashtable<String, QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return (Template) criteria.uniqueResult();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected Object readOther( Class entityClass, Hashtable<String, QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.uniqueResult();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected List<? extends Object> readOtherList( Class entityClass, Hashtable<String, QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.list();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected List<Template> readList( Class entityClass, Hashtable<String, QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.list();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected Template readSingle( Class entityClass, List<QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return (Template) criteria.uniqueResult();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected Object readOther( Class entityClass, List<QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.uniqueResult();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected List<? extends Object> readOtherList( Class entityClass, List<QueryParameter> parameter  )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.list();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected List<Template> readList( Class entityClass, List<QueryParameter> parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.list();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    
    protected Template readSingle( Class entityClass, QueryParameter ... parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return (Template) criteria.uniqueResult();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected Object readOther( Class entityClass, QueryParameter ... parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.uniqueResult();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected List<? extends Object> readOtherList( Class entityClass, QueryParameter ... parameter  )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.list();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    protected List<Template> readList( Class entityClass, QueryParameter ... parameter )
    {
        Session session;
        boolean customSession = false;
        try
        {
            session = getSessionFactory().getCurrentSession();
        }
        catch (Exception ex)
        {
            session = getSessionFactory().openSession();
            customSession = true;
        }
        try
        {
            Criteria criteria = simpleSearchCriteria( session, entityClass, parameter );
            return criteria.list();
        }
        catch( Exception e )
        {
            throw new IllegalArgumentException( e );
        }
        finally
        {
            if(customSession && session.isOpen())
            {
                session.close();
            }
        }
    }
    
    
    protected Criteria simpleSearchCriteria( Session session, Class queryClass,
            Hashtable<String, QueryParameter> parameter )
    {
        Criteria criteria = session.createCriteria( queryClass );
        Iterator<String> keys = parameter.keySet().iterator();
        for( ; keys.hasNext(); )
        {
            String element = keys.next();
            QueryParameter param = parameter.get( element );
            String propName;
            if(param.getPropertyName() != null)
            {
                propName = param.getPropertyName();
            }
            else
            {
                propName = element;
            }
            processCriterion( criteria, propName, param );
        }
        return criteria;
    }
    
    protected Criteria simpleSearchCriteria( Session session, Class queryClass,
            List<QueryParameter> parameter )
    {
        Criteria criteria = session.createCriteria( queryClass );
        Iterator<QueryParameter> keys = parameter.iterator();
        for( ; keys.hasNext(); )
        {
            QueryParameter param = keys.next();
            processCriterion( criteria, param.getPropertyName(), param );
        }
        return criteria;
    }
    
    protected Criteria simpleSearchCriteria( Session session, Class queryClass,
            QueryParameter ... parameter )
    {
        Criteria criteria = session.createCriteria( queryClass );
        for( QueryParameter param : parameter )
        {
            processCriterion( criteria, param.getPropertyName(), param );
        }
        return criteria;
    }
    
    
    @SuppressWarnings("unchecked")
    private void processCriterion( Criteria criteria, String element, QueryParameter parameter )
    {
        switch( parameter.getType().intValue() )
        {
            case 1:
            {
                criteria.add( getCriterion( element, parameter.getParameter(), parameter.getParameter2(), parameter
                        .getOperator(), parameter.getMatchMode() ) );
                return;
            }
            case 2:
            {
                criteria.addOrder( ( (Order) parameter.getParameter() ) );
                return;
            }
            case 3:
            {
                criteria.setMaxResults( (Integer) parameter.getParameter() );
                return;
            }
            case 4:
            {
                criteria.setFirstResult( (Integer) parameter.getParameter() );
                return;
            }
            case 5:
            {
                processDisjunction( criteria, element, parameter );
                return;
            }
            case 6:
            {
                processNestedParameter( criteria, element, parameter );
                return;
            }
            case 7:
            {
                criteria.setProjection(Projections.count(element));
                return;
            }
            case 8:
            {
                criteria.setProjection(Projections.rowCount());
                return;
            }
            case 9:
            {
                criteria.setProjection(Projections.sum(element));
                return;
            }
            case 10:
            {
                criteria.setProjection(Projections.max(element));
                return;
            }
            case 11:
            {
                criteria.setProjection(Projections.min(element));
                return;
            }
            case 12:
            {
                criteria.setProjection(Projections.avg(element));
                return;
            }
            case 13:
            {
                criteria.setProjection(Projections.groupProperty(element));
                return;
            }
            case 14:
            {
                criteria.setProjection(Projections.distinct((Projection) parameter.getParameter()));
                return;
            }
            case 15:
            {
                criteria.setProjection(Projections.countDistinct(element));
                return;
            }
            case 16:
            {
                criteria.setProjection(Projections.distinct(Projections.property(element)));
                return;
            }
            case 17:
            {
                criteria.setProjection(Projections.property(element));
                return;
            }
            case 18:
            {
                ProjectionList list = Projections.projectionList();
                Object param = parameter.getParameter();
                if(param instanceof List)
                {
                    List listParam = (List)param;
                    for (Iterator it = listParam.iterator(); it.hasNext();)
                    {
                        Object elem = (Object) it.next();
                        list.add(Projections.property(elem.toString()));
                    }
                }
                criteria.setProjection(list);
                return;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private void processNestedParameter( Criteria criteria, String element, QueryParameter parameter )
    {
        FetchMode mode;
        switch(parameter.getFetchMode()) {
            case EAGER: mode = FetchMode.EAGER; break;
            case SELECT: mode = FetchMode.SELECT; break;
            case JOIN: mode = FetchMode.JOIN; break;
            case LAZY: mode = FetchMode.LAZY; break;
            default:
            case DEFAULT: mode = FetchMode.DEFAULT; break;
        }
        criteria.setFetchMode( element, ( ( mode == null ) ? FetchMode.JOIN : mode ) );
        Hashtable<String, QueryParameter> nestedParameter = parameter.getNestedParameters();
        if( nestedParameter == null || nestedParameter.size() <= 0 )
        {
            return;
        }
        Criteria nestedCriteria = criteria.createCriteria( element );
        Iterator<String> keys = nestedParameter.keySet().iterator();
        for( ; keys.hasNext(); )
        {
            String nestedElement = keys.next();
            QueryParameter nestedQueryParameter = nestedParameter.get( nestedElement );
            processCriterion( nestedCriteria, nestedQueryParameter.getPropertyName(), nestedQueryParameter );
        }
    }
    
    @SuppressWarnings("unchecked")
    private void processCriterion( Disjunction criteria, String element, QueryParameter parameter )
    {
        switch( parameter.getType().intValue() )
        {
            case 1:
                criteria.add( getCriterion( element, parameter.getParameter(), parameter.getParameter2(), parameter
                        .getOperator(), parameter.getMatchMode() ) );
                return;
        }
    }
    
    @SuppressWarnings("unchecked")
    private void processDisjunction( Criteria criteria, String element, QueryParameter parameter )
    {
        Disjunction disjunction = Expression.disjunction();
        Hashtable<String, QueryParameter> nestedParameter = parameter.getNestedParameters();
        Iterator<String> keys = nestedParameter.keySet().iterator();
        for( ; keys.hasNext(); )
        {
            String nestedElement = keys.next();
            processCriterion( disjunction, element, nestedParameter.get( nestedElement ) );
        }
        criteria.add( disjunction );
    }
    
    private Criterion getCriterion( String element, Object parameter, Object parameter2, Integer operator,
            QueryParameter.MatchMode matchMode )
    {
        if( operator.equals( QueryParameter.OPERATOR_EQUAL ) )
        {
            return Expression.eq( element, parameter );
        }
        else if( operator.equals( QueryParameter.OPERATOR_LESSER ) )
        {
            return Expression.lt( element, parameter );
        }
        else if( operator.equals( QueryParameter.OPERATOR_LESSER_EQUAL ) )
        {
            return Expression.le( element, parameter );
        }
        else if( operator.equals( QueryParameter.OPERATOR_GREATER ) )
        {
            return Expression.gt( element, parameter );
        }
        else if( operator.equals( QueryParameter.OPERATOR_GREATER_EQUAL ) )
        {
            return Expression.ge( element, parameter );
        }
        else if( operator.equals( QueryParameter.OPERATOR_NOT_EQUAL ) )
        {
            return Expression.ne( element, parameter );
        }
        else if( operator.equals( QueryParameter.OPERATOR_IS_NULL ) )
        {
            return Expression.isEmpty( element );
        }
        else if( operator.equals( QueryParameter.OPERATOR_IS_NOT_NULL ) )
        {
            return Expression.isNotEmpty( element );
        }
        else if( operator.equals( QueryParameter.OPERATOR_STRING_LIKE ) )
        {
            MatchMode hibernateMatchMode;
            switch(matchMode) {
                case END: hibernateMatchMode = MatchMode.END; break;
                case EXACT: hibernateMatchMode = MatchMode.EXACT; break;
                case START: hibernateMatchMode = MatchMode.START; break;
                default:
                case ANYWHERE: hibernateMatchMode = MatchMode.ANYWHERE; break;
            }
            return Expression.like( element, parameter.toString(), hibernateMatchMode );
        }
        else if( operator.equals( QueryParameter.OPERATOR_BETWEEN ) )
        {
            return Expression.between( element, parameter, parameter2 );
        }
        return null;
    }
}