package com.app.retrofitparsing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetQuestions {

    @Expose
    @SerializedName("quota_remaining")
    private int quotaRemaining;
    @Expose
    @SerializedName("quota_max")
    private int quotaMax;
    @Expose
    @SerializedName("has_more")
    private boolean hasMore;
    @Expose
    @SerializedName("items")
    private List<Items> items;

    public int getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public static class Owner {
        @Expose
        @SerializedName("link")
        private String link;
        @Expose
        @SerializedName("display_name")
        private String displayName;
        @Expose
        @SerializedName("profile_image")
        private String profileImage;
        @Expose
        @SerializedName("user_type")
        private String userType;
        @Expose
        @SerializedName("user_id")
        private int userId;
        @Expose
        @SerializedName("reputation")
        private int reputation;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getReputation() {
            return reputation;
        }

        public void setReputation(int reputation) {
            this.reputation = reputation;
        }
    }

    public static class Items {
        @Expose
        @SerializedName("body")
        private String body;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("closed_reason")
        private String closedReason;
        @Expose
        @SerializedName("link")
        private String link;
        @Expose
        @SerializedName("question_id")
        private int questionId;
        @Expose
        @SerializedName("last_edit_date")
        private int lastEditDate;
        @Expose
        @SerializedName("creation_date")
        private int creationDate;
        @Expose
        @SerializedName("last_activity_date")
        private int lastActivityDate;
        @Expose
        @SerializedName("score")
        private int score;
        @Expose
        @SerializedName("community_owned_date")
        private int communityOwnedDate;
        @Expose
        @SerializedName("answer_count")
        private int answerCount;
        @Expose
        @SerializedName("closed_date")
        private int closedDate;
        @Expose
        @SerializedName("protected_date")
        private int protectedDate;
        @Expose
        @SerializedName("view_count")
        private int viewCount;
        @Expose
        @SerializedName("is_answered")
        private boolean isAnswered;
        @Expose
        @SerializedName("owner")
        private Owner owner;
        @Expose
        @SerializedName("tags")
        private List<String> tags;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getClosedReason() {
            return closedReason;
        }

        public void setClosedReason(String closedReason) {
            this.closedReason = closedReason;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public int getLastEditDate() {
            return lastEditDate;
        }

        public void setLastEditDate(int lastEditDate) {
            this.lastEditDate = lastEditDate;
        }

        public int getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(int creationDate) {
            this.creationDate = creationDate;
        }

        public int getLastActivityDate() {
            return lastActivityDate;
        }

        public void setLastActivityDate(int lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCommunityOwnedDate() {
            return communityOwnedDate;
        }

        public void setCommunityOwnedDate(int communityOwnedDate) {
            this.communityOwnedDate = communityOwnedDate;
        }

        public int getAnswerCount() {
            return answerCount;
        }

        public void setAnswerCount(int answerCount) {
            this.answerCount = answerCount;
        }

        public int getClosedDate() {
            return closedDate;
        }

        public void setClosedDate(int closedDate) {
            this.closedDate = closedDate;
        }

        public int getProtectedDate() {
            return protectedDate;
        }

        public void setProtectedDate(int protectedDate) {
            this.protectedDate = protectedDate;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public boolean getIsAnswered() {
            return isAnswered;
        }

        public void setIsAnswered(boolean isAnswered) {
            this.isAnswered = isAnswered;
        }

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
