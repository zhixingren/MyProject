package com.mysummary.myproject.android_basis.net.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Cookie;
import okhttp3.HttpUrl;
/**
 * Created by <a href="http://www.jiechic.com" target="_blank">jiechic</a> on 15/5/27.
 */

/**
 * A persistent cookie store which implements the Apache HttpClient CookieStore interface.
 * Cookies are stored and will persist on the user's device between application sessions since they
 * are serialized and stored in SharedPreferences. Instances of this class are
 * designed to be used with AsyncHttpClient#setCookieStore, but can also be used with a
 * regular old apache HttpClient/HttpContext if you prefer.
 */
public class PersistentCookieStore {

    private static final String LOG_TAG = "PersistentCookieStore";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String COOKIE_NAME_PREFIX = "cookie_";

    private Map<String, ConcurrentHashMap<String, Cookie>> cookies = null;
    private SharedPreferences cookiePrefs = null;

    private static PersistentCookieStore mPersistentCookieStore;

    private static Context sContext;

    /**
     * Construct a persistent cookie store.
     *
     * @param context Context to attach cookie store to
     */
    private PersistentCookieStore(Context context) {
        sContext = context.getApplicationContext();
        if (cookiePrefs == null) {
            cookiePrefs = sContext.getSharedPreferences(COOKIE_PREFS, 0);
        }
        if (cookies == null) {
            cookies = new HashMap<String, ConcurrentHashMap<String, Cookie>>();
        }
        // Load any previously stored cookies into the store
        Map<String, ?> prefsMap = cookiePrefs.getAll();
        for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
            if (entry.getValue() != null && !((String) entry.getValue()).startsWith(COOKIE_NAME_PREFIX)) {
                String[] cookieNames = TextUtils.split((String) entry.getValue(), ",");
                for (String name : cookieNames) {
                    String encodedCookie = cookiePrefs.getString(COOKIE_NAME_PREFIX + name, null);
                    if (encodedCookie != null) {
                        Cookie decodedCookie = decodeCookie(encodedCookie);
                        if (decodedCookie != null) {
                            if (!cookies.containsKey(entry.getKey()))
                                cookies.put(entry.getKey(), new ConcurrentHashMap<String, Cookie>());
                            cookies.get(entry.getKey()).put(name, decodedCookie);
                        }
                    }
                }

            }
        }
    }


    public static PersistentCookieStore getInstance(Context applicationContext) {
        if (mPersistentCookieStore == null) {
            synchronized (PersistentCookieStore.class){
                if (mPersistentCookieStore == null) {
                    mPersistentCookieStore=new PersistentCookieStore(applicationContext);
                }
            }
        }
        return mPersistentCookieStore;
    }


    public void add(HttpUrl uri, Cookie cookie) {

        // Save cookie into local store, or remove if expired
        if (!cookie.persistent()) {
            if (!cookies.containsKey(cookie.domain()))
                cookies.put(cookie.domain(), new ConcurrentHashMap<String, Cookie>());
            cookies.get(cookie.domain()).put(cookie.name(), cookie);
        } else {
            if (cookies.containsKey(cookie.domain()))
                cookies.get(cookie.domain()).remove(cookie.domain());
        }

        // Save cookie into persistent store
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
//        ConcurrentHashMap<String, Cookie> myCookies=cookies.get(uri.host());
        prefsWriter.putString(uri.host(), cookie.name());
//        prefsWriter.putString(cookie.domain(), TextUtils.join(",", cookies.get(cookie.domain()).keySet()));
        prefsWriter.putString(COOKIE_NAME_PREFIX + cookie.name(), encodeCookie(new SerializableOkHttpCookies(cookie)));
        prefsWriter.commit();
        String encodedCookie = cookiePrefs.getString(COOKIE_NAME_PREFIX + cookie.name(), null);
        Cookie decodedCookie = decodeCookie(encodedCookie);
        Log.d(LOG_TAG, "==>save cookie :" + uri.host() + "  "+ cookie.name() + "   " + decodedCookie);

    }

    protected String getCookieToken(HttpUrl uri, HttpCookie cookie) {
        return cookie.getName() + cookie.getDomain();
    }

    public List<Cookie> get(HttpUrl uri) {
        ArrayList<Cookie> ret = new ArrayList<Cookie>();
        for (String key : cookies.keySet()) {
            if (uri.host().contains(key)) {
                ret.addAll(cookies.get(key).values());
                Log.d(LOG_TAG, "==>get cookie :" + uri.host() +cookies.get(key).values());
            }
        }
        return ret;
    }

    public boolean removeAll() {
        SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
        prefsWriter.clear();
        prefsWriter.commit();
        cookies.clear();
        return true;
    }


    public boolean remove(HttpUrl uri, HttpCookie cookie) {
        String name = getCookieToken(uri, cookie);

        if (cookies.containsKey(uri.host()) && cookies.get(uri.host()).containsKey(name)) {
            cookies.get(uri.host()).remove(name);

            SharedPreferences.Editor prefsWriter = cookiePrefs.edit();
            if (cookiePrefs.contains(COOKIE_NAME_PREFIX + name)) {
                prefsWriter.remove(COOKIE_NAME_PREFIX + name);
            }
            prefsWriter.putString(uri.host(), TextUtils.join(",", cookies.get(uri.host()).keySet()));
            prefsWriter.commit();

            return true;
        } else {
            return false;
        }
    }

    public List<Cookie> getCookies() {
        ArrayList<Cookie> ret = new ArrayList<Cookie>();
        for (String key : cookies.keySet())
            ret.addAll(cookies.get(key).values());

        return ret;
    }

    public List<URI> getURIs() {
        ArrayList<URI> ret = new ArrayList<URI>();
        for (String key : cookies.keySet())
            try {
                ret.add(new URI(key));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        return ret;
    }

    /**
     * Serializes Cookie object into String
     *
     * @param cookie cookie to be encoded, can be null
     * @return cookie encoded as String
     */
    protected String encodeCookie(SerializableOkHttpCookies cookie) {
        if (cookie == null)
            return null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(os);
            outputStream.writeObject(cookie);
        } catch (IOException e) {
            Log.d(LOG_TAG, "IOException in encodeCookie", e);
            return null;
        }

        return byteArrayToHexString(os.toByteArray());
    }

    /**
     * Returns cookie decoded from cookie string
     *
     * @param cookieString string of cookie as returned from http request
     * @return decoded cookie or null if exception occured
     */
    protected Cookie decodeCookie(String cookieString) {
        byte[] bytes = hexStringToByteArray(cookieString);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Cookie cookie = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            cookie = ((SerializableOkHttpCookies) objectInputStream.readObject()).getCookies();
        } catch (IOException e) {
            Log.d(LOG_TAG, "IOException in decodeCookie", e);
        } catch (ClassNotFoundException e) {
            Log.d(LOG_TAG, "ClassNotFoundException in decodeCookie", e);
        }

        return cookie;
    }

    /**
     * Using some super basic byte array <-> hex conversions so we don't have to rely on any
     * large Base64 libraries. Can be overridden if you like!
     *
     * @param bytes byte array to be converted
     * @return string containing hex values
     */
    protected String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte element : bytes) {
            int v = element & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    /**
     * Converts hex values from strings to byte arra
     *
     * @param hexString string of hex-encoded values
     * @return decoded byte array
     */
    protected byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}