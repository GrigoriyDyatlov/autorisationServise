package ru.netology.autorisationServise.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.autorisationServise.user.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserClassAdapter implements WebMvcConfigurer {

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new Adapter());
    }

    private class Adapter implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.getParameter().getType() == User.class;
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
            String user = ((ServletWebRequest) webRequest)
                    .getRequest()
                    .getParameter("user");
            String passwor = ((ServletWebRequest) webRequest)
                    .getRequest()
                    .getParameter("password");
            return new User(user, passwor);
        }
    }
}
