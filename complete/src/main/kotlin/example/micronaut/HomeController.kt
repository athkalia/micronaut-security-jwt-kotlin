package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule

@Controller
class HomeController {

    @Produces(MediaType.TEXT_PLAIN) // <3>
    @Post("/lala")  // <4>
    @Secured(SecurityRule.IS_ANONYMOUS)
    fun index(
        @Header("Authorization") auth: String,
        authentication: Authentication
    ): String {
        return authentication.name
    }
}
