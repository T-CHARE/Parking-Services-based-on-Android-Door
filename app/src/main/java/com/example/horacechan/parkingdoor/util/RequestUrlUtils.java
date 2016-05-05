package com.example.horacechan.parkingdoor.util;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by HoraceChan on 2016/4/21.
 */
public class RequestUrlUtils {

    private RequestUrlUtils() {}

    public static class Builder {
        private boolean isHttp = true;

        private String hosturl;
        private String path;

        private HashMap<String, Object> params;

        public Builder(boolean isHttp) {
            this.isHttp = isHttp;
            params = new LinkedHashMap<>();
        }

        public Builder() {
            this(true);
        }

        public Builder setHost(String hosturl) {
            this.hosturl = hosturl;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder addParam(String key, Object value) {
            params.put(key, value);
            return this;
        }

        public String build() {
            String url;
            if (!TextUtils.isEmpty(path)) {
                url = hosturl + path + "?";
            }
            else {
                url = hosturl + "?";
            }
            int i = 0;
            Iterator iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entity = (Map.Entry<String, Object>) iterator.next();
                if (entity != null) {
                    if (i == 0) {
                        url += entity.getKey() + "=" + entity.getValue();
                    }
                    else {
                        url += "&" + entity.getKey() + "=" + entity.getValue();
                    }
                }
                i++;
            }
            return url;
        }
    }
}
