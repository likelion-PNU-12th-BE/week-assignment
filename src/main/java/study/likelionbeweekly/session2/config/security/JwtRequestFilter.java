package study.likelionbeweekly.session2.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import study.likelionbeweekly.session2.service.CustomUserDetailsService;

@RequiredArgsConstructor
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	private final CustomUserDetailsService userDetailsService;
	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
		final FilterChain filterChain)
		throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		String jwt = null;
		String username = null;

		String BEARER_PREFIX = "Bearer ";
		if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
			jwt = authorizationHeader.substring(BEARER_PREFIX.length());
			username = jwtUtil.extractUsername(jwt);
		}

	}
}
