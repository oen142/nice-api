package com.example.niceapi

import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver


@Configuration
@EnableWebMvc
class ThymeleafConfiguration : WebMvcConfigurer {
    @Bean
    fun templateEngine(): SpringTemplateEngine? {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(thymeleafTemplateResolver())
        return templateEngine
    }

    @Bean
    fun thymeleafTemplateResolver(): ClassLoaderTemplateResolver? {
        val templateResolver = ClassLoaderTemplateResolver()
        templateResolver.prefix = "templates/" // 모든 뷰 페이지는 /resources/templates/ 내부에서 검색한다.
        templateResolver.suffix = ".html" // 모든 뷰 페이지는 .html 이다.
        templateResolver.setTemplateMode("HTML") // HTML 형식으로 읽는다.
        templateResolver.isCacheable = false // 캐싱하지 않는다.
        return templateResolver
    }


}