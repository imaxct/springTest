package imaxct.domain

import javax.persistence.*

/**
 * Created by imaxct on 17-4-6.
 */
@Entity
@Table(name = "test_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column(unique = true)
    var username: String? = null

    var password: String? = null
}
