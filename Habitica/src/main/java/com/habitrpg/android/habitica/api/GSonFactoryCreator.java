package xyz.prfn.android.habitica.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import xyz.prfn.android.habitica.models.Achievement;
import xyz.prfn.android.habitica.models.ContentResult;
import xyz.prfn.android.habitica.models.FAQArticle;
import xyz.prfn.android.habitica.models.Skill;
import xyz.prfn.android.habitica.models.Tag;
import xyz.prfn.android.habitica.models.TutorialStep;
import xyz.prfn.android.habitica.models.WorldState;
import xyz.prfn.android.habitica.models.inventory.Customization;
import xyz.prfn.android.habitica.models.inventory.Equipment;
import xyz.prfn.android.habitica.models.inventory.Quest;
import xyz.prfn.android.habitica.models.inventory.QuestCollect;
import xyz.prfn.android.habitica.models.inventory.QuestDropItem;
import xyz.prfn.android.habitica.models.members.Member;
import xyz.prfn.android.habitica.models.social.Challenge;
import xyz.prfn.android.habitica.models.social.ChatMessage;
import xyz.prfn.android.habitica.models.social.FindUsernameResult;
import xyz.prfn.android.habitica.models.social.Group;
import xyz.prfn.android.habitica.models.tasks.GroupAssignedDetails;
import xyz.prfn.android.habitica.models.tasks.Task;
import xyz.prfn.android.habitica.models.tasks.TaskList;
import xyz.prfn.android.habitica.models.user.OwnedItem;
import xyz.prfn.android.habitica.models.user.OwnedMount;
import xyz.prfn.android.habitica.models.user.OwnedPet;
import xyz.prfn.android.habitica.models.user.Purchases;
import xyz.prfn.android.habitica.models.user.User;
import xyz.prfn.android.habitica.models.user.auth.SocialAuthentication;
import xyz.prfn.android.habitica.utils.AchievementListDeserializer;
import xyz.prfn.android.habitica.utils.AssignedDetailsDeserializer;
import xyz.prfn.android.habitica.utils.BooleanAsIntAdapter;
import xyz.prfn.android.habitica.utils.ChallengeDeserializer;
import xyz.prfn.android.habitica.utils.ChallengeListDeserializer;
import xyz.prfn.android.habitica.utils.ChatMessageDeserializer;
import xyz.prfn.android.habitica.utils.ContentDeserializer;
import xyz.prfn.android.habitica.utils.CustomizationDeserializer;
import xyz.prfn.android.habitica.utils.DateDeserializer;
import xyz.prfn.android.habitica.utils.EquipmentListDeserializer;
import xyz.prfn.android.habitica.utils.FAQArticleListDeserilializer;
import xyz.prfn.android.habitica.utils.FeedResponseDeserializer;
import xyz.prfn.android.habitica.utils.FindUsernameResultDeserializer;
import xyz.prfn.android.habitica.utils.GroupSerialization;
import xyz.prfn.android.habitica.utils.MemberSerialization;
import xyz.prfn.android.habitica.utils.NotificationDeserializer;
import xyz.prfn.android.habitica.utils.OwnedItemListDeserializer;
import xyz.prfn.android.habitica.utils.OwnedMountListDeserializer;
import xyz.prfn.android.habitica.utils.OwnedPetListDeserializer;
import xyz.prfn.android.habitica.utils.PurchasedDeserializer;
import xyz.prfn.android.habitica.utils.QuestCollectDeserializer;
import xyz.prfn.android.habitica.utils.QuestDeserializer;
import xyz.prfn.android.habitica.utils.QuestDropItemsListSerialization;
import xyz.prfn.android.habitica.utils.SkillDeserializer;
import xyz.prfn.android.habitica.utils.SocialAuthenticationDeserializer;
import xyz.prfn.android.habitica.utils.TaskListDeserializer;
import xyz.prfn.android.habitica.utils.TaskSerializer;
import xyz.prfn.android.habitica.utils.TaskTagDeserializer;
import xyz.prfn.android.habitica.utils.TutorialStepListDeserializer;
import xyz.prfn.android.habitica.utils.UserDeserializer;
import xyz.prfn.android.habitica.utils.WorldStateSerialization;
import com.habitrpg.common.habitica.models.Notification;
import com.habitrpg.shared.habitica.models.responses.FeedResponse;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import retrofit2.converter.gson.GsonConverterFactory;

public class GSonFactoryCreator {

    public static Gson createGson() {
        Type skillListType = new TypeToken<List<Skill>>() {
        }.getType();
        Type taskTagClassListType = new TypeToken<RealmList<Tag>>() {
        }.getType();
        Type customizationListType = new TypeToken<RealmList<Customization>>() {
        }.getType();
        Type tutorialStepListType = new TypeToken<RealmList<TutorialStep>>() {
        }.getType();
        Type faqArticleListType = new TypeToken<RealmList<FAQArticle>>() {
        }.getType();
        Type itemDataListType = new TypeToken<RealmList<Equipment>>() {
        }.getType();
        Type questCollectListType = new TypeToken<RealmList<QuestCollect>>() {
        }.getType();
        Type chatMessageListType = new TypeToken<RealmList<ChatMessage>>() {
        }.getType();
        Type challengeListType = new TypeToken<List<Challenge>>() {
        }.getType();
        Type challengeRealmListType = new TypeToken<RealmList<Challenge>>() {
        }.getType();
        Type questDropItemListType = new TypeToken<RealmList<QuestDropItem>>() {
        }.getType();
        Type ownedItemListType = new TypeToken<RealmList<OwnedItem>>() {
        }.getType();
        Type ownedPetListType = new TypeToken<RealmList<OwnedPet>>() {
        }.getType();
        Type ownedMountListType = new TypeToken<RealmList<OwnedMount>>() {
        }.getType();
        Type achievementsListType = new TypeToken<List<Achievement>>() {
        }.getType();
        Type assignedDetailsListType = new TypeToken<RealmList<GroupAssignedDetails>>() {
        }.getType();

        return new GsonBuilder()
                .registerTypeAdapter(taskTagClassListType, new TaskTagDeserializer())
                .registerTypeAdapter(Boolean.class, new BooleanAsIntAdapter())
                .registerTypeAdapter(boolean.class, new BooleanAsIntAdapter())
                .registerTypeAdapter(skillListType, new SkillDeserializer())
                .registerTypeAdapter(TaskList.class, new TaskListDeserializer())
                .registerTypeAdapter(Purchases.class, new PurchasedDeserializer())
                .registerTypeAdapter(customizationListType, new CustomizationDeserializer())
                .registerTypeAdapter(tutorialStepListType, new TutorialStepListDeserializer())
                .registerTypeAdapter(faqArticleListType, new FAQArticleListDeserilializer())
                .registerTypeAdapter(Group.class, new GroupSerialization())
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .registerTypeAdapter(itemDataListType, new EquipmentListDeserializer())
                .registerTypeAdapter(ChatMessage.class, new ChatMessageDeserializer())
                .registerTypeAdapter(Task.class, new TaskSerializer())
                .registerTypeAdapter(ContentResult.class, new ContentDeserializer())
                .registerTypeAdapter(FeedResponse.class, new FeedResponseDeserializer())
                .registerTypeAdapter(Challenge.class, new ChallengeDeserializer())
                .registerTypeAdapter(User.class, new UserDeserializer())
                .registerTypeAdapter(questCollectListType, new QuestCollectDeserializer())
                .registerTypeAdapter(challengeListType, new ChallengeListDeserializer())
                .registerTypeAdapter(challengeRealmListType, new ChallengeListDeserializer())
                .registerTypeAdapter(questDropItemListType, new QuestDropItemsListSerialization())
                .registerTypeAdapter(ownedItemListType, new OwnedItemListDeserializer())
                .registerTypeAdapter(ownedPetListType, new OwnedPetListDeserializer())
                .registerTypeAdapter(ownedMountListType, new OwnedMountListDeserializer())
                .registerTypeAdapter(achievementsListType, new AchievementListDeserializer())
                .registerTypeAdapter(assignedDetailsListType, new AssignedDetailsDeserializer())
                .registerTypeAdapter(Quest.class, new QuestDeserializer())
                .registerTypeAdapter(Member.class, new MemberSerialization())
                .registerTypeAdapter(WorldState.class, new WorldStateSerialization())
                .registerTypeAdapter(FindUsernameResult.class, new FindUsernameResultDeserializer())
                .registerTypeAdapter(Notification.class, new NotificationDeserializer())
                .registerTypeAdapter(SocialAuthentication.class, new SocialAuthenticationDeserializer())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .serializeNulls()
                .setLenient()
                .create();
    }

    public static GsonConverterFactory create() {
        return GsonConverterFactory.create(createGson());
    }
}
