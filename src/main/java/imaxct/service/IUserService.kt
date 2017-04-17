package imaxct.service

import imaxct.domain.User

/**
 * Created by imaxct on 17-4-6.
 */
interface IUserService {
    fun register(username: String, password: String): Boolean
    fun login(username: String, password: String): User?
}
