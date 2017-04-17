package imaxct.controller

import imaxct.service.IUserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import javax.annotation.Resource

/**
 * Created by imaxct on 17-4-6.
 */
@Controller
@RequestMapping(value = "/User")
class UserController {

    @Resource
    private val userService: IUserService? = null

    @RequestMapping(value = "/index", method = arrayOf(RequestMethod.GET))
    fun index(): ModelAndView {
        return ModelAndView("index")
    }


    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    fun login(username: String, password: String): ModelAndView {
        val user = userService!!.login(username, password)
        val modelAndView = ModelAndView("user")
        if (user == null) {
            modelAndView.addObject("msg", "failed")
        } else {
            modelAndView.addObject("msg", "登录成功")
            modelAndView.addObject("user", user)
        }
        return modelAndView
    }

    @RequestMapping(value = "/register", method = arrayOf(RequestMethod.POST))
    fun register(username: String, password: String): ModelAndView {
        val flag = userService!!.register(username, password)
        val modelAndView = ModelAndView("user")
        if (flag) {
            modelAndView.addObject("msg", "注册成功")
        } else {
            modelAndView.addObject("msg", "注册失败")
        }
        return modelAndView
    }
}
