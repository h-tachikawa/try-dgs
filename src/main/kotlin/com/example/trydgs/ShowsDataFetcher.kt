package com.example.trydgs

import com.example.trydgs.generated.DgsConstants
import com.example.trydgs.generated.types.Show
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class ShowsDataFetcher {
    private val shows = listOf<Show>(
            Show("Stranger Things", 2016),
            Show("Ozark", 2017),
            Show("The Crown", 2016),
            Show("Dead to Me", 2019),
            Show("Orange is the New Black", 2013))

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Shows)
    fun shows(@InputArgument titleFilter: String?): List<Show> {
        return if (titleFilter != null) {
            shows.filter { it.title?.contains(titleFilter) ?: false }
        } else {
            shows
        }
    }
}