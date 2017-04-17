package imaxct.dao

import imaxct.domain.User

/**
 * Created by imaxct on 17-4-6.
 */
interface IUserDao {
    fun createUser(username: String, password: String): Boolean
    fun getUserById(id: Int): User?
    fun getUserByName(username: String): User?
}
