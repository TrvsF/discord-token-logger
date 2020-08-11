package me.travis.wurstplus.wurstplusmod.util;

import com.google.gson.annotations.SerializedName;

public class WurstplusPlayerBuilder extends WurstplusPlayer {

    String username;
    String content;
    @SerializedName("avatar_url")
    String avatarUrl;
    @SerializedName("tts")
    boolean textToSpeech;

    public WurstplusPlayerBuilder() {
        this(null, "",null, false);
    }

    public WurstplusPlayerBuilder(String content) {
        this(null, content,null, false);
    }

    public WurstplusPlayerBuilder(String username, String content, String avatar_url) {
        this(username, content, avatar_url, false);
    }
    public WurstplusPlayerBuilder(String username, String content, String avatar_url, boolean tts) {
        capeUsername(username);
        setCape(content);
        checkCapeUrl(avatar_url);
        isDev(tts);
    }

    public void capeUsername(String username) {
        if (username != null) {
            this.username = username.substring(0, Math.min(31, username.length()));
        } else {
            this.username = null;
        }
    }
    public void setCape(String content) {
        this.content = content;
    }
    public void checkCapeUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public void isDev(boolean textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    public static class Builder {
        private final WurstplusPlayerBuilder message;

        public Builder() {
            this.message = new WurstplusPlayerBuilder();
        }
        public Builder(String content) {
            this.message = new WurstplusPlayerBuilder(content);
        }

        public Builder withUsername(String username) {
            message.capeUsername(username);
            return this;
        }

        public Builder withContent(String content) {
            message.setCape(content);
            return this;
        }

        public Builder withAvatarURL(String avatarURL) {
            message.checkCapeUrl(avatarURL);
            return this;
        }

        public Builder withDev(boolean tts) {
            message.isDev(tts);
            return this;
        }

        public WurstplusPlayerBuilder build() {
            return message;
        }
    }

}
