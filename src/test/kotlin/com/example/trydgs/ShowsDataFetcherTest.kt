package com.example.trydgs

import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
//import io.kotest.core.spec.style.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@SpringBootTest(classes = [DgsAutoConfiguration::class, ShowsDataFetcher::class])
class ShowsDataFetcherTest {
    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun shows() {
        val titles: List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
                shows {
                    title
                    releaseYear
                }
            }
        """.trimIndent(), "data.shows[*].title")

        assertThat(titles).contains("Ozark")
    }
}