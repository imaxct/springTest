package imaxct.service.impl

import imaxct.dao.IUserDao
import imaxct.domain.User
import imaxct.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by imaxct on 17-4-6.
 */
@Service
class UserServiceImpl : IUserService {

    @Autowired
    private val userDao: IUserDao? = null

    override fun register(username: String, password: String): Boolean {
        return userDao!!.createUser(username, password)
    }

    override fun login(username: String, password: String): User? {
        val user = userDao!!.getUserByName(username)
        if (user?.password == password)
            return user
        return null
    }
}
