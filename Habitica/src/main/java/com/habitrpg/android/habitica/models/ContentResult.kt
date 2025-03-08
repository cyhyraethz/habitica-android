package xyz.prfn.android.habitica.models

import xyz.prfn.android.habitica.models.inventory.Customization
import xyz.prfn.android.habitica.models.inventory.Egg
import xyz.prfn.android.habitica.models.inventory.Equipment
import xyz.prfn.android.habitica.models.inventory.EquipmentSet
import xyz.prfn.android.habitica.models.inventory.Food
import xyz.prfn.android.habitica.models.inventory.HatchingPotion
import xyz.prfn.android.habitica.models.inventory.Mount
import xyz.prfn.android.habitica.models.inventory.Pet
import xyz.prfn.android.habitica.models.inventory.QuestContent
import xyz.prfn.android.habitica.models.inventory.SpecialItem
import io.realm.RealmList

/**
 * Created by Negue on 15.07.2015.
 */
class ContentResult {
    var potion: Equipment? = null
    var armoire: Equipment? = null
    var gear: ContentGear? = null
    var quests = RealmList<QuestContent>()
    var eggs = RealmList<Egg>()
    var food = RealmList<Food>()
    var hatchingPotions = RealmList<HatchingPotion>()
    var pets = RealmList<Pet>()
    var mounts = RealmList<Mount>()
    var spells = RealmList<Skill>()
    var appearances = RealmList<Customization>()
    var backgrounds = RealmList<Customization>()
    var faq = RealmList<FAQArticle>()
    var special = RealmList<SpecialItem>()
    var mystery = RealmList<EquipmentSet>()
}
