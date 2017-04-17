package imaxct.dao.impl

import imaxct.dao.IUserDao
import imaxct.domain.User
import org.springframework.stereotype.Repository


/**
 * Created by imaxct on 17-4-6.
 */

@Repository
class UserDaoImpl : BaseDao<User>(), IUserDao {

    override fun createUser(username: String, password: String): Boolean {
        val user = User()
        user.username = username
        user.password = password
        return create(user)
    }

    override fun getUserById(id: Int): User? {
        return find(User::class.java, id)
    }

    override fun getUserByName(username: String): User? {
        return uniqueResult("from User where username = $username")
    }
}
