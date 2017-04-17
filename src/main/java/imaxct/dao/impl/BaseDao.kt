package imaxct.dao.impl

import org.hibernate.Session
import org.hibernate.SessionFactory
import java.io.Serializable
import javax.annotation.Resource

/**
 * Created by imaxct on 17-4-17.
 */
open class BaseDao<T> {

    @Resource
    val sessionFactory: SessionFactory? = null

    fun uniqueResult(hql: String, vararg objects: Any): T? {
        val session = currentSession()
        try {
            val query = session?.createQuery(hql)
            for (i in objects.indices)
                query?.setParameter(i, objects[i])
            return session?.createQuery(hql)?.uniqueResult() as T?
        } catch (e: Exception) {
            session?.transaction?.rollback()
            return null
        }
    }

    fun create(t: T): Boolean {
        val session = currentSession()
        try {
            session?.persist(t)
            return true
        } catch (e: Exception) {
            session?.transaction?.rollback()
            return false
        }
    }

    fun find(clazz: Class<T>, id: Serializable): T?{
        val session = currentSession()
        return session?.find(clazz, id)
    }

    fun update(t: T): Boolean {
        val session = currentSession()
        try {
            session?.update(t)
            return true
        } catch (e: Exception) {
            session?.transaction?.rollback()
            return false
        }
    }

    fun delete(t: T): Boolean {
        val session = currentSession()
        try {
            session?.delete(t)
            return true
        } catch (e: Exception) {
            session?.transaction?.rollback()
            return false
        }
    }

    fun list(hql: String, vararg obj: Any): List<T>{
        val session = currentSession()
        val query = session?.createQuery(hql)
        for (i in obj.indices)
            query?.setParameter(i, obj[i])
        return query?.list() as List<T>
    }

    fun currentSession(): Session? {
        return sessionFactory?.currentSession
    }
}