package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.CategoryType
import com.example.mycity.model.Location
import com.example.mycity.model.Recommendation

object LocalDataRecommendationsProvider {

    private val parks = listOf(
        Recommendation(
            name = R.string.peace_park,
            image = R.drawable.peace_park,
            id = 1L,
            description = R.string.peace_park_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.215457,
                longitude = 33.302738
            )
        ),
        Recommendation(
            name = R.string.city_garden,
            image = R.drawable.city_garden,
            id = 2L,
            description = R.string.city_garden_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.209722,
                longitude = 33.308333
            )
        ),
        Recommendation(
            name = R.string.mud_park,
            image = R.drawable.mud_park,
            id = 3L,
            description = R.string.mud_park_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.214444,
                longitude = 33.312222
            )
        ),
        Recommendation(
            name = R.string.jubilee_park,
            image = R.drawable.jubilee_park,
            id = 4L,
            description = R.string.jubilee_park_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.233889,
                longitude = 33.313333
            )
        ),
        Recommendation(
            name = R.string.oleg_babayevs_square,
            image = R.drawable.oleg_babayevs_square,
            id = 5L,
            description = R.string.oleg_babayevs_square_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.067178503406865,
                longitude = 33.412100865289425
            )
        ),
        Recommendation(
            name = R.string.kotlov_park,
            image = R.drawable.kotlov_park,
            id = 6L,
            description = R.string.kotlov_park_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.227778,
                longitude = 33.322222
            )
        ),
        Recommendation(
            name = R.string.komsomolsky_park,
            image = R.drawable.komsomolsky_park,
            id = 7L,
            description = R.string.komsomolsky_park_details,
            type = CategoryType.Parks,
            location = Location(
                latitude = 49.226111,
                longitude = 33.316667
            )
        )
    )

    private val museums = listOf(
        Recommendation(
            name = R.string.local_history_museum,
            image = R.drawable.local_history_museum,
            id = 8L,
            description = R.string.local_history_museum_details,
            workTime = R.string.local_history_museum_work_time,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.2125,
                longitude = 33.3058
            )
        ),
        Recommendation(
            name = R.string.aviation_and_cosmonautics_history_museum,
            image = R.drawable.aviation_and_cosmonautics_history_museum,
            id = 9L,
            description = R.string.aviation_and_cosmonautics_history_museum_details,
            workTime = R.string.aviation_and_cosmonautics_history_museum_work_time,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.2136,
                longitude = 33.3067
            )
        ),
        Recommendation(
            name = R.string.makarenko_house_museum,
            image = R.drawable.makarenko_house_museum,
            id = 10L,
            description = R.string.makarenko_house_museum_details,
            workTime = R.string.makarenko_house_museum_work_time,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.2141,
                longitude = 33.3065
            )
        ),
        Recommendation(
            name = R.string.odnostroyu_history_museum,
            image = R.drawable.odnostroyu_history_museum,
            id = 11L,
            description = R.string.odnostroyu_history_museum_details,
            workTime = R.string.odnostroyu_history_museum_work_time,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.215,
                longitude = 33.3062
            )
        ),
        Recommendation(
            name = R.string.railroad_museum,
            image = R.drawable.railroad_museum,
            id = 12L,
            description = R.string.railroad_museum_details,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.2167,
                longitude = 33.3066
            )
        ),
        Recommendation(
            name = R.string.military_equipment_museum,
            image = R.drawable.military_equipment_museum,
            id = 13L,
            description = R.string.military_equipment_museum_details,
            workTime = R.string.military_equipment_museum_work_time,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.2197,
                longitude = 33.3061
            )
        ),
        Recommendation(
            name = R.string.art_gallery,
            image = R.drawable.art_gallery,
            id = 14L,
            description = R.string.art_gallery_details,
            workTime = R.string.art_gallery_work_time,
            type = CategoryType.Museums,
            location = Location(
                latitude = 49.2152,
                longitude = 33.3055
            )
        )
    )

    private val establishments = listOf(
        Recommendation(
            name = R.string.ivushki_restaurant,
            image = R.drawable.ivushki_restaurant,
            id = 15L,
            description = R.string.ivushki_restaurant_details,
            workTime = R.string.ivushki_restaurant_work_time,
            type = CategoryType.Establishments,
            location = Location(
                latitude = 49.2125,
                longitude = 33.3058
            )
        ),
        Recommendation(
            name = R.string.picasso_restaurant,
            image = R.drawable.picasso_restaurant,
            id = 16L,
            description = R.string.picasso_restaurant_details,
            workTime = R.string.picasso_restaurant_work_time,
            type = CategoryType.Establishments,
            location = Location(
                latitude = 49.2136,
                longitude = 33.3067
            )
        ),
        Recommendation(
            name = R.string.cafe_kofan,
            image = R.drawable.cafe_kofan,
            id = 17L,
            description = R.string.cafe_kofan_details,
            workTime = R.string.cafe_kofan_work_time,
            type = CategoryType.Establishments,
            location = Location(
                latitude = 49.2141,
                longitude = 33.3065
            )
        ),
        Recommendation(
            name = R.string.dao_noodle_bar_restaurant,
            image = R.drawable.dao_noodle_bar_restaurant,
            id = 18L,
            description = R.string.dao_noodle_bar_restaurant_details,
            workTime = R.string.dao_noodle_bar_restaurant_work_time,
            type = CategoryType.Establishments,
            location = Location(
                latitude = 49.215,
                longitude = 33.3062
            )
        ),
        Recommendation(
            name = R.string.four_seasons_restaurant,
            image = R.drawable.four_seasons_restaurant,
            id = 19L,
            description = R.string.four_seasons_restaurant_details,
            workTime = R.string.four_seasons_restaurant_work_time,
            type = CategoryType.Establishments,
            location = Location(
                latitude = 49.2152,
                longitude = 33.3055
            )
        )
    )

    val recommendationsGroupedByType = (parks + museums + establishments).groupBy { it.type }

}