package com.natersfantasy.piggyrichrpg.data.game

import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor

val levelList = listOf(
    Level(
        level = 1,
        savingGoal = 500,
        mascotName = R.string.level_1_chicken_name,
        mascotImage = R.drawable.char_chicken,
        levelColor = PiggyRichColor.Chicken
    ),Level(
        level = 2,
        savingGoal = 1000,
        mascotName = R.string.level_2_giraffe_name,
        mascotImage = R.drawable.char_giraffe,
        levelColor = PiggyRichColor.Giraffe
    ),Level(
        level = 3,
        savingGoal = 5000,
        mascotName = R.string.level_3_lobster_name,
        mascotImage = R.drawable.char_lobster,
        levelColor = PiggyRichColor.Lobster
    ),Level(
        level = 4,
        savingGoal = 10000,
        mascotName = R.string.level_4_frog_name,
        mascotImage = R.drawable.char_frog,
        levelColor = PiggyRichColor.Frog
    ),Level(
        level = 5,
        savingGoal = 50000,
        mascotName = R.string.level_5_dolphin_name,
        mascotImage = R.drawable.char_dolphin,
        levelColor = PiggyRichColor.Dolphin
    ),Level(
        level = 6,
        savingGoal = 100000,
        mascotName = R.string.level_6_cat_name,
        mascotImage = R.drawable.char_cat,
        levelColor = PiggyRichColor.Cat
    )
)