package esperer.gauth_feign.global.security.jwt

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.security.Key

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    accessSecret: String,
    refreshSecret: String
) {

    val accessSecret: Key
    val refreshSecret: Key

    init {
        this.accessSecret = Keys.hmacShaKeyFor(accessSecret.toByteArray())
        this.refreshSecret = Keys.hmacShaKeyFor(refreshSecret.toByteArray())
    }

    companion object {
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
        const val TOKEN_PREFIX = "Bearer "
    }
}