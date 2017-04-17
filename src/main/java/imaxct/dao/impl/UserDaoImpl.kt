package imaxct.dao.impl

import imaxct.dao.IUserDao
import imaxct.domain.User
import org.hibernate.HibernateException
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.query.Query
import org.springframework.orm.hibernate5.HibernateCallback
import org.springframework.orm.hibernate5.support.HibernateDaoSupport
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.annotation.Resource


/**
 * Created by imaxct on 17-4-6.
 */

@Repository("userDao")
class UserDaoImpl : HibernateDaoSupport(), IUserDao {

    @Resource(name = "sessionFactory")
    fun setSuperSessionFactory(sessionFactory: SessionFactory) {
        super.setSessionFactory(sessionFactory)
    }

    @Transactional
    override fun createUser(username: String, password: String): Boolean {
        val user = User()
        user.username = username
        user.password = password
        try {
            return hibernateTemplate.execute { session ->
                session.persist(user)
                true
            }
        } catch (e: Exception) {
            return false
        }

    }

    @Transactional(readOnly = true)
    override fun getUserById(id: Int): User {
        return hibernateTemplate.get<User>(User::class.java, id)
    }

    @Transactional(readOnly = true)
    override fun getUserByName(username: String): User? {
        try {
            return hibernateTemplate.execute { session ->
                val query = session.createQuery<User>("from User where username=?", User::class.java)
                query.setParameter(0, username)
                query.uniqueResult()
            }
        } catch (e: Exception) {
            return null
        }

    }
}
