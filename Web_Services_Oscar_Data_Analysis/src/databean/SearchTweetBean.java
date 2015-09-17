// databean.SearchTweet.java-----------------------------------
package databean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "twitter_jo" })
public class SearchTweetBean {
	@JsonProperty("twitter_jo")
	private TwitterJo twitterJo;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("twitter_jo")
	public TwitterJo getTwitterJo() {
		return twitterJo;
	}

	@JsonProperty("twitter_jo")
	public void setTwitterJo(TwitterJo twitterJo) {
		this.twitterJo = twitterJo;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Generated("org.jsonschema2pojo")
	@JsonPropertyOrder({ "statuses", "search_metadata" })
	public static class TwitterJo {

		@JsonProperty("statuses")
		private List<Status> statuses = new ArrayList<Status>();
		@JsonProperty("search_metadata")
		private SearchMetadata searchMetadata;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("statuses")
		public List<Status> getStatuses() {
			return statuses;
		}

		@JsonProperty("statuses")
		public void setStatuses(List<Status> statuses) {
			this.statuses = statuses;
		}

		@JsonProperty("search_metadata")
		public SearchMetadata getSearchMetadata() {
			return searchMetadata;
		}

		@JsonProperty("search_metadata")
		public void setSearchMetadata(SearchMetadata searchMetadata) {
			this.searchMetadata = searchMetadata;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

		// Status
		// -----------------------------------databean.Status.java-----------------------------------
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@Generated("org.jsonschema2pojo")
		@JsonPropertyOrder({ "contributors", "text", "geo", "retweeted",
				"in_reply_to_screen_name", "possibly_sensitive", "truncated",
				"lang", "entities", "in_reply_to_status_id_str", "id",
				"source", "in_reply_to_user_id_str", "favorited",
				"in_reply_to_status_id", "retweet_count", "created_at",
				"in_reply_to_user_id", "favorite_count", "id_str", "place",
				"user", "coordinates", "metadata" })
		public static class Status {

			@JsonProperty("contributors")
			private Object contributors;
			@JsonProperty("text")
			private String text;
			@JsonProperty("geo")
			private Object geo;
			@JsonProperty("retweeted")
			private Boolean retweeted;
			@JsonProperty("in_reply_to_screen_name")
			private Object inReplyToScreenName;
			@JsonProperty("possibly_sensitive")
			private Boolean possiblySensitive;
			@JsonProperty("truncated")
			private Boolean truncated;
			@JsonProperty("lang")
			private String lang;
			@JsonProperty("entities")
			private Entities entities;
			@JsonProperty("in_reply_to_status_id_str")
			private Object inReplyToStatusIdStr;
			@JsonProperty("id")
			private Long id;
			@JsonProperty("source")
			private String source;
			@JsonProperty("in_reply_to_user_id_str")
			private Object inReplyToUserIdStr;
			@JsonProperty("favorited")
			private Boolean favorited;
			@JsonProperty("in_reply_to_status_id")
			private Object inReplyToStatusId;
			@JsonProperty("retweet_count")
			private Integer retweetCount;
			@JsonProperty("created_at")
			private String createdAt;
			@JsonProperty("in_reply_to_user_id")
			private Object inReplyToUserId;
			@JsonProperty("favorite_count")
			private Integer favoriteCount;
			@JsonProperty("id_str")
			private String idStr;
			@JsonProperty("place")
			private Object place;
			@JsonProperty("user")
			private User user;
			@JsonProperty("coordinates")
			private Object coordinates;
			@JsonProperty("metadata")
			private Metadata metadata;
			@JsonIgnore
			private Map<String, Object> additionalProperties = new HashMap<String, Object>();

			@JsonProperty("contributors")
			public Object getContributors() {
				return contributors;
			}

			@JsonProperty("contributors")
			public void setContributors(Object contributors) {
				this.contributors = contributors;
			}

			@JsonProperty("text")
			public String getText() {
				return text;
			}

			@JsonProperty("text")
			public void setText(String text) {
				this.text = text;
			}

			@JsonProperty("geo")
			public Object getGeo() {
				return geo;
			}

			@JsonProperty("geo")
			public void setGeo(Object geo) {
				this.geo = geo;
			}

			@JsonProperty("retweeted")
			public Boolean getRetweeted() {
				return retweeted;
			}

			@JsonProperty("retweeted")
			public void setRetweeted(Boolean retweeted) {
				this.retweeted = retweeted;
			}

			@JsonProperty("in_reply_to_screen_name")
			public Object getInReplyToScreenName() {
				return inReplyToScreenName;
			}

			@JsonProperty("in_reply_to_screen_name")
			public void setInReplyToScreenName(Object inReplyToScreenName) {
				this.inReplyToScreenName = inReplyToScreenName;
			}

			@JsonProperty("possibly_sensitive")
			public Boolean getPossiblySensitive() {
				return possiblySensitive;
			}

			@JsonProperty("possibly_sensitive")
			public void setPossiblySensitive(Boolean possiblySensitive) {
				this.possiblySensitive = possiblySensitive;
			}

			@JsonProperty("truncated")
			public Boolean getTruncated() {
				return truncated;
			}

			@JsonProperty("truncated")
			public void setTruncated(Boolean truncated) {
				this.truncated = truncated;
			}

			@JsonProperty("lang")
			public String getLang() {
				return lang;
			}

			@JsonProperty("lang")
			public void setLang(String lang) {
				this.lang = lang;
			}

			@JsonProperty("entities")
			public Entities getEntities() {
				return entities;
			}

			@JsonProperty("entities")
			public void setEntities(Entities entities) {
				this.entities = entities;
			}

			@JsonProperty("in_reply_to_status_id_str")
			public Object getInReplyToStatusIdStr() {
				return inReplyToStatusIdStr;
			}

			@JsonProperty("in_reply_to_status_id_str")
			public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
				this.inReplyToStatusIdStr = inReplyToStatusIdStr;
			}

			@JsonProperty("id")
			public Long getId() {
				return id;
			}

			@JsonProperty("id")
			public void setId(Long id) {
				this.id = id;
			}

			@JsonProperty("source")
			public String getSource() {
				return source;
			}

			@JsonProperty("source")
			public void setSource(String source) {
				this.source = source;
			}

			@JsonProperty("in_reply_to_user_id_str")
			public Object getInReplyToUserIdStr() {
				return inReplyToUserIdStr;
			}

			@JsonProperty("in_reply_to_user_id_str")
			public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
				this.inReplyToUserIdStr = inReplyToUserIdStr;
			}

			@JsonProperty("favorited")
			public Boolean getFavorited() {
				return favorited;
			}

			@JsonProperty("favorited")
			public void setFavorited(Boolean favorited) {
				this.favorited = favorited;
			}

			@JsonProperty("in_reply_to_status_id")
			public Object getInReplyToStatusId() {
				return inReplyToStatusId;
			}

			@JsonProperty("in_reply_to_status_id")
			public void setInReplyToStatusId(Object inReplyToStatusId) {
				this.inReplyToStatusId = inReplyToStatusId;
			}

			@JsonProperty("retweet_count")
			public Integer getRetweetCount() {
				return retweetCount;
			}

			@JsonProperty("retweet_count")
			public void setRetweetCount(Integer retweetCount) {
				this.retweetCount = retweetCount;
			}

			@JsonProperty("created_at")
			public String getCreatedAt() {
				return createdAt;
			}

			@JsonProperty("created_at")
			public void setCreatedAt(String createdAt) {
				this.createdAt = createdAt;
			}

			@JsonProperty("in_reply_to_user_id")
			public Object getInReplyToUserId() {
				return inReplyToUserId;
			}

			@JsonProperty("in_reply_to_user_id")
			public void setInReplyToUserId(Object inReplyToUserId) {
				this.inReplyToUserId = inReplyToUserId;
			}

			@JsonProperty("favorite_count")
			public Integer getFavoriteCount() {
				return favoriteCount;
			}

			@JsonProperty("favorite_count")
			public void setFavoriteCount(Integer favoriteCount) {
				this.favoriteCount = favoriteCount;
			}

			@JsonProperty("id_str")
			public String getIdStr() {
				return idStr;
			}

			@JsonProperty("id_str")
			public void setIdStr(String idStr) {
				this.idStr = idStr;
			}

			@JsonProperty("place")
			public Object getPlace() {
				return place;
			}

			@JsonProperty("place")
			public void setPlace(Object place) {
				this.place = place;
			}

			@JsonProperty("user")
			public User getUser() {
				return user;
			}

			@JsonProperty("user")
			public void setUser(User user) {
				this.user = user;
			}

			@JsonProperty("coordinates")
			public Object getCoordinates() {
				return coordinates;
			}

			@JsonProperty("coordinates")
			public void setCoordinates(Object coordinates) {
				this.coordinates = coordinates;
			}

			@JsonProperty("metadata")
			public Metadata getMetadata() {
				return metadata;
			}

			@JsonProperty("metadata")
			public void setMetadata(Metadata metadata) {
				this.metadata = metadata;
			}

			@JsonAnyGetter
			public Map<String, Object> getAdditionalProperties() {
				return this.additionalProperties;
			}

			@JsonAnySetter
			public void setAdditionalProperty(String name, Object value) {
				this.additionalProperties.put(name, value);
			}

			// Entities
			// -----------------------------------databean.Entities.java-----------------------------------

			@JsonInclude(JsonInclude.Include.NON_NULL)
			@Generated("org.jsonschema2pojo")
			@JsonPropertyOrder({ "symbols", "urls", "hashtags", "user_mentions" })
			public static class Entities {

				@JsonProperty("symbols")
				private List<Object> symbols = new ArrayList<Object>();
				@JsonProperty("urls")
				private List<Object> urls = new ArrayList<Object>();
				@JsonProperty("hashtags")
				private List<Hashtag> hashtags = new ArrayList<Hashtag>();
				@JsonProperty("user_mentions")
				private List<Object> userMentions = new ArrayList<Object>();
				@JsonIgnore
				private Map<String, Object> additionalProperties = new HashMap<String, Object>();

				@JsonProperty("symbols")
				public List<Object> getSymbols() {
					return symbols;
				}

				@JsonProperty("symbols")
				public void setSymbols(List<Object> symbols) {
					this.symbols = symbols;
				}

				@JsonProperty("urls")
				public List<Object> getUrls() {
					return urls;
				}

				@JsonProperty("urls")
				public void setUrls(List<Object> urls) {
					this.urls = urls;
				}

				@JsonProperty("hashtags")
				public List<Hashtag> getHashtags() {
					return hashtags;
				}

				@JsonProperty("hashtags")
				public void setHashtags(List<Hashtag> hashtags) {
					this.hashtags = hashtags;
				}

				@JsonProperty("user_mentions")
				public List<Object> getUserMentions() {
					return userMentions;
				}

				@JsonProperty("user_mentions")
				public void setUserMentions(List<Object> userMentions) {
					this.userMentions = userMentions;
				}

				@JsonAnyGetter
				public Map<String, Object> getAdditionalProperties() {
					return this.additionalProperties;
				}

				@JsonAnySetter
				public void setAdditionalProperty(String name, Object value) {
					this.additionalProperties.put(name, value);
				}

				// HashTag
				// -----------------------------------databean.Hashtag.java-----------------------------------
				@JsonInclude(JsonInclude.Include.NON_NULL)
				@Generated("org.jsonschema2pojo")
				@JsonPropertyOrder({ "text", "indices" })
				public static class Hashtag {
					@JsonProperty("text")
					private String text;
					@JsonProperty("indices")
					private List<Long> indices = new ArrayList<Long>();
					@JsonIgnore
					private Map<String, Object> additionalProperties = new HashMap<String, Object>();

					@JsonProperty("text")
					public String getText() {
						return text;
					}

					@JsonProperty("text")
					public void setText(String text) {
						this.text = text;
					}

					@JsonProperty("indices")
					public List<Long> getIndices() {
						return indices;
					}

					@JsonProperty("indices")
					public void setIndices(List<Long> indices) {
						this.indices = indices;
					}

					@JsonAnyGetter
					public Map<String, Object> getAdditionalProperties() {
						return this.additionalProperties;
					}

					@JsonAnySetter
					public void setAdditionalProperty(String name, Object value) {
						this.additionalProperties.put(name, value);
					}
				}
			}

			// Metadata
			// -----------------------------------databean.Metadata.java-----------------------------------
			@JsonInclude(JsonInclude.Include.NON_NULL)
			@Generated("org.jsonschema2pojo")
			@JsonPropertyOrder({ "result_type", "iso_language_code" })
			public static class Metadata {
				@JsonProperty("result_type")
				private String resultType;
				@JsonProperty("iso_language_code")
				private String isoLanguageCode;
				@JsonIgnore
				private Map<String, Object> additionalProperties = new HashMap<String, Object>();

				@JsonProperty("result_type")
				public String getResultType() {
					return resultType;
				}

				@JsonProperty("result_type")
				public void setResultType(String resultType) {
					this.resultType = resultType;
				}

				@JsonProperty("iso_language_code")
				public String getIsoLanguageCode() {
					return isoLanguageCode;
				}

				@JsonProperty("iso_language_code")
				public void setIsoLanguageCode(String isoLanguageCode) {
					this.isoLanguageCode = isoLanguageCode;
				}

				@JsonAnyGetter
				public Map<String, Object> getAdditionalProperties() {
					return this.additionalProperties;
				}

				@JsonAnySetter
				public void setAdditionalProperty(String name, Object value) {
					this.additionalProperties.put(name, value);
				}
			}

			// User
			// -----------------------------------databean.User.java-----------------------------------

			@JsonInclude(JsonInclude.Include.NON_NULL)
			@Generated("org.jsonschema2pojo")
			@JsonPropertyOrder({ "location", "default_profile",
					"profile_background_tile", "statuses_count", "lang",
					"profile_link_color", "profile_banner_url", "id",
					"following", "protected", "profile_location",
					"favourites_count", "profile_text_color", "description",
					"verified", "contributors_enabled",
					"profile_sidebar_border_color", "name",
					"profile_background_color", "created_at",
					"is_translation_enabled", "default_profile_image",
					"followers_count", "profile_image_url_https",
					"geo_enabled", "profile_background_image_url",
					"profile_background_image_url_https",
					"follow_request_sent", "entities", "url", "utc_offset",
					"time_zone", "notifications",
					"profile_use_background_image", "friends_count",
					"profile_sidebar_fill_color", "screen_name", "id_str",
					"profile_image_url", "listed_count", "is_translator" })
			public static class User {
				@JsonProperty("location")
				private String location;
				@JsonProperty("default_profile")
				private Boolean defaultProfile;
				@JsonProperty("profile_background_tile")
				private Boolean profileBackgroundTile;
				@JsonProperty("statuses_count")
				private Integer statusesCount;
				@JsonProperty("lang")
				private String lang;
				@JsonProperty("profile_link_color")
				private String profileLinkColor;
				@JsonProperty("profile_banner_url")
				private String profileBannerUrl;
				@JsonProperty("id")
				private Long id;
				@JsonProperty("following")
				private Boolean following;
				@JsonProperty("protected")
				private Boolean _protected;
				@JsonProperty("profile_location")
				private Object profileLocation;
				@JsonProperty("favourites_count")
				private Integer favouritesCount;
				@JsonProperty("profile_text_color")
				private String profileTextColor;
				@JsonProperty("description")
				private String description;
				@JsonProperty("verified")
				private Boolean verified;
				@JsonProperty("contributors_enabled")
				private Boolean contributorsEnabled;
				@JsonProperty("profile_sidebar_border_color")
				private String profileSidebarBorderColor;
				@JsonProperty("name")
				private String name;
				@JsonProperty("profile_background_color")
				private String profileBackgroundColor;
				@JsonProperty("created_at")
				private String createdAt;
				@JsonProperty("is_translation_enabled")
				private Boolean isTranslationEnabled;
				@JsonProperty("default_profile_image")
				private Boolean defaultProfileImage;
				@JsonProperty("followers_count")
				private Integer followersCount;
				@JsonProperty("profile_image_url_https")
				private String profileImageUrlHttps;
				@JsonProperty("geo_enabled")
				private Boolean geoEnabled;
				@JsonProperty("profile_background_image_url")
				private String profileBackgroundImageUrl;
				@JsonProperty("profile_background_image_url_https")
				private String profileBackgroundImageUrlHttps;
				@JsonProperty("follow_request_sent")
				private Boolean followRequestSent;
				@JsonProperty("entities")
				private Entities_ entities;
				@JsonProperty("url")
				private Object url;
				@JsonProperty("utc_offset")
				private Integer utcOffset;
				@JsonProperty("time_zone")
				private String timeZone;
				@JsonProperty("notifications")
				private Boolean notifications;
				@JsonProperty("profile_use_background_image")
				private Boolean profileUseBackgroundImage;
				@JsonProperty("friends_count")
				private Integer friendsCount;
				@JsonProperty("profile_sidebar_fill_color")
				private String profileSidebarFillColor;
				@JsonProperty("screen_name")
				private String screenName;
				@JsonProperty("id_str")
				private String idStr;
				@JsonProperty("profile_image_url")
				private String profileImageUrl;
				@JsonProperty("listed_count")
				private Integer listedCount;
				@JsonProperty("is_translator")
				private Boolean isTranslator;
				@JsonIgnore
				private Map<String, Object> additionalProperties = new HashMap<String, Object>();

				@JsonProperty("location")
				public String getLocation() {
					return location;
				}

				@JsonProperty("location")
				public void setLocation(String location) {
					this.location = location;
				}

				@JsonProperty("default_profile")
				public Boolean getDefaultProfile() {
					return defaultProfile;
				}

				@JsonProperty("default_profile")
				public void setDefaultProfile(Boolean defaultProfile) {
					this.defaultProfile = defaultProfile;
				}

				@JsonProperty("profile_background_tile")
				public Boolean getProfileBackgroundTile() {
					return profileBackgroundTile;
				}

				@JsonProperty("profile_background_tile")
				public void setProfileBackgroundTile(
						Boolean profileBackgroundTile) {
					this.profileBackgroundTile = profileBackgroundTile;
				}

				@JsonProperty("statuses_count")
				public Integer getStatusesCount() {
					return statusesCount;
				}

				@JsonProperty("statuses_count")
				public void setStatusesCount(Integer statusesCount) {
					this.statusesCount = statusesCount;
				}

				@JsonProperty("lang")
				public String getLang() {
					return lang;
				}

				@JsonProperty("lang")
				public void setLang(String lang) {
					this.lang = lang;
				}

				@JsonProperty("profile_link_color")
				public String getProfileLinkColor() {
					return profileLinkColor;
				}

				@JsonProperty("profile_link_color")
				public void setProfileLinkColor(String profileLinkColor) {
					this.profileLinkColor = profileLinkColor;
				}

				@JsonProperty("profile_banner_url")
				public String getProfileBannerUrl() {
					return profileBannerUrl;
				}

				@JsonProperty("profile_banner_url")
				public void setProfileBannerUrl(String profileBannerUrl) {
					this.profileBannerUrl = profileBannerUrl;
				}

				@JsonProperty("id")
				public Long getId() {
					return id;
				}

				@JsonProperty("id")
				public void setId(Long id) {
					this.id = id;
				}

				@JsonProperty("following")
				public Boolean getFollowing() {
					return following;
				}

				@JsonProperty("following")
				public void setFollowing(Boolean following) {
					this.following = following;
				}

				@JsonProperty("protected")
				public Boolean getProtected() {
					return _protected;
				}

				@JsonProperty("protected")
				public void setProtected(Boolean _protected) {
					this._protected = _protected;
				}

				@JsonProperty("profile_location")
				public Object getProfileLocation() {
					return profileLocation;
				}

				@JsonProperty("profile_location")
				public void setProfileLocation(Object profileLocation) {
					this.profileLocation = profileLocation;
				}

				@JsonProperty("favourites_count")
				public Integer getFavouritesCount() {
					return favouritesCount;
				}

				@JsonProperty("favourites_count")
				public void setFavouritesCount(Integer favouritesCount) {
					this.favouritesCount = favouritesCount;
				}

				@JsonProperty("profile_text_color")
				public String getProfileTextColor() {
					return profileTextColor;
				}

				@JsonProperty("profile_text_color")
				public void setProfileTextColor(String profileTextColor) {
					this.profileTextColor = profileTextColor;
				}

				@JsonProperty("description")
				public String getDescription() {
					return description;
				}

				@JsonProperty("description")
				public void setDescription(String description) {
					this.description = description;
				}

				@JsonProperty("verified")
				public Boolean getVerified() {
					return verified;
				}

				@JsonProperty("verified")
				public void setVerified(Boolean verified) {
					this.verified = verified;
				}

				@JsonProperty("contributors_enabled")
				public Boolean getContributorsEnabled() {
					return contributorsEnabled;
				}

				@JsonProperty("contributors_enabled")
				public void setContributorsEnabled(Boolean contributorsEnabled) {
					this.contributorsEnabled = contributorsEnabled;
				}

				@JsonProperty("profile_sidebar_border_color")
				public String getProfileSidebarBorderColor() {
					return profileSidebarBorderColor;
				}

				@JsonProperty("profile_sidebar_border_color")
				public void setProfileSidebarBorderColor(
						String profileSidebarBorderColor) {
					this.profileSidebarBorderColor = profileSidebarBorderColor;
				}

				@JsonProperty("name")
				public String getName() {
					return name;
				}

				@JsonProperty("name")
				public void setName(String name) {
					this.name = name;
				}

				@JsonProperty("profile_background_color")
				public String getProfileBackgroundColor() {
					return profileBackgroundColor;
				}

				@JsonProperty("profile_background_color")
				public void setProfileBackgroundColor(
						String profileBackgroundColor) {
					this.profileBackgroundColor = profileBackgroundColor;
				}

				@JsonProperty("created_at")
				public String getCreatedAt() {
					return createdAt;
				}

				@JsonProperty("created_at")
				public void setCreatedAt(String createdAt) {
					this.createdAt = createdAt;
				}

				@JsonProperty("is_translation_enabled")
				public Boolean getIsTranslationEnabled() {
					return isTranslationEnabled;
				}

				@JsonProperty("is_translation_enabled")
				public void setIsTranslationEnabled(Boolean isTranslationEnabled) {
					this.isTranslationEnabled = isTranslationEnabled;
				}

				@JsonProperty("default_profile_image")
				public Boolean getDefaultProfileImage() {
					return defaultProfileImage;
				}

				@JsonProperty("default_profile_image")
				public void setDefaultProfileImage(Boolean defaultProfileImage) {
					this.defaultProfileImage = defaultProfileImage;
				}

				@JsonProperty("followers_count")
				public Integer getFollowersCount() {
					return followersCount;
				}

				@JsonProperty("followers_count")
				public void setFollowersCount(Integer followersCount) {
					this.followersCount = followersCount;
				}

				@JsonProperty("profile_image_url_https")
				public String getProfileImageUrlHttps() {
					return profileImageUrlHttps;
				}

				@JsonProperty("profile_image_url_https")
				public void setProfileImageUrlHttps(String profileImageUrlHttps) {
					this.profileImageUrlHttps = profileImageUrlHttps;
				}

				@JsonProperty("geo_enabled")
				public Boolean getGeoEnabled() {
					return geoEnabled;
				}

				@JsonProperty("geo_enabled")
				public void setGeoEnabled(Boolean geoEnabled) {
					this.geoEnabled = geoEnabled;
				}

				@JsonProperty("profile_background_image_url")
				public String getProfileBackgroundImageUrl() {
					return profileBackgroundImageUrl;
				}

				@JsonProperty("profile_background_image_url")
				public void setProfileBackgroundImageUrl(
						String profileBackgroundImageUrl) {
					this.profileBackgroundImageUrl = profileBackgroundImageUrl;
				}

				@JsonProperty("profile_background_image_url_https")
				public String getProfileBackgroundImageUrlHttps() {
					return profileBackgroundImageUrlHttps;
				}

				@JsonProperty("profile_background_image_url_https")
				public void setProfileBackgroundImageUrlHttps(
						String profileBackgroundImageUrlHttps) {
					this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
				}

				@JsonProperty("follow_request_sent")
				public Boolean getFollowRequestSent() {
					return followRequestSent;
				}

				@JsonProperty("follow_request_sent")
				public void setFollowRequestSent(Boolean followRequestSent) {
					this.followRequestSent = followRequestSent;
				}

				@JsonProperty("entities")
				public Entities_ getEntities() {
					return entities;
				}

				@JsonProperty("entities")
				public void setEntities(Entities_ entities) {
					this.entities = entities;
				}

				@JsonProperty("url")
				public Object getUrl() {
					return url;
				}

				@JsonProperty("url")
				public void setUrl(Object url) {
					this.url = url;
				}

				@JsonProperty("utc_offset")
				public Integer getUtcOffset() {
					return utcOffset;
				}

				@JsonProperty("utc_offset")
				public void setUtcOffset(Integer utcOffset) {
					this.utcOffset = utcOffset;
				}

				@JsonProperty("time_zone")
				public String getTimeZone() {
					return timeZone;
				}

				@JsonProperty("time_zone")
				public void setTimeZone(String timeZone) {
					this.timeZone = timeZone;
				}

				@JsonProperty("notifications")
				public Boolean getNotifications() {
					return notifications;
				}

				@JsonProperty("notifications")
				public void setNotifications(Boolean notifications) {
					this.notifications = notifications;
				}

				@JsonProperty("profile_use_background_image")
				public Boolean getProfileUseBackgroundImage() {
					return profileUseBackgroundImage;
				}

				@JsonProperty("profile_use_background_image")
				public void setProfileUseBackgroundImage(
						Boolean profileUseBackgroundImage) {
					this.profileUseBackgroundImage = profileUseBackgroundImage;
				}

				@JsonProperty("friends_count")
				public Integer getFriendsCount() {
					return friendsCount;
				}

				@JsonProperty("friends_count")
				public void setFriendsCount(Integer friendsCount) {
					this.friendsCount = friendsCount;
				}

				@JsonProperty("profile_sidebar_fill_color")
				public String getProfileSidebarFillColor() {
					return profileSidebarFillColor;
				}

				@JsonProperty("profile_sidebar_fill_color")
				public void setProfileSidebarFillColor(
						String profileSidebarFillColor) {
					this.profileSidebarFillColor = profileSidebarFillColor;
				}

				@JsonProperty("screen_name")
				public String getScreenName() {
					return screenName;
				}

				@JsonProperty("screen_name")
				public void setScreenName(String screenName) {
					this.screenName = screenName;
				}

				@JsonProperty("id_str")
				public String getIdStr() {
					return idStr;
				}

				@JsonProperty("id_str")
				public void setIdStr(String idStr) {
					this.idStr = idStr;
				}

				@JsonProperty("profile_image_url")
				public String getProfileImageUrl() {
					return profileImageUrl;
				}

				@JsonProperty("profile_image_url")
				public void setProfileImageUrl(String profileImageUrl) {
					this.profileImageUrl = profileImageUrl;
				}

				@JsonProperty("listed_count")
				public Integer getListedCount() {
					return listedCount;
				}

				@JsonProperty("listed_count")
				public void setListedCount(Integer listedCount) {
					this.listedCount = listedCount;
				}

				@JsonProperty("is_translator")
				public Boolean getIsTranslator() {
					return isTranslator;
				}

				@JsonProperty("is_translator")
				public void setIsTranslator(Boolean isTranslator) {
					this.isTranslator = isTranslator;
				}

				@JsonAnyGetter
				public Map<String, Object> getAdditionalProperties() {
					return this.additionalProperties;
				}

				@JsonAnySetter
				public void setAdditionalProperty(String name, Object value) {
					this.additionalProperties.put(name, value);
				}

				// Entities_
				// -----------------------------------databean.Entities_.java-----------------------------------
				@JsonInclude(JsonInclude.Include.NON_NULL)
				@Generated("org.jsonschema2pojo")
				@JsonPropertyOrder({ "url", "description" })
				public static class Entities_ {
					@JsonProperty("url")
					private Url url;
					@JsonProperty("description")
					private Description description;
					@JsonIgnore
					private Map<String, Object> additionalProperties = new HashMap<String, Object>();

					@JsonProperty("url")
					public Url getUrl() {
						return url;
					}

					@JsonProperty("url")
					public void setUrl(Url url) {
						this.url = url;
					}

					@JsonProperty("description")
					public Description getDescription() {
						return description;
					}

					@JsonProperty("description")
					public void setDescription(Description description) {
						this.description = description;
					}

					@JsonAnyGetter
					public Map<String, Object> getAdditionalProperties() {
						return this.additionalProperties;
					}

					@JsonAnySetter
					public void setAdditionalProperty(String name, Object value) {
						this.additionalProperties.put(name, value);
					}

					// URL
					// -----------------------------------databean.Url.java-----------------------------------
					@JsonInclude(JsonInclude.Include.NON_NULL)
					@Generated("org.jsonschema2pojo")
					@JsonPropertyOrder({ "urls" })
					public static class Url {
						@JsonProperty("urls")
						private List<Url_> urls = new ArrayList<Url_>();
						@JsonIgnore
						private Map<String, Object> additionalProperties = new HashMap<String, Object>();

						@JsonProperty("urls")
						public List<Url_> getUrls() {
							return urls;
						}

						@JsonProperty("urls")
						public void setUrls(List<Url_> urls) {
							this.urls = urls;
						}

						@JsonAnyGetter
						public Map<String, Object> getAdditionalProperties() {
							return this.additionalProperties;
						}

						@JsonAnySetter
						public void setAdditionalProperty(String name,
								Object value) {
							this.additionalProperties.put(name, value);
						}

						// -----------------------------------databean.Url_.java-----------------------------------
						@JsonInclude(JsonInclude.Include.NON_NULL)
						@Generated("org.jsonschema2pojo")
						@JsonPropertyOrder({ "expanded_url", "url", "indices" })
						public static class Url_ {
							@JsonProperty("expanded_url")
							private Object expandedUrl;
							@JsonProperty("url")
							private String url;
							@JsonProperty("indices")
							private List<Long> indices = new ArrayList<Long>();
							@JsonIgnore
							private Map<String, Object> additionalProperties = new HashMap<String, Object>();

							@JsonProperty("expanded_url")
							public Object getExpandedUrl() {
								return expandedUrl;
							}

							@JsonProperty("expanded_url")
							public void setExpandedUrl(Object expandedUrl) {
								this.expandedUrl = expandedUrl;
							}

							@JsonProperty("url")
							public String getUrl() {
								return url;
							}

							@JsonProperty("url")
							public void setUrl(String url) {
								this.url = url;
							}

							@JsonProperty("indices")
							public List<Long> getIndices() {
								return indices;
							}

							@JsonProperty("indices")
							public void setIndices(List<Long> indices) {
								this.indices = indices;
							}

							@JsonAnyGetter
							public Map<String, Object> getAdditionalProperties() {
								return this.additionalProperties;
							}

							@JsonAnySetter
							public void setAdditionalProperty(String name,
									Object value) {
								this.additionalProperties.put(name, value);
							}

						}

					}

					// Description
					@JsonInclude(JsonInclude.Include.NON_NULL)
					@Generated("org.jsonschema2pojo")
					@JsonPropertyOrder({ "urls" })
					public static class Description {
						@JsonProperty("urls")
						private List<Object> urls = new ArrayList<Object>();
						@JsonIgnore
						private Map<String, Object> additionalProperties = new HashMap<String, Object>();

						@JsonProperty("urls")
						public List<Object> getUrls() {
							return urls;
						}

						@JsonProperty("urls")
						public void setUrls(List<Object> urls) {
							this.urls = urls;
						}

						@JsonAnyGetter
						public Map<String, Object> getAdditionalProperties() {
							return this.additionalProperties;
						}

						@JsonAnySetter
						public void setAdditionalProperty(String name,
								Object value) {
							this.additionalProperties.put(name, value);
						}
					}
				}

			}

		}

		// SearchMetaData
		// -----------------------------------databean.SearchMetadata.java-----------------------------------
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@Generated("org.jsonschema2pojo")
		@JsonPropertyOrder({ "max_id", "since_id", "refresh_url",
				"next_results", "count", "completed_in", "since_id_str",
				"query", "max_id_str" })
		public static class SearchMetadata {
			@JsonProperty("max_id")
			private Long maxId;
			@JsonProperty("since_id")
			private Long sinceId;
			@JsonProperty("refresh_url")
			private String refreshUrl;
			@JsonProperty("next_results")
			private String nextResults;
			@JsonProperty("count")
			private Long count;
			@JsonProperty("completed_in")
			private Float completedIn;
			@JsonProperty("since_id_str")
			private String sinceIdStr;
			@JsonProperty("query")
			private String query;
			@JsonProperty("max_id_str")
			private String maxIdStr;
			@JsonIgnore
			private Map<String, Object> additionalProperties = new HashMap<String, Object>();

			@JsonProperty("max_id")
			public Long getMaxId() {
				return maxId;
			}

			@JsonProperty("max_id")
			public void setMaxId(Long maxId) {
				this.maxId = maxId;
			}

			@JsonProperty("since_id")
			public Long getSinceId() {
				return sinceId;
			}

			@JsonProperty("since_id")
			public void setSinceId(Long sinceId) {
				this.sinceId = sinceId;
			}

			@JsonProperty("refresh_url")
			public String getRefreshUrl() {
				return refreshUrl;
			}

			@JsonProperty("refresh_url")
			public void setRefreshUrl(String refreshUrl) {
				this.refreshUrl = refreshUrl;
			}

			@JsonProperty("next_results")
			public String getNextResults() {
				return nextResults;
			}

			@JsonProperty("next_results")
			public void setNextResults(String nextResults) {
				this.nextResults = nextResults;
			}

			@JsonProperty("count")
			public Long getCount() {
				return count;
			}

			@JsonProperty("count")
			public void setCount(Long count) {
				this.count = count;
			}

			@JsonProperty("completed_in")
			public Float getCompletedIn() {
				return completedIn;
			}

			@JsonProperty("completed_in")
			public void setCompletedIn(Float completedIn) {
				this.completedIn = completedIn;
			}

			@JsonProperty("since_id_str")
			public String getSinceIdStr() {
				return sinceIdStr;
			}

			@JsonProperty("since_id_str")
			public void setSinceIdStr(String sinceIdStr) {
				this.sinceIdStr = sinceIdStr;
			}

			@JsonProperty("query")
			public String getQuery() {
				return query;
			}

			@JsonProperty("query")
			public void setQuery(String query) {
				this.query = query;
			}

			@JsonProperty("max_id_str")
			public String getMaxIdStr() {
				return maxIdStr;
			}

			@JsonProperty("max_id_str")
			public void setMaxIdStr(String maxIdStr) {
				this.maxIdStr = maxIdStr;
			}

			@JsonAnyGetter
			public Map<String, Object> getAdditionalProperties() {
				return this.additionalProperties;
			}

			@JsonAnySetter
			public void setAdditionalProperty(String name, Object value) {
				this.additionalProperties.put(name, value);
			}

		}
	}

}
